CREATE OR ALTER PROCEDURE "Sales"."sp_TEST_ONLINE_SALES"
AS 
BEGIN
    DECLARE @ShouldSuccess AS "Sales"."SalesOrderDetailType"
    DECLARE @ShouldFail AS "Sales"."SalesOrderDetailType"

    INSERT INTO @ShouldSuccess (OrderQty, ProductID, SpecialOfferID)
    VALUES
        (2, 921, 1),
        (1, 774, 7),
        (1, 988, 16)

    INSERT INTO @ShouldFail (OrderQty, ProductID, SpecialOfferID)
    VALUES
        (1, 921, 0) -- SpecialOfferID 0 doesnt exist

    EXEC "Sales"."sp_NEW_SALES_ORDER"
        @CustomerID = 11000,
        @BillAddressID = 22601,
        @ShipAddressID = 672,
        @ShipMethodID = 2,
        @OrderDetails = @ShouldSuccess,
        @OnlineOrderFlag = 1; 

    EXEC "Sales"."sp_NEW_SALES_ORDER"
        @CustomerID = 11000,
        @BillAddressID = 22601,
        @ShipAddressID = 672,
        @ShipMethodID = 2,
        @OrderDetails = @ShouldFail,
        @OnlineOrderFlag = 1; 
END; 

CREATE OR ALTER PROCEDURE "Sales"."sp_TEST_OFFLINE_SALES"
AS 
BEGIN
    DECLARE @ShouldSuccess AS "Sales"."SalesOrderDetailType"
    DECLARE @ShouldFail AS "Sales"."SalesOrderDetailType"

    INSERT INTO @ShouldSuccess (OrderQty, ProductID, SpecialOfferID)
    VALUES
        (2, 921, 1),
        (1, 774, 7),
        (1, 988, 16)

    INSERT INTO @ShouldFail (OrderQty, ProductID, SpecialOfferID)
    VALUES
        (1, 921, 0) -- SpecialOfferID 0 doesnt exist\

    -- Primary type of person: SC = Store Contact, IN = Individual (retail) customer, SP = Sales person, EM = Employee (non-sales), VC = Vendor contact, GC = General contact
    EXEC "Sales"."sp_NEW_SALES_ORDER"
        @CustomerID = 11000,
        @SalesPersonID = 290,
        @BillAddressID = 22601,
        @ShipAddressID = 672,
        @ShipMethodID = 2,
        @OrderDetails = @ShouldSuccess; 

    -- EXEC "Sales"."sp_NEW_SALES_ORDER"
    --     @CustomerID = 11000,
    --     @SalesPersonID = 290,
    --     @BillAddressID = 22601,
    --     @ShipAddressID = 672,
    --     @ShipMethodID = 2,
    --     @OrderDetails = @ShouldFail; 
END; 



EXEC "Sales"."sp_TEST_ONLINE_SALES";
EXEC "Sales"."sp_TEST_OFFLINE_SALES";