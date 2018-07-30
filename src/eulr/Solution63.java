package eulr;

public class Solution63 {
    private void solve() {
        int count = 0;
        int lower = 1;
        int n = 1;

        while (lower < 10) {
            lower = (int) Math.ceil(Math.pow(10, (n - 1.0) / n));
            count += 10 - lower;
            n++;
        }

        System.out.println(count);
    }

    public static void main(String args[]) {
        Solution63 solution = new Solution63();
        long start = System.currentTimeMillis();
        solution.solve();
        long end = System.currentTimeMillis();
        System.out.print("Time - " + (end - start) + " ms");
    }
}
