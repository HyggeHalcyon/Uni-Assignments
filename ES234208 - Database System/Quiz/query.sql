-- Ada berapa jumlah total customer yang ada di database?
SELECT 
  COUNT(*) 
FROM 
  customers;

-- Siapakah nama lengkap 'VP Sales'?
SELECT 
  firstName, 
  lastName 
FROM 
  employees 
WHERE 
  `jobTitle` = 'VP Sales';

-- Jumlah total employee yang memiliki atasan/Boss
SELECT 
  COUNT(*) 
FROM 
  employees 
WHERE 
  `reportsTo` IS NOT NULL;

-- Berapakah jumlah negara lokasi office yang dimiliki?
SELECT 
  COUNT(DISTINCT `country`) 
FROM 
  offices;

-- Sebutkan 3 customer dengan credit limits tertinggi
  customerName 
FROM 
  customers 
ORDER BY 
  `creditLimit` DESC 
LIMIT 
  3;

-- Berapakah jumlah order yang dicancel setelah shiped? (AMBIGU)
SELECT 
  COUNT(*) 
FROM 
  orders 
WHERE 
  `status` = 'Cancelled';

-- Apakah order number pembelian dengan harga individual produk termahal yang pernah dijual (AMBIGU)
SELECT 
  `orderNumber`, 
  `priceEach` 
FROM 
  orderdetails 
WHERE 
  `priceEach` = (
    SELECT 
      MAX(`priceEach`) 
    FROM 
      orderdetails
  );

-- Apakah nomor orderNumber dengan comment yang mengandung kata 'damaged during shipping' ?
SELECT 
  orderNumber 
FROM 
  orders 
WHERE 
  `comments` LIKE '%damaged during shipping%';

-- Apakah order number dengan orderLineNumber terbesar? (AMBIGU)
SELECT 
  orderNumber, 
  orderLineNumber 
FROM 
  orderdetails 
WHERE 
  `orderLineNumber` = (
    SELECT 
      MAX(`orderLineNumber`) 
    FROM 
      orderdetails
  );

-- Jumlah teritory lokasi office?
SELECT 
  COUNT(DISTINCT `territory`) 
FROM 
  offices;

-- Apakah product line yang 'ideal for children under the age of 5'?
SELECT 
  `productLine` 
FROM 
  productlines 
WHERE 
  `textDescription` LIKE '%ideal for children under the age of 5%';

-- Product yang memiliki stok paling banyak dari vendor bernama 'Classic Metal Creations'
SELECT 
  `productName`, 
  `productVendor`, 
  `quantityInStock` 
FROM 
  products 
WHERE 
  `productVendor` = 'Classic Metal Creations' 
ORDER BY 
  `quantityInStock` DESC 
LIMIT 
  1;

-- Customer number dengan individual check amount terbesar?
SELECT 
  customerNumber 
FROM 
  payments 
WHERE 
  amount = (
    SELECT 
      MAX(amount) 
    FROM 
      payments
  );

-- product line dengan jumlah produk terbanyak
SELECT 
  productLine, 
  COUNT(*) 
FROM 
  products 
GROUP BY 
  productLine 
ORDER BY 
  COUNT(*) DESC 
LIMIT 
  100;

-- Hitunglah total amount pembayaran
SELECT 
  SUM(amount) 
FROM 
  payments;

-- Vendor yang menjual jenis produk paling sedikit ke kita
SELECT 
  `productVendor`, 
  COUNT(*) 
FROM 
  products 
GROUP BY 
  `productVendor` 
ORDER BY 
  COUNT(*) ASC 
LIMIT 
  100;


-- Jumlah job title dengan employee terbanyak
SELECT 
  `jobTitle`, 
  COUNT(*) 
FROM 
  employees 
GROUP BY 
  `jobTitle` 
ORDER BY 
  COUNT(*) DESC 
LIMIT 
  100;

