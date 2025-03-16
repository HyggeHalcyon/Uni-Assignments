SELECT
	products.product_name,
	SUM(order_details.quantity) AS JumlahTotal
FROM
	order_details
INNER JOIN
	products
ON
	order_details.product_id = products.id
WHERE
	order_details.purchase_order_id IS NOT NULL
GROUP BY
	order_details.product_id
ORDER BY
	JumlahTotal 
DESC LIMIT 10