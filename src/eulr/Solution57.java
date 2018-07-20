package eulr;


import java.math.BigInteger;

public class Solution57 {
    private void solve() {
        BigInteger xDenominator = BigInteger.valueOf(2);
        BigInteger xNumerator = BigInteger.valueOf(5);
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            BigInteger numerator = xDenominator.add(xNumerator);
            BigInteger denominator = xNumerator;
            BigInteger tempXDenominator = xDenominator;

            if (String.valueOf(numerator).length() > String.valueOf(denominator).length()) {
                count++;
            }

            xDenominator = xNumerator;
            xNumerator = xNumerator.multiply(BigInteger.valueOf(2)).add(tempXDenominator);
        }

        System.out.println(count);

    }

    public static void main(String args[]) {
        Solution57 solution = new Solution57();
        long start = System.currentTimeMillis();
        solution.solve();
        long end = System.currentTimeMillis();
        System.out.print((end - start) / 1000 + " Seconds");
    }
}
