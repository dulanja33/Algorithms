package eulr;

public class Solution37 {

  public static void main(String args[]) {
    Solution37 solution = new Solution37();
    int count = solution.solve();
    System.out.println("sum: " + count);
  }

  private int n = 100000000;
  private boolean[] isPrime = new boolean[n + 1];
  private boolean[] prime = new boolean[n + 1];


  private int solve() {
    primeSieve();

    for (int i = 11; i < prime.length; i++) {
      String s = Integer.toString(i);
      String s_rev = Integer.toString(i);
      int j = s.length();

      //else check the removing primes
      for (; j > 0; j--) {
        Integer t = new Integer(s);
        Integer t_rev = new Integer(s_rev);
        /*System.out.println(t);
        System.out.println(t_rev);*/
        if (!isPrime[t] || !isPrime[t_rev]) {
          prime[i] = false;
          break;
        }
        s_rev = s_rev.substring(1, s.length());
        s = s.substring(0, s.length() - 1);

      }
    }

    int count = 0;
    for (int i = 11; i < prime.length; i++) {
      if (prime[i]) {
        count += i;
        System.out.println(i);
      }
    }

    return count;
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
      // suffices to consider mutiples factor, factor+1, ...,  n/factor
      if (isPrime[factor]) {
        for (int j = factor; factor * j <= n; j++) {
          isPrime[factor * j] = false;
          prime[factor * j] = false;
        }
      }
    }
  }
}
