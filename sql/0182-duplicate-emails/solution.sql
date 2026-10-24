-- 182. Duplicate Emails  (Easy)
-- https://leetcode.com/problems/duplicate-emails/
--
-- Intuition: group rows by email and keep the groups that contain more
--            than one row. HAVING filters groups (WHERE filters rows).

SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;
