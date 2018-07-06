package eulr;

public class Solution53 {
    private void solve() {
        int limit = 1000000;
        int nLimit = 100;
        int result = 0;

        int[][] pascalTraingle = new int[nLimit + 1][nLimit + 1];

        for (int n = 0; n <= nLimit; n++) {
            pascalTraingle[n][0] = 1;
        }

        for (int n = 1; n <= nLimit; n++) {
            for (int r = 1; r <= n; r++) {
                pascalTraingle[n][r] = pascalTraingle[n - 1][r] + pascalTraingle[n - 1][r - 1];
                if (pascalTraingle[n][r] > limit) {
                    pascalTraingle[n][r] = limit;
                    result++;
                }
            }
        }

        System.out.println(result);

    }

    public static void main(String args[]) {
        Solution53 solution = new Solution53();
        long start = System.currentTimeMillis();
        solution.solve();
        long end = System.currentTimeMillis();
        System.out.print((end - start) / 1000 + " Seconds");
    }
}
