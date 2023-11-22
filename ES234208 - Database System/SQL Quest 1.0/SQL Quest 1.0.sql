-- EASY NO.1
SELECT * FROM `Track`;
-- EASY NO.2
SELECT * FROM `PlaylistTrack` ORDER BY `PlaylistId`;
-- EASY NO.3
SELECT InvoiceId, CustomerId, Total FROM `Invoice`;
-- EASY NO.4
SELECT FirstName, LastName, HireDate, Email FROM `Employee`;
-- MEDIUM NO.1
SELECT COUNT(*) AS employee_qty FROM `Employee`;
-- MEDIUM NO.2
SELECT SUM(`UnitPrice`) AS total_sales FROM `InvoiceLine`; 
-- HARD NO.1
SELECT BillingCity, AVG(Total) FROM `Invoice` GROUP BY `BillingCity`;