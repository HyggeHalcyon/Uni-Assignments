SELECT
	dim_products.CompanyName,
	SUM(fact_penjualan.Quantity) AS Jumlah
FROM 
	fact_penjualan
INNER JOIN
	dim_products
ON
	fact_penjualan.ProductID = dim_products.ProductID 
GROUP BY
	dim_products.CompanyName  
ORDER BY 
	Jumlah
DESC