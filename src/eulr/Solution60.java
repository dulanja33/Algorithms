package eulr;

public class Solution60 {
    private void solve() {
        int n = 9999;
        boolean[] prime = new boolean[n + 1];
        primeSieve(prime, n);

        first:
        for (int i = 1; i < n; i++) {
            if (!prime[i]) continue;

            for (int j = i + 1; j < n; j++) {
                if (!prime[j]) continue;

                boolean twoP = isConcatPrime(i, j);
                if (!twoP) continue;

                for (int k = j + 1; k < n; k++) {
                    if (!prime[k]) continue;

                    boolean threeP1 = isConcatPrime(i, k);
                    boolean threeP2 = isConcatPrime(j, k);
                    if (!(threeP1 && threeP2)) continue;

                    for (int l = k + 1; l < n; l++) {
                        if (!prime[l]) continue;

                        boolean fourP1 = isConcatPrime(i, l);
                        boolean fourP2 = isConcatPrime(j, l);
                        boolean fourP3 = isConcatPrime(k, l);

                        if (!(fourP1 && fourP2 && fourP3)) continue;

                        for (int m = l + 1; m < n; m++) {
                            if (!prime[m]) continue;

                            boolean fiveP1 = isConcatPrime(i, m);
                            boolean fiveP2 = isConcatPrime(j, m);
                            boolean fiveP3 = isConcatPrime(k, m);
                            boolean fiveP4 = isConcatPrime(l, m);

                            if ((fiveP1 && fiveP2 && fiveP3 && fiveP4)) {
                                System.out.println(i + "+" + j + "+" + k + "+" + l + "+" + m + "=" + (i + j + k + l + m));
                                break first;
                            }

                        }

                    }
                }

            }
        }
    }

    private static boolean isConcatPrime(int num1, int num2) {

        try {
            int p1 = Integer.valueOf(String.valueOf(num1) + String.valueOf(num2));
            int p2 = Integer.valueOf(String.valueOf(num2) + String.valueOf(num1));
            return isPrime(p1) && isPrime(p2);
        } catch (NumberFormatException e) {
            return false;
        }

    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n <= 3) {
            return true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
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
        Solution60 solution = new Solution60();
        long start = System.currentTimeMillis();
        solution.solve();
        long end = System.currentTimeMillis();
        System.out.print("Time - " + (end - start) + " ms");
    }
}
