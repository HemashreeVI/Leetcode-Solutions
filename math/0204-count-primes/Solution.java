/**
 * 204. Count Primes  (Medium)
 * https://leetcode.com/problems/count-primes/
 *
 * Intuition (Sieve of Eratosthenes): instead of testing every number for
 *            primality, take each prime p and cross out all of its multiples.
 *            Whatever is never crossed out is prime.
 * Time:  O(n log log n)
 * Space: O(n)
 */
class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;                    // no primes strictly below 2

        boolean[] composite = new boolean[n];   // false = still possibly prime
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (composite[i]) continue;

            count++;                            // i survived, so it's prime
            // start at i*i: smaller multiples were already crossed out by smaller primes
            for (long j = (long) i * i; j < n; j += i) {
                composite[(int) j] = true;
            }
        }
        return count;
    }
}
