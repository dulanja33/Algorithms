package eular;

public class Solution35 {

  private int n = 1000000;
  private boolean[] isPrime = new boolean[n + 1];
  private boolean[] prime = new boolean[n + 1];


  public static void main(String args[]) {
    Solution35 solution = new Solution35();
    solution.solve();
  }

  private void solve() {
    primeSieve();

    for (int i = 2; i < prime.length; i++) {
      String s = Integer.toString(i);
      int j = 0;

      //remove multiplication of 2
      for (; j < s.length(); j++) {
        if ((s.charAt(j) - '0') % 2 == 0) {
          prime[i] = false;
          break;
        }
      }

      //else check the rotate primes
      if (j == s.length()) {
        for (; j >= 0; j--) {
          Integer t = new Integer(s);
          if (!isPrime[t]) {
            prime[i] = false;
            break;
          }

          s = s.substring(1, s.length()) + s.substring(0, 1);
        }
      }
    }

    int count = 1;
    for (int i = 2; i < prime.length; i++) {
      if (prime[i]) {
        count++;
      }
    }

    System.out.println(count);
  }

  //prime sieve of eratosthenes
  private void primeSieve() {
    for (int i = 2; i <= n; i++) {
      isPrime[i] = true;
      prime[i] = true;
    }

    // mark non-primes <= n using Sieve of Eratosthenes
    for (int factor = 2; factor * factor <= n; factor++) {

      // if factor is prime, then mark multiples of factor as nonprime
      // suffices to consider multiples factor, factor+1, ...,  n/factor
      if (isPrime[factor]) {
        for (int j = factor; factor * j <= n; j++) {
          isPrime[factor * j] = false;
          prime[factor * j] = false;
        }
      }
    }
  }
}
