-- Active: 1719160991296@@127.0.0.1@1433@AdventureWorks2022

DROP PROCEDURE IF EXISTS "Purchasing"."sp_NEW_PURCHASE_ORDER";
CREATE OR ALTER PROCEDURE "Purchasing"."sp_NEW_PURCHASE_ORDER"
    -- PurchaseOrderHeader
    @EmployeeID INT,
    @VendorID INT,
    @ShipMethodID INT,

    -- PurchaseOrderDetail
    @DueDate DATETIME,
    @OrderQty SMALLINT,
    @ProductID INT
AS
BEGIN
    DECLARE 
        @ReceivedQty DECIMAL(8, 2) = 0,
        @RejectedQty DECIMAL(8, 2) = 0,
        @PurchaseOrderID INT;

    BEGIN TRANSACTION;
    BEGIN TRY
        -- Locking SalesOrderHeader and SalesOrderDetail tables
        SELECT 1 FROM "Purchasing"."PurchaseOrderHeader" WITH (TABLOCKX, HOLDLOCK);
        SELECT 1 FROM "Purchasing"."PurchaseOrderDetail" WITH (TABLOCKX, HOLDLOCK);
        SELECT 1 FROM "Production"."ProductInventory" WITH (TABLOCKX, HOLDLOCK);

        INSERT INTO "Purchasing"."PurchaseOrderHeader"
        ("EmployeeID", "VendorID", "ShipMethodID")
        VALUES 
        (
            @EmployeeID,
            @VendorID,
            @ShipMethodID
        );
        SET @PurchaseOrderID = SCOPE_IDENTITY();

        -- This shouldn't really happening in the real world, but just for the sake of the simulation
        -- we will assume that the order is received in full.
        SET @ReceivedQty = @OrderQty;

        -- record the purchase details
        INSERT INTO "Purchasing"."PurchaseOrderDetail"
        ("PurchaseOrderID", "DueDate", "OrderQty", "ProductID", "UnitPrice", "ReceivedQty", "RejectedQty")
        VALUES (
            @PurchaseOrderID,
            @DueDate,
            @OrderQty,
            @ProductID,
            "Production".GetProductStandardCost(@ProductID),
            @ReceivedQty,
            @RejectedQty
        );

        -- update the inventory, again for the sake of simulation, we will assume the location that will be restocked is the location that had the least inventory
        UPDATE "Production"."ProductInventory"
        SET "Quantity" = "Quantity" + @ReceivedQty
        WHERE "ProductID" = @ProductID
        AND "LocationID" = (
            SELECT TOP 1 "LocationID"
            FROM "Production"."ProductInventory"
            WHERE "ProductID" = @ProductID
            ORDER BY "Quantity" ASC
        );

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