package eulr;


public class Solution45 {
    public static void main(String args[]) {
        Solution45 solution = new Solution45();
        solution.solve();
    }

    private void solve() {
        int i = 5;
        long max = 40755;
        while (true) {
            i++;
            long k = i * (2 * i - 1);
            if (k > max && isPentogonal(k)) {
                max = k;
                break;
            }
        }

        System.out.println(max);
    }

    private boolean isPentogonal(long n) {
        Double t = (1 + Math.sqrt(24 * n + 1)) / 6;
        return (t == Math.floor(t)) && !Double.isInfinite(t);

    }
}
