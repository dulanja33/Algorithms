package common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created for Algorithms.
 * User: dulanja
 * Date: 13/10/18
 * Time: 2:23 AM
 */
public class ContinuousFraction {
    private void solve() {
        List<Integer> fractions = continuousFraction(23);
        System.out.print("_| 23 = [" + fractions.get(0) + ";");
        for(int i=1; i< fractions.size();i++){
            System.out.print(fractions.get(i) + ",");
        }

        System.out.println("]");
    }



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
        ContinuousFraction solution = new ContinuousFraction();
        long start = System.currentTimeMillis();
        solution.solve();
        long end = System.currentTimeMillis();
        System.out.print("Time - " + (end - start) + " ms");
    }
}