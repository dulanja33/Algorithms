package eulr;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created for Algorithms.
 * User: dulanja
 * Date: 11/10/18
 * Time: 11:33 PM
 *
 * <p>
 * resources
 * <p>
 * 1. http://www.kurims.kyoto-u.ac.jp/EMIS/journals/GMN/yahoo_site_admin/assets/docs/1_GMN-8492-V28N2.190180001.pdf
 * 2. http://mathworld.wolfram.com/PellEquation.html
 */
public class Solution66 {


    private static List<Integer> continuousFraction(int num) {

        List<Integer> fractions = new ArrayList<>();

        int s = 1;
        for (int i = 1; i * i <= num; i++) {
            s = i;
        }

        int b = num - s * s;
        int c = s;

        fractions.add(c);

        while (b != 1) {
            int l = 1;
            for (int i = b; (i - c) * (i - c) <= num; i += b) {
                l = i;
            }

            fractions.add(l / b);

            c = l - c;
            int temp = b;
            b = num - c * c;
            b = b / temp;


        }

        int l = 1;
        for (int i = b; (i - c) * (i - c) <= num; i += b) {
            l = i;
        }

        fractions.add(l);

        return fractions;
    }

    public static void main(String args[]) {
        Solution66 solution = new Solution66();
        long start = System.currentTimeMillis();
        solution.solve();
        long end = System.currentTimeMillis();
        System.out.print("Time - " + (end - start) + " ms");
    }

    private void solve() {

        BigInteger max = BigInteger.ZERO;
        int maxD = 2;
        for (int n = 2; n < 1000; n++) {
            int s = 1;
            for (int i = 1; i * i <= n; i++) {
                s = i;
            }

            if (s * s == n) {
                continue;
            }

            List<Integer> fractions = continuousFraction(n);
            int size = fractions.size();
            List<Integer> lastFractions = fractions.subList(1, size);

            List<BigInteger> a = new ArrayList<>();
            List<BigInteger> b = new ArrayList<>();
            List<BigInteger> c = new ArrayList<>();

            a.add(0, BigInteger.valueOf(0));
            b.add(0, BigInteger.valueOf(1));
            c.add(0, BigInteger.valueOf(n));

            a.add(1, BigInteger.valueOf(1));
            b.add(1, BigInteger.valueOf(0));
            c.add(1, BigInteger.valueOf(100));

            int j = 1;
            while (c.get(j).compareTo(BigInteger.ONE) != 0) {
                int i;
                if (j - 1 >= size) {
                    i = lastFractions.get(((j - 2) % (size - 1)));
                } else {
                    i = fractions.get((j - 1));
                }


                a.add(j + 1, a.get(j).multiply(BigInteger.valueOf(i)).add(a.get(j - 1)));
                b.add(j + 1, b.get(j).multiply(BigInteger.valueOf(i)).add(b.get(j - 1)));

                BigInteger temp = a.get(j + 1).pow(2).subtract(b.get(j + 1).pow(2).multiply(BigInteger.valueOf(n)));

                c.add(j + 1, temp);
                j++;
            }

            System.out.println(n + "   " + a.get(j) + " " + b.get(j) + " " + c.get(j));

            if (a.get(j).compareTo(max) > 0) {
                max = a.get(j);
                maxD = n;
            }

        }


        System.out.println("answer " + maxD);


    }
}