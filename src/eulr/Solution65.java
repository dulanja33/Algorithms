package eulr;

import java.math.BigInteger;

public class Solution65 {
    private void solve() {
        BigInteger[] inf = new BigInteger[101];
        inf[0] = BigInteger.valueOf(2);
        inf[1] = BigInteger.valueOf(1);

        int count = 0;
        int inc = 1;
        for (int i = 2; i <= 100; i++) {
            if (count == 3) count = 0;
            if (count == 0) inf[i] = BigInteger.valueOf(2 * (inc++));
            else inf[i] = BigInteger.valueOf(1);
            count++;
        }


        BigInteger num = BigInteger.valueOf(1);
        BigInteger denom = inf[99];
        for (int i = 98; i > 0; i--) {
            num = denom.multiply(inf[i]).add(num);
            BigInteger temp = denom;
            denom = num;
            num = temp;
        }


        BigInteger res = denom.multiply(BigInteger.valueOf(2)).add(num);
        System.out.println(res);

        int sum = 0;
        for (char i : res.toString().toCharArray()) {
            sum += i - '0';
        }

        System.out.println(sum);

    }

    public static void main(String args[]) {
        Solution65 solution = new Solution65();
        long start = System.currentTimeMillis();
        solution.solve();
        long end = System.currentTimeMillis();
        System.out.print("Time - " + (end - start) + " ms");
    }
}
