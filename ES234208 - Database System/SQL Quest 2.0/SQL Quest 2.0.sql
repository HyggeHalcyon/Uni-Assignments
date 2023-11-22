-- NO.1
SELECT MAX(UnitPrice) AS most_expensive, MIN(UnitPrice) AS cheapest_price FROM `Track`;
-- NO.2
SELECT BillingCountry, Total, COUNT(BillingCountry) as Invoice_qty FROM `Invoice` GROUP BY BillingCountry HAVING COUNT(BillingCountry) >= 21;
-- NO.3
SELECT FirstName, Title, Email FROM `Employee` WHERE Title LIKE 'IT%';
-- NO.4
SELECT CustomerId AS CustomerID, FirstName, LastName FROM `Customer` WHERE CustomerId >= 10;
-- NO.5
SELECT FirstName, LastName, Total AS total_purchase FROM `Customer` INNER JOIN Invoice ON Customer.CustomerId=Invoice.CustomerId WHERE Total > 15;
-- NO.6
SELECT FirstName, LastName, Quantity AS purchased_track_qty, Total FROM `Customer` C INNER JOIN `Invoice` I ON C.CustomerId=I.CustomerId JOIN `InvoiceLine` IL ON IL.InvoiceId = I.InvoiceId WHERE Total > 15 GROUP BY C.CustomerId;