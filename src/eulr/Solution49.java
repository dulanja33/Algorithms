package eulr;

import java.util.ArrayList;
import java.util.List;

public class Solution49 {

    private int n = 10000;
    private boolean[] prime = new boolean[n + 1];

    private void solve() {
        primeSieve();

        List<String> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prime[i] && prime[j]) {
                    int k = j + (j - i);
                    if (k < n && prime[k] && isPerm(i, j) && isPerm(i, k)) {
                        res.add(i + "" + j + "" + k);
                    }
                }
            }
        }

        for (String a : res) {
            System.out.println(a);
        }
    }

    public static void main(String args[]) {
        Solution49 solution = new Solution49();
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

    private boolean isPerm(int m, int n) {
        int[] arr = new int[10];

        int temp = n;
        while (temp > 0) {
            arr[temp % 10]++;
            temp /= 10;
        }

        temp = m;
        while (temp > 0) {
            arr[temp % 10]--;
            temp /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
