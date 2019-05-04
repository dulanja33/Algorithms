package codejam19.qualificationround;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created for Algorithms.
 * User: dulanja
 * Date: 2019-04-06
 * Time: 11:41
 */

//TODO failed for third set of test case  - run time error

public class Foregone {
    public static void main(String args[]) {
        Foregone solution = new Foregone();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            int val = in.nextInt();
            String strVal = String.valueOf(val);
            StringBuilder subNumStr = new StringBuilder();
            for (char s : strVal.toCharArray()) {
                if (s == '4') {
                    subNumStr.append('1');
                } else {
                    subNumStr.append('0');
                }
            }

            int subNum = Integer.parseInt(subNumStr.toString());
            System.out.println("Case #" + i + ": " + subNum + " " + (val - subNum));

        }

    }
}