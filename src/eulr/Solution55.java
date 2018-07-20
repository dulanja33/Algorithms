package eulr;

import java.math.BigInteger;

public class Solution55 {
    private void solve() {
        int count = 0;
        for (int i = 10; i < 10000; i++) {
            BigInteger pal = BigInteger.valueOf(i);
            int j = 0;
            for (; j < 50; j++) {
                BigInteger reverse = reverseInt(pal);
                pal = pal.add(reverse);

                if (isPalindrome(pal)) {
                    break;
                }
            }

            if (j >= 50) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isPalindrome(BigInteger n) {
        String num = String.valueOf(n);
        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    private static BigInteger reverseInt(BigInteger n) {
        BigInteger res = BigInteger.ZERO;
        while (!n.equals(BigInteger.ZERO)) {
            res = res.multiply(BigInteger.TEN).add(n.mod(BigInteger.TEN));
            n = n.divide(BigInteger.TEN);
        }
        return res;
    }


    public static void main(String args[]) {
        Solution55 solution = new Solution55();
        long start = System.currentTimeMillis();
        solution.solve();
        long end = System.currentTimeMillis();
        System.out.print((end - start) / 1000 + " Seconds");
    }
}
