package eulr;

import java.util.Arrays;

public class Solution52 {
    private void solve() {
        int i = 1;
        while (true) {
            int allCount = 0;
            int[] fArry = getDigitArray(i);
            Arrays.sort(fArry);
            for (int j = 2; j <= 6; j++) {
                int[] sArry = getDigitArray(i * j);
                Arrays.sort(sArry);
                if (fArry.length != sArry.length) {
                    break;
                }
                int len = 0;
                for (int k = 0; k < fArry.length; k++) {
                    if (sArry[k] == fArry[k]) {
                        len++;
                    }
                }

                if (len == fArry.length) {
                    allCount++;
                } else {
                    break;
                }
            }

            if (allCount == 5) {
                break;
            } else {
                i++;
            }
        }

        System.out.println(i);
    }


    private static int[] getDigitArray(int n) {
        int length = String.valueOf(n).length();
        int[] arry = new int[length];
        for (int i = 0; i < length; i++) {
            arry[i] = n % 10;
            n /= 10;
        }

        return arry;
    }

    public static void main(String args[]) {
        Solution52 solution = new Solution52();
        long start = System.currentTimeMillis();
        solution.solve();
        long end = System.currentTimeMillis();
        System.out.print((end - start) / 1000 + " Seconds");
    }
}
