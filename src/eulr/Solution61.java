package eulr;

import java.util.ArrayList;
import java.util.List;

public class Solution61 {
    static int n = 9999;
    private boolean[] tNums = triangle(n);
    private boolean[] sNums = square(n);
    private boolean[] pNums = pentogonal(n);
    private boolean[] hexNums = hexogonal(n);
    private boolean[] hepNums = heptogonal(n);
    private boolean[] oNums = octogonal(n);

    private void solve() {
        outer:
        for (int i = 10; i <= 99; i++) {
            for (int j = 10; j <= 99; j++) {
                int n1 = Integer.valueOf(String.valueOf(i) + String.valueOf(j));
                List<Integer> c1 = check(n1);
                if (c1.size() == 0) continue;

                for (int k = 10; k <= 99; k++) {
                    int n2 = Integer.valueOf(String.valueOf(j) + String.valueOf(k));
                    List<Integer> c2 = check(n2);
                    if (c2.size() == 0 || isContainSame(c1, c2)) continue;

                    for (int l = 10; l <= 99; l++) {
                        int n3 = Integer.valueOf(String.valueOf(k) + String.valueOf(l));
                        List<Integer> c3 = check(n3);
                        if (c3.size() == 0 || isContainSame(c1, c3) || isContainSame(c2, c3)) continue;

                        for (int m = 10; m <= 99; m++) {
                            int n4 = Integer.valueOf(String.valueOf(l) + String.valueOf(m));
                            List<Integer> c4 = check(n4);
                            if (c4.size() == 0 || isContainSame(c1, c4) || isContainSame(c2, c4) || isContainSame(c3, c4))
                                continue;

                            for (int o = 10; o <= 99; o++) {
                                int n5 = Integer.valueOf(String.valueOf(m) + String.valueOf(o));
                                int n6 = Integer.valueOf(String.valueOf(o) + String.valueOf(i));

                                List<Integer> c5 = check(n5);
                                List<Integer> c6 = check(n6);

                                if (c5.size() != 0 && c6.size() != 0 && !isContainSame(c1, c5) && !isContainSame(c2, c5) && !isContainSame(c3, c5) && !isContainSame(c4, c5)
                                        && !isContainSame(c1, c6) && !isContainSame(c2, c6) && !isContainSame(c3, c6) && !isContainSame(c4, c6) && !isContainSame(c5, c6)) {
                                    System.out.println(n1 + "+" + n2 + "+" + n3 + "+" + n4 + "+" + n5 + "+" + n6 + "=" + (n1 + n2 + n3 + n4 + n5 + n6));
                                    break outer;

                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private List<Integer> check(int n) {
        List<Integer> res = new ArrayList<>();
        if (tNums[n]) res.add(1);
        if (sNums[n]) res.add(2);
        if (pNums[n]) res.add(3);
        if (hexNums[n]) res.add(4);
        if (hepNums[n]) res.add(5);
        if (oNums[n]) res.add(6);

        return res;
    }

    private boolean isContainSame(List<Integer> l1, List<Integer> l2) {
        for (Integer i : l1) {
            for (Integer j : l2) {
                if (l1.size() == l2.size() && i.equals(j)) {
                    return true;
                }
            }
        }

        return false;
    }


    private static boolean[] triangle(int n) {
        int max = (n * (n + 1)) / 2;
        boolean[] arry = new boolean[max];
        for (int i = 1; i < n; i++) {
            arry[(i * (i + 1)) / 2] = true;
        }

        return arry;
    }

    private static boolean[] square(int n) {
        int max = n * n;
        boolean[] arry = new boolean[max];
        for (int i = 1; i < n; i++) {
            arry[i * i] = true;
        }

        return arry;
    }

    private static boolean[] pentogonal(int n) {
        int max = (n * (3 * n - 1)) / 2;
        boolean[] arry = new boolean[max];
        for (int i = 1; i < n; i++) {
            arry[(i * (3 * i - 1)) / 2] = true;
        }

        return arry;
    }

    private static boolean[] hexogonal(int n) {
        int max = n * (2 * n - 1);
        boolean[] arry = new boolean[max];
        for (int i = 1; i < n; i++) {
            arry[i * (2 * i - 1)] = true;
        }

        return arry;
    }

    private static boolean[] heptogonal(int n) {
        int max = (n * (5 * n - 1)) / 2;
        boolean[] arry = new boolean[max];
        for (int i = 1; i < n; i++) {
            arry[(i * (5 * i - 3)) / 2] = true;
        }

        return arry;
    }

    private static boolean[] octogonal(int n) {
        int max = n * (3 * n - 2);
        boolean[] arry = new boolean[max];
        for (int i = 1; i < n; i++) {
            arry[i * (3 * i - 2)] = true;
        }

        return arry;
    }


    public static void main(String args[]) {
        Solution61 solution = new Solution61();
        long start = System.currentTimeMillis();
        solution.solve();
        long end = System.currentTimeMillis();
        System.out.print("Time - " + (end - start) + " ms");
    }
}
