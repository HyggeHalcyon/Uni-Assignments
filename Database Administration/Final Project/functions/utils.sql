-- Active: 1719160991296@@127.0.0.1@1433@AdventureWorks2022

CREATE OR ALTER FUNCTION "Sales"."GetProductSpecialOfferDiscount" (
    @OrderQty INT,
    @ProductID INT,
    @SpecialOfferID INT
) RETURNS SMALLMONEY 
AS
BEGIN
    DECLARE
        @Discount SMALLMONEY,
        @MinQty INT,
        @MaxQty INT,
        @StartDate DATETIME,
        @EndDate DATETIME;

    IF NOT EXISTS(
        SELECT * FROM "Sales"."SpecialOfferProduct"
        WHERE
            "ProductID" = @ProductID AND
            "SpecialOfferID" = @SpecialOfferID
    ) RETURN -1;

    SELECT 
        @Discount = SO."DiscountPct",
        @MinQty = SO."MinQty",
        @MaxQty = SO."MaxQty",
        @StartDate = SO."StartDate",
        @EndDate = SO."EndDate"
    FROM "Sales"."SpecialOffer" SO
    WHERE SO."SpecialOfferID" = @SpecialOfferID;

    IF @OrderQty < @MinQty OR (@OrderQty > @MaxQty AND @MaxQty <> NULL)
        RETURN -1;

    IF @StartDate > GETDATE() OR @EndDate < GETDATE()
        RETURN -1;
    
    RETURN @Discount;
END;


CREATE OR ALTER FUNCTION "Person"."GetPersonTeritoryID" (
    @ID INT,    -- dynamic, depends on flag and implementation
    @FLAG INT   -- 1 Customer, 2 Sales Person
) RETURNS INT
AS 
BEGIN
    DECLARE @RET INT;

    IF @FLAG = 1
    BEGIN
        SELECT 
            @RET = C."TerritoryID"
        FROM "Person"."Person" P 
        JOIN "Sales"."Customer" C
            ON C."PersonID" = P."BusinessEntityID"
        WHERE P."BusinessEntityID" = @ID;
        RETURN @RET;
    END

    IF @FLAG = 2
    BEGIN
        SELECT 
            @RET = SP."TerritoryID"
        FROM "Person"."Person" P 
        JOIN "Sales"."SalesPerson" SP
            ON SP."BusinessEntityID" = P."BusinessEntityID"
        WHERE P."BusinessEntityID" = @ID;
        RETURN @RET;
    END

    RETURN -1;
END;

CREATE OR ALTER FUNCTION "Sales"."GetAddressTaxRate" (
    @AddressID INT
) RETURNS SMALLMONEY
AS
BEGIN
    DECLARE @RET SMALLMONEY;

    SELECT
        @RET = TR."TaxRate"
    FROM "Person"."Address" AD
    JOIN "Person"."StateProvince" SP
        ON SP."StateProvinceID" = AD."StateProvinceID"
    JOIN "Sales"."SalesTaxRate" TR
        ON TR."StateProvinceID" = SP."StateProvinceID"
    WHERE AD."AddressID" = @AddressID;

    RETURN @RET;
END;

CREATE OR ALTER FUNCTION "Production"."GetProductStandardCost" (
    @ProductID INT
) RETURNS MONEY
AS
BEGIN
    DECLARE @RET MONEY;

    SELECT 
        @RET = P."ListPrice" 
    FROM "Production"."Product" P 
    WHERE "ProductID" = @ProductID

    RETURN @RET;
END;

CREATE OR ALTER FUNCTION "Purchasing"."GetActiveHighestCreditVendor" (
    @ProductID INT,
    @IsPreferredFlag BIT -- 0 = Not Preferred, 1 = Preferred
) RETURNS INT
AS
BEGIN
    DECLARE @RET INT;

    IF @IsPreferredFlag = 1
        BEGIN
            SET @RET = (SELECT TOP 1 PV."BusinessEntityID"
            FROM "Purchasing"."ProductVendor" AS PV
            JOIN "Purchasing"."Vendor" AS V
                ON PV."BusinessEntityID" = V."BusinessEntityID"
            WHERE
                V."ActiveFlag" = 1 AND 
                V."PreferredVendorStatus" = 1 AND
                PV."ProductID" = @ProductID
            ORDER BY V."CreditRating" ASC)
        END
    ELSE
        BEGIN
            SET @RET = (SELECT TOP 1 PV."BusinessEntityID"
                FROM "Purchasing"."ProductVendor" AS PV
                JOIN "Purchasing"."Vendor" AS V
                    ON PV."BusinessEntityID" = V."BusinessEntityID"
                WHERE
                    V."ActiveFlag" = 1 AND 
                    PV."ProductID" = @ProductID
                ORDER BY V."CreditRating" ASC)
        END
    RETURN @RET
END;   