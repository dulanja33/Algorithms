package eulr;

import java.math.BigInteger;

public class Solution56 {
    private void solve() {
        int maxSum = 0;
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                BigInteger k = BigInteger.valueOf(i).pow(j);
                String num = k.toString();
                int sum = 0;
                for (char c : num.toCharArray()) {
                    sum += c - '0';
                }
                maxSum = Math.max(maxSum, sum);
            }
        }

        System.out.println(maxSum);


    }

    public static void main(String args[]) {
        Solution56 solution = new Solution56();
        long start = System.currentTimeMillis();
        solution.solve();
        long end = System.currentTimeMillis();
        System.out.print((end - start) / 1000 + " Seconds");
    }
}
