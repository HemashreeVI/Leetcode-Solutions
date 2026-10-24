-- 181. Employees Earning More Than Their Managers  (Easy)
-- https://leetcode.com/problems/employees-earning-more-than-their-managers/
--
-- Intuition: employees and managers live in the SAME table, so join the
--            table with itself (a self join): one copy plays "employee",
--            the other plays "manager".

SELECT e.name AS Employee
FROM Employee e
JOIN Employee m
  ON e.managerId = m.id         -- pair each employee with their manager
WHERE e.salary > m.salary;
