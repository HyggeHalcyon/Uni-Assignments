-- Active: 1719160991296@@127.0.0.1@1433@AdventureWorks2022

DROP PROCEDURE IF EXISTS "Sales"."sp_NEW_SALES_ORDER";
CREATE OR ALTER PROCEDURE "Sales"."sp_NEW_SALES_ORDER"
    -- SalesOrderHeader
    @CustomerID INT,
    @SalesPersonID INT = NULL,
    @BillAddressID INT,
    @ShipAddressID INT,
    @ShipMethodID INT,
    @CreditCardID INT = NULL,
    @CurrencyRateID INT = NULL,

    -- SalesOrderDetail
    @OrderDetails SalesOrderDetailType READONLY,
    @OnlineOrderFlag BIT = 0
AS 
BEGIN 
    DECLARE 
        @TerritoryID INT,
        @SalesOrderID INT,
        @OrderQty INT, 
        @ProductID INT, 
        @SpecialOfferID INT,
        @TaxRate MONEY,
        @Discount MONEY;

    BEGIN TRANSACTION;
    BEGIN TRY
        -- Locking SalesOrderHeader and SalesOrderDetail tables
        SELECT 1 FROM "Sales"."SalesOrderHeader" WITH (TABLOCKX, HOLDLOCK);
        SELECT 1 FROM "Sales"."SalesOrderDetail" WITH (TABLOCKX, HOLDLOCK);
        SELECT 1 FROM "Production"."ProductInventory" WITH (TABLOCKX, HOLDLOCK);

        IF @OnlineOrderFlag = 1
            SET @TerritoryID = "Person".GetPersonTeritoryID(@CustomerID, 1)
        ELSE
            SET @TerritoryID = "Person".GetPersonTeritoryID(@SalesPersonID, 2)
        
        IF @TerritoryID = -1
            THROW 510001, 'teritory not found for this customer/sales person', 1;

        INSERT INTO "Sales"."SalesOrderHeader"
        ("DueDate", "OnlineOrderFlag", "CustomerID", "SalesPersonID", "TerritoryID", "BillToAddressID", "ShipToAddressID", "ShipMethodID", "CreditCardID", "CurrencyRateID")
        VALUES 
        (
            DATEADD(DAY, 7, GETDATE()), -- 7 days due date
            1,                          -- Order placed online by customer
            @CustomerID,
            @SalesPersonID,
            @TerritoryID,
            @BillAddressID,
            @ShipAddressID,
            @ShipMethodID,
            @CreditCardID,
            @CurrencyRateID
        );

        -- Retrieve the inserted SalesOrderID
        SET @SalesOrderID = SCOPE_IDENTITY();

        -- Assuming tax is calculated based on ShipAddressID
        IF @ShipAddressID <> 0
            UPDATE "Sales"."SalesOrderHeader"
            SET "TaxAmt" = "Sales".GetAddressTaxRate(@ShipAddressID)
            WHERE "SalesOrderID" = @SalesOrderID;

        -- Cursor to handle/iterate multiple rows in @OrderDetails
        DECLARE OrderCursor CURSOR LOCAL STATIC READ_ONLY FORWARD_ONLY
            FOR SELECT OrderQty, ProductID, SpecialOfferID FROM @OrderDetails;

        OPEN OrderCursor;
        FETCH NEXT FROM OrderCursor INTO @OrderQty, @ProductID, @SpecialOfferID;

        WHILE @@FETCH_STATUS = 0
            BEGIN
            
                SET @Discount = "Sales".GetProductSpecialOfferDiscount(@OrderQty, @ProductID, @SpecialOfferID);
                IF @Discount = -1
                    THROW 510002, 'special offer is not applicable', 1;
                
                INSERT INTO "Sales"."SalesOrderDetail"
                ("SalesOrderID", "OrderQty", "ProductID", "SpecialOfferID", "UnitPrice", "UnitPriceDiscount")
                VALUES( 
                    @SalesOrderID,
                    @OrderQty,
                    @ProductID,
                    @SpecialOfferID,
                    "Production".GetProductStandardCost(@ProductID),
                    @Discount
                ); 

                -- reduce the stock level
                UPDATE "Production"."ProductInventory"
                SET "Quantity" = "Quantity" - @OrderQty
                WHERE "ProductID" = @ProductID
                AND "Quantity" = (SELECT MAX(PI2."Quantity")
                                    FROM "Production"."ProductInventory" PI2
                                    WHERE PI2."ProductID" = @ProductID);

                FETCH NEXT FROM OrderCursor INTO @OrderQty, @ProductID, @SpecialOfferID;
            END;

        CLOSE OrderCursor;
        DEALLOCATE OrderCursor;

        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRANSACTION;  
        DECLARE @ErrorMessage NVARCHAR(4000), @ErrorState INT;

        SELECT 
            @ErrorMessage = ERROR_MESSAGE(),
            @ErrorState = ERROR_STATE();

        -- Throw the error again to propagate it
        THROW 77777, @ErrorMessage, @ErrorState;
    END CATCH
END;
