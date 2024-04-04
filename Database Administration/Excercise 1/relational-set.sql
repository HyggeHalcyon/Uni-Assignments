-- The SELECT INTO statement duplicates data from one table into a new table.
-- The new table does not need to exist beforehand in MSSQL
SELECT * INTO CUSTOMER_2 FROM CUSTOMER;

SELECT 
    CUS_LNAME,
    CUS_FNAME,
    CUS_INITIAL,
    CUS_AREACODE,
    CUS_PHONE
FROM CUSTOMER 
UNION
SELECT     
    CUS_LNAME,
    CUS_FNAME,
    CUS_INITIAL,
    CUS_AREACODE,
    CUS_PHONE 
FROM CUSTOMER_2