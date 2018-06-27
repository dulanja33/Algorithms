package eular;


/*It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

        9 = 7 + 2×1^2
        15 = 7 + 2×2^2
        21 = 3 + 2×3^2
        25 = 7 + 2×3^2
        27 = 19 + 2×2^2
        33 = 31 + 2×1^2

        It turns out that the conjecture was false.

        What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?*/


public class Solution46 {

    private static int n = 1000000;
    private boolean[] prime = new boolean[n + 1];

    private void solve() {
        primeSieve();
        int i = 2;
        boolean found = false;
        while (true) {
            if (!prime[i] && i % 2 != 0) {
                for (int j = 1; 2 * j * j < i; j++) {
                    // System.out.println(i+ "    " +j);
                    if (prime[i - 2 * j * j]) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    i++;
                    found = false;
                } else {
                    break;
                }

            } else {
                i++;
            }
        }
        System.out.print(i);
    }

    public static void main(String args[]) {
        Solution46 solution = new Solution46();
        solution.solve();
    }

    //prime sieve of eratosthenes
    private void primeSieve() {
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor * factor <= n; factor++) {

            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider multiples factor, factor+1, ...,  n/factor
            if (prime[factor]) {
                for (int j = factor; factor * j <= n; j++) {
                    prime[factor * j] = false;
                }
            }
        }
    }
}
