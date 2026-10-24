/**
 * 2667. Create Hello World Function  (Easy)
 * https://leetcode.com/problems/create-hello-world-function/
 *
 * Intuition: a function can RETURN another function. The inner function
 *            ignores whatever arguments it gets and always returns
 *            "Hello World".
 * (This problem is part of LeetCode's "30 Days of JavaScript" and only
 *  accepts JS/TS, so it isn't in Java.)
 * Time:  O(1)
 * Space: O(1)
 *
 * @return {Function}
 */
var createHelloWorld = function() {
    return function(...args) {      // accepts any arguments...
        return "Hello World";       // ...and ignores them
    };
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */
