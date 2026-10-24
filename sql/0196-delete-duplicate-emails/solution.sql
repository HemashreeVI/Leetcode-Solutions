-- 196. Delete Duplicate Emails  (Easy)
-- https://leetcode.com/problems/delete-duplicate-emails/
--
-- Intuition: for every pair of rows with the same email, delete the one
--            with the BIGGER id. The smallest id for each email survives.
--            (MySQL multi-table DELETE syntax.)

DELETE p1
FROM Person p1
JOIN Person p2
  ON p1.email = p2.email
 AND p1.id > p2.id;             -- p1 is a later duplicate of p2
