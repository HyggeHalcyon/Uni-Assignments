DROP TYPE IF EXISTS "Sales"."SalesOrderDetailType";
CREATE TYPE "Sales"."SalesOrderDetailType" AS TABLE (
    OrderQty INT,
    ProductID INT,
    SpecialOfferID INT
);