package common;

public class PrimeSieveEratosthenes {
    private void solve() {
        int n = 100;
        boolean[] prime = new boolean[n + 1];
        primeSieve(prime, n);
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + prime[i]);
        }
    }

    //prime sieve of eratosthenes
    private void primeSieve(boolean[] prime, int n) {
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

    public static void main(String args[]) {
        PrimeSieveEratosthenes solution = new PrimeSieveEratosthenes();
        solution.solve();
    }
}
