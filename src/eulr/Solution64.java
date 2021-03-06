package eulr;

public class Solution64 {

    private void solve() {


        int oddCount = 0;
        for (int n = 23; n < 24; n++) {
            int s = 1, b, c;
            for (int i = 1; i * i <= n; i++) {
                s = i;
            }

            if (s * s == n) {
                continue;
            }

            b = n - s * s;
            c = s;

            System.out.println(c);

            int count = 1;
            while (b != 1) {
                int l = 1;
                for (int i = b; (i - c) * (i - c) <= n; i += b) {
                    l = i;
                }

                System.out.println(l/b);

                count++;
                c = l - c;
                int temp = b;
                b = n - c * c;
                b = b / temp;


            }

            int l =1;
            for (int i = b; (i - c) * (i - c) <= n; i += b) {
                l=i;
            }

            System.out.println(l);

            if (count % 2 != 0) {
                oddCount++;
            }

        }

       // System.out.println(oddCount);

    }

    public static void main(String args[]) {
        Solution64 solution = new Solution64();
        long start = System.currentTimeMillis();
        solution.solve();
        long end = System.currentTimeMillis();
        System.out.print("Time - " + (end - start) + " ms");
    }
}
