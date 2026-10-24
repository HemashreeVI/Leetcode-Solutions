-- 175. Combine Two Tables  (Easy)
-- https://leetcode.com/problems/combine-two-tables/
--
-- Intuition: every person must appear, even without an address, so use a
--            LEFT JOIN. Missing address columns simply come back as NULL.
-- (LeetCode only accepts SQL for database problems, so this one isn't in Java.)

SELECT p.firstName,
       p.lastName,
       a.city,
       a.state
FROM Person p
LEFT JOIN Address a
       ON p.personId = a.personId;   -- keep every Person row
