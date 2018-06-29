package eulr;

import java.util.ArrayList;
import java.util.List;

public class Solution50 {
    private void solve() {
        int n = 1000000;
        boolean[] prime = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();
        primeSieve(prime, n);

        for (int i = 0; i < n; i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }

        long[] primeSums = new long[primes.size() + 1];
        primeSums[0] = 0;

        for (int i = 0; i < primes.size(); i++) {
            primeSums[i + 1] = primeSums[i] + primes.get(i);
        }

        long res = 0;
        int count = 0;
        for (int i = 0; i < primeSums.length; i++) {
            for (int j = i - (count + 1); j >= 0; j--) {
                long sum = primeSums[i] - primeSums[j];
                if (sum >= n) {
                    break;
                }
                if (prime[(int) sum]) {
                    //System.out.println(sum);
                    res = sum;
                    count = i - j;
                }
            }
        }

        System.out.println(res + " " + count);


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
        Solution50 solution = new Solution50();
        solution.solve();
    }
}
