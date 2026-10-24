-- 183. Customers Who Never Order  (Easy)
-- https://leetcode.com/problems/customers-who-never-order/
--
-- Intuition: LEFT JOIN customers to orders. A customer with no orders gets
--            NULLs on the Orders side, so keep exactly those rows.

SELECT c.name AS Customers
FROM Customers c
LEFT JOIN Orders o
       ON c.id = o.customerId
WHERE o.id IS NULL;             -- no matching order
