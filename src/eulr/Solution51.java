package eulr;

/*By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

        By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

        Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.*/

import java.util.ArrayList;
import java.util.List;

public class Solution51 {
    private void solve() {
        int n = 100000;
        boolean[] isPrime = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();
        primeSieve(isPrime, n);

        for (int i = 0; i < n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        boolean found = false;
        List<Integer> otherPrimes = new ArrayList<>();
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if (primes.get(i) == 56003 && primes.get(j) == 56113) {
                    System.out.println("debug");
                }

                if (String.valueOf(primes.get(i)).length() != String.valueOf(primes.get(j)).length() && primes.get(i) <= 9 && primes.get(j) <= 9 && (primes.get(j) - primes.get(i)) <= 9) {
                    break;
                }

                if (onlyOneNumberContains(primes.get(j) - primes.get(i))) {
                    otherPrimes = getOtherPrimes(primes.get(j), primes.get(i), isPrime);
                    if (otherPrimes.size() == 7) {
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                break;
            }
        }

        if (!otherPrimes.isEmpty() && found) {
            for (int i : otherPrimes) {
                System.out.println(i);
            }
        }


    }

    private static List<Integer> getOtherPrimes(int i, int j, boolean[] primes) {
        String si = String.valueOf(i);
        String ji = String.valueOf(j);
        List<Integer> genPrimes = new ArrayList<>();

        for (int l = 0; l < 10; l++) {
            char[] numbs = new char[si.length()];
            for (int k = 0; k < si.length(); k++) {
                if (si.charAt(k) != ji.charAt(k)) {
                    numbs[k] = (char) (l + '0');
                } else {
                    numbs[k] = si.charAt(k);
                }
            }

            Integer val = Integer.valueOf(new String(numbs));
            if (primes[val]) {
                genPrimes.add(val);
            }
        }

        return genPrimes;

    }

    private static boolean onlyOneNumberContains(int n) {
        int len = String.valueOf(n).length();
        int number = -1;
        while (n > 0 && len > 0) {
            int t = n % 10;
            if (t != 0 && number == -1) {
                number = t;
                n /= 10;
            } else if (t == 0) {
                n /= 10;
            } else if (number == t) {
                n /= 10;
            }
            len--;
        }

        return n <= 0;
    }

    public static void main(String args[]) {
        Solution51 solution = new Solution51();
        solution.solve();
        // System.out.println(onlyOneNumberContains(2112));
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
}
