CREATE OR ALTER TRIGGER ReStock 
ON "Production"."ProductInventory"
FOR UPDATE
AS
BEGIN
    DECLARE
        @EmployeeID INT,
        @SafetyStockLevel INT,
        @DueDate DATETIME,
        @OrderQty INT,
        @VendorID INT,
        @InventoryLevel INT, 
        @ProductID INT,
        @ReorderPoint SMALLINT,
        @ShipMethodID INT,
        @IsFinisedGoods BIT;

    -- FinishedGoods = 0 = Product is not a salable item. 1 = Product is salable.
    -- ReorderPoint =  Inventory level that triggers a purchase order or work order.
    SELECT @ProductID = INSERTED."ProductID"
    FROM INSERTED;

    SELECT 
        @IsFinisedGoods = PI."FinishedGoodsFlag",
        @ReorderPoint = PI."ReorderPoint",
        @SafetyStockLevel = PI."SafetyStockLevel"
    FROM "Production"."Product" AS PI
    WHERE PI."ProductID" = @ProductID;

    SELECT
        @InventoryLevel = SUM(PI."Quantity")
    FROM "Production"."ProductInventory" AS PI
    WHERE PI."ProductID" = @ProductID;

    IF @ReorderPoint < @InventoryLevel
        RETURN;

    IF @IsFinisedGoods <> 1
        RETURN; -- instead of purchase order, we would execute work order for the product but its out of the assignment's scope

    SET @VendorID = (
        CASE 
            WHEN EXISTS (
                SELECT 1
                FROM "Purchasing"."ProductVendor" AS PV
                JOIN "Purchasing"."Vendor" AS V
                    ON PV."BusinessEntityID" = V."BusinessEntityID"
                WHERE
                    PV."ProductID" = @ProductID AND
                    V."ActiveFlag" = 1 AND 
                    V."PreferredVendorStatus" = 1
            ) THEN (SELECT "Purchasing".GetActiveHighestCreditVendor(@ProductID, 1))
            ELSE (SELECT "Purchasing".GetActiveHighestCreditVendor(@ProductID, 0))
        END
    );

    SET @EmployeeID = (SELECT TOP 1 "BusinessEntityID" FROM "HumanResources"."Employee" WHERE "JobTitle" = 'Purchasing Manager');
    SET @ShipMethodID = CAST((RAND() * 5) + 1 AS INT);   -- Random >= 1 and <= 5
    SET @DueDate = DATEADD(DAY, 7, GETDATE());           -- 7 days from now
    SET @OrderQty = @SafetyStockLevel - @InventoryLevel;

    BEGIN TRY
        EXEC "Purchasing"."sp_NEW_PURCHASE_ORDER"
            @EmployeeID = @EmployeeID,
            @VendorID = @VendorID,
            @ShipMethodID = @ShipMethodID,
            @DueDate = @DueDate,
            @OrderQty = @OrderQty,
            @ProductID = @ProductID;
    END TRY
    BEGIN CATCH
        INSERT INTO ERRORLOG(UserName, ErrorNumber, ErrorMessage)
        VALUES (SUSER_SNAME(), 50001, 'error when restock product: ' + ISNULL(CAST(@ProductID AS VARCHAR(10)), 0) + ', Error: ' + ERROR_MESSAGE());
    END CATCH;
END;
