package eulr;

public class Solution47 {

    private static int n = 1000000;
    private boolean[] prime = new boolean[n + 1];

    private void solve() {
        primeSieve();
        int sol = 0;
        int consecCount = 0;
        for (int i = 1000; i < 999999; i++) {
            int num = i;
            int devCount = 0;

            boolean countFlag = false;
            for (int j = 2; j < i; ) {
                if (prime[j]) {
                    if (num % j == 0) {
                        if (!countFlag) {
                            countFlag = true;
                            devCount++;
                        }
                        num /= j;
                    } else {
                        countFlag = false;
                        j++;
                    }
                } else {
                    countFlag = false;
                    j++;
                }
            }


            if (num == 1 && devCount == 4) {
                //System.out.println(i + " " + num + " " + devCount + " " + consecCount);
                consecCount++;
                sol = i;
            } else {
                consecCount = 0;
            }

            if (consecCount == 4) {
                break;
            }
        }

        System.out.println(sol - 3);
    }

    public static void main(String args[]) {
        Solution47 solution = new Solution47();
        long l = System.currentTimeMillis();
        solution.solve();
        long l1 = System.currentTimeMillis();
        System.out.print((l1 - l)/1000 +" Seconds");
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
