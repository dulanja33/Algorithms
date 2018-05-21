package eular;

public class Solution44 {

    public static void main(String args[]) {
        Solution44 solution = new Solution44();
        solution.solve();
    }

    private void solve() {
        int min = 0;
        boolean found = false;
        for (int i = 1; !found; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (isPentogonal(pNum(i) - pNum(j)) && isPentogonal(pNum(j) + pNum(i))) {
                    min = pNum(i) - pNum(j);
                    found = true;
                    break;
                }
            }
        }

        System.out.println(min);
    }

    private int pNum(int n) {
        return n * (3 * n - 1) / 2;
    }

    private boolean isPentogonal(int n) {
        Double t = (1 + Math.sqrt(24 * n + 1)) / 6;
        return (t == Math.floor(t)) && !Double.isInfinite(t);

    }
}
