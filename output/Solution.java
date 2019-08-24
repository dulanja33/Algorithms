import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author dwij
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        EvenDigits solver = new EvenDigits();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class EvenDigits {
        public void solve(int testNumber, Scanner in, PrintWriter out) {

            long n = in.nextLong();
            String s = String.valueOf(n);
            int length = s.length();

            long[] arr = new long[length + 1];
            long[] max = new long[length + 1];
            long[] min = new long[length + 1];

            arr[0] = 0;
            max[0] = 0;
            min[0] = 0;
            for (int i = 1; i < length + 1; i++) {
                arr[i] = s.charAt(i - 1) - '0';
                max[i] = arr[i];
                min[i] = arr[i];
            }


            boolean flag = false;
            for (int i = 0; i < length + 1; i++) {
                long k = arr[i];
                if (!flag && k % 2 != 0) {
                    min[i]--;
                    flag = true;
                } else if (flag) {
                    min[i] = 8;
                }

            }

            flag = false;
            for (int i = 0; i < length + 1; i++) {
                long k = arr[i];
                if (!flag && k % 2 != 0) {
                    if (max[i] == 9) {
                        for (int j = i - 1; j >= 0; j--) {
                            if (max[j] % 2 == 0) {
                                max[j] += 2;
                            } else {
                                max[j]++;
                            }

                            if (max[j] > 9) {
                                max[j] = 0;
                            } else {
                                break;
                            }
                        }
                        max[i] = 0;
                    } else {
                        max[i]++;
                    }
                    flag = true;
                } else if (flag) {
                    max[i] = 0;
                }

            }

            long a = 0, b = 0;
            long count = 1;
            for (int i = length; i >= 0; i--) {
                a += max[i] * count;
                b += min[i] * count;
                count *= 10;
            }

            out.println("Case #" + testNumber + ": " + Math.min(a - n, n - b));


        }

    }
}