-- Jumlah jenis barang terbanyak yang dibeli dalam satu pembelian
SELECT 
  `orderNumber`, 
  COUNT(*) 
FROM 
  orderdetails 
GROUP BY 
  `orderNumber` 
ORDER BY 
  COUNT(*) DESC 
LIMIT 
  100;

-- Hitunglah total product quantity (AMBIGU)
SELECT 
  SUM(`quantityInStock`) 
FROM 
  products;

-- Customer dengan orders terbesar
SELECT 
  C.customerNumber, 
  C.customerName, 
  COUNT(O.orderNumber) AS orderCount 
FROM 
  customers C 
JOIN 
  orders O ON C.customerNumber = O.customerNumber 
GROUP BY 
  C.customerNumber, 
  C.customerName 
ORDER BY 
  orderCount DESC 
LIMIT 
  10;

-- Jumlah product dalam productline 'motorcycles'
SELECT 
  COUNT(*) 
FROM 
  products 
WHERE 
  `productLine` = 'Motorcycles';

-- total order tahun 2003
SELECT 
  SUM(
    OD.`quantityOrdered` * OD.`priceEach`
  ) AS totalOrderPrice 
FROM 
  orders O 
JOIN 
  orderdetails OD ON O.`orderNumber` = OD.`orderNumber` 
WHERE 
  YEAR(O.`orderDate`) = 2003;

-- Setiap customer dilayani oleh employee sales representatif tertentu (salesRepEmployeeNumber), Employee dengan penjualan terbanyak adalah
SELECT 
  E.`firstName`, 
  E.`lastName` 
FROM 
  employees E 
JOIN
  customers C ON E.`employeeNumber` = C.`salesRepEmployeeNumber` 
WHERE 
  C.`customerNumber` = (
    SELECT 
      `customerNumber` 
    FROM 
      orders 
    GROUP BY 
      `customerNumber` 
    ORDER BY 
      COUNT(customerNumber) DESC 
    LIMIT 
      1
  );

-- Product dengan margin penjualan (selisih MSRP dan buyprice) terbesar (AMBIGU)
SELECT 
  `productName`, 
  `MSRP`, 
  `buyPrice`, 
  `MSRP` - `buyPrice` AS `Margin` 
FROM 
  products 
ORDER BY 
  `Margin` DESC 
LIMIT 
  100;

-- Rata-rata waktu antara orderdate sampai shippeddate untuk order yang statusnya sudah 'Shipped' (AMBIGU)
SELECT 
  AVG(
    DATEDIFF(`shippedDate`, `orderDate`)
  ) AS averageDaysToShip 
FROM 
  orders 
WHERE 
  `status` = 'Shipped';

-- join predicate/ join attribute dari join antara tabel products dan productlines adalah
-- `productLine`

-- Apakah ada customer yang dalam satu pembelian, hanya membeli satu jenis barang saja?
SELECT 
  `orderNumber`, 
  COUNT(*) 
FROM 
  orderdetails 
GROUP BY 
  `orderNumber` 
HAVING 
  COUNT(*) = 1;

-- Employee dengan email 'mnishi@classicmodelcars.com' bekerja di kota apa?
SELECT 
  O.city 
FROM 
  offices O 
JOIN 
  employees E ON O.`officeCode` = E.`officeCode` 
WHERE 
  E.`email` = 'mnishi@classicmodelcars.com';

-- Berapa banyak order yang statusnya "Disputed"
SELECT 
  COUNT(*) 
FROM 
  orders 
WHERE 
  `status` = 'Disputed';

-- Table orders dan order details jika dijoin, baik 'natural join' dan 'left outer join' menghasilkan jumlah tuple yang sama
SELECT 
  COUNT(*) 
FROM 
  orders NATURAL 
JOIN 
  orderdetails;
  
SELECT 
  COUNT(*) 
FROM 
  orders 
LEFT OUTER JOIN 
  orderdetails ON orders.`orderNumber` = orderdetails.`orderNumber`;