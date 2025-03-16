SELECT
    orders.shipping_fee, 
    orders.taxes, 
    orders.id, 
    orders.order_date, 
    order_details.product_id, 
    order_details.quantity, 
    orders.ship_city, 
    orders.ship_country_region, 
    orders.ship_name, 
    orders.shipped_date, 
    orders.ship_state_province, 
    order_details.unit_price
FROM
    orders
    INNER JOIN
    order_details
    ON 
        orders.id = order_details.order_id

----------

SELECT
    products.category, 
    suppliers.company, 
    CONCAT(suppliers.last_name, " ", suppliers.first_name), 
    suppliers.country_region, 
    products.discontinued, 
    products.id, 
    products.product_name, 
    products.quantity_per_unit, 
    products.list_price
FROM
    products
    INNER JOIN
    suppliers
    ON 
    products.supplier_ids = suppliers.id

-------

SELECT
    customers.city, 
    customers.company, 
    CONCAT(customers.last_name , " " , customers.first_name) as Name , 
    customers.country_region, 
    customers.job_title, 
    customers.id
FROM
    customers
    INNER JOIN
    orders
    ON 
    customers.id = orders.customer_id

------------- 

SELECT
    customers.id AS CustomerID, 
    products.id AS ProductID, 
    orders.id AS OrderID, 
    order_details.quantity, 
    orders.ship_country_region, 
    order_details.unit_price, 
    ( (order_details.quantity * order_details.unit_price) - (order_details.quantity * list_price)) As Revenue
FROM
    customers
    INNER JOIN
    orders
    ON 
        customers.id = orders.customer_id
    INNER JOIN
    order_details
    ON 
        orders.id = order_details.order_id
    INNER JOIN
    products
    ON 
    order_details.product_id = products.id