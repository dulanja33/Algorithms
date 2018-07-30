package eulr;

import java.util.HashMap;
import java.util.Map;

public class Solution62 {
    private void solve() {
        long num = 365;
        Map<Long, Cube> map = new HashMap<>();

        while (true) {
            num++;
            long cube = num * num * num;
            long maxPermutation = getMaxPermutation(cube);
            if (!map.containsKey(maxPermutation)) {
                map.put(maxPermutation, new Cube(num, 0));
            }

            if (++map.get(maxPermutation).perms == 5) {
                long n = map.get(maxPermutation).n;
                System.out.println(n);
                System.out.println(n * n * n);
                break;
            }
        }

    }

    private long getMaxPermutation(long n) {
        long num = n;
        int[] digits = new int[10];
        long ret = 0;

        while (num > 0) {
            digits[Math.toIntExact(num % 10)]++;
            num /= 10;
        }

        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < digits[i]; j++) {
                ret = ret * 10 + i;
            }
        }

        return ret;
    }

    class Cube {
        public long n;
        int perms;

        Cube(long n, int perms) {
            this.n = n;
            this.perms = perms;
        }
    }


    public static void main(String args[]) {
        Solution62 solution = new Solution62();
        long start = System.currentTimeMillis();
        solution.solve();
        long end = System.currentTimeMillis();
        System.out.print("Time - " + (end - start) + " ms");
    }
}
