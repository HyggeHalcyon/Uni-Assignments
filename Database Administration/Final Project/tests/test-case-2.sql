-- This should Update Stock and Execute Purchase Order
UPDATE "Production"."ProductInventory"
SET "Quantity" = 10
WHERE "ProductID" = 1 AND "LocationID" = 6;

-- This shouldn't Update Stock and Execute Purchase Order
UPDATE "Production"."ProductInventory"
SET "Quantity" = 324
WHERE "ProductID" = 1 AND "LocationID" = 6;
