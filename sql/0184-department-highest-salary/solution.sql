-- 184. Department Highest Salary  (Medium)
-- https://leetcode.com/problems/department-highest-salary/
--
-- Intuition: first find the max salary per department (subquery with
--            GROUP BY), then return every employee whose
--            (department, salary) pair matches one of those maxima.
--            Ties are kept automatically.

SELECT d.name   AS Department,
       e.name   AS Employee,
       e.salary AS Salary
FROM Employee e
JOIN Department d
  ON e.departmentId = d.id
WHERE (e.departmentId, e.salary) IN (
        SELECT departmentId, MAX(salary)
        FROM Employee
        GROUP BY departmentId
      );
