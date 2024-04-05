CREATE OR ALTER PROCEDURE BUY_ONE_PRODUCT 
    @CUSTOMER_ID INT = NULL,
    @PRODUCT_ID VARCHAR(10) = NULL,
    @QUANTITY NUMERIC(9,2) = NULL
AS 
BEGIN
    DECLARE @PRODUCT_PRICE NUMERIC(9,2),
            @PRODUCT_QOH INT,
            @INV_NUMBER INT,
            @CUS_BALANCE INT;

    -- make sure INV_NUMBER is auto-incremented
    INSERT INTO INVOICE
        (CUS_CODE, INV_DATE)
    VALUES 
        (@CUSTOMER_ID, GETDATE());

    SELECT 
        @INV_NUMBER = MAX(INV_NUMBER) 
    FROM INVOICE;

    SELECT 
        @PRODUCT_QOH = P_QOH 
    FROM PRODUCT 
    WHERE P_CODE = @PRODUCT_ID; 

    SET @PRODUCT_PRICE = dbo.PRICE_AFTER_DISCOUNT(@PRODUCT_ID) 

    INSERT INTO LINE VALUES (
        @INV_NUMBER,
        1, -- in this case, buys only one product at a time
        @PRODUCT_ID,
        @QUANTITY,
        @PRODUCT_PRICE
    );

    SELECT 
        @CUS_BALANCE = CUS_BALANCE 
    FROM CUSTOMER 
    WHERE CUS_CODE = @CUSTOMER_ID;
   
    -- optional, will be triggered by the previously defined trigger 
    UPDATE PRODUCT 
    SET 
        P_QOH = @PRODUCT_QOH - @QUANTITY
    WHERE P_CODE = @PRODUCT_ID;

    UPDATE CUSTOMER
    SET 
        CUS_BALANCE = @CUS_BALANCE + (@PRODUCT_PRICE * @QUANTITY)
    WHERE CUS_CODE = @CUSTOMER_ID;
END;

EXECUTE BUY_ONE_PRODUCT
    @CUSTOMER_ID = 10011,
    @PRODUCT_ID = '13-Q2/P2',
    @QUANTITY = 2;