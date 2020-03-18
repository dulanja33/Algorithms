package competition;

import utils.InputReader;
import utils.OutputWriter;

public class SherlockAndArray {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            int[] arr = new int[k];

            int sum = 0;
            for (int j = 0; j < k; j++) {
                arr[j] = in.nextInt();
                sum += arr[j];
            }

            boolean found = false;
            int uptoSum = 0;
            for (int j = 0; j < arr.length; j++) {
                if ((sum - uptoSum - arr[j]) == uptoSum) {
                    out.println("YES");
                    found = true;
                    break;
                }

                uptoSum += arr[j];

            }

            if (!found) {
                out.println("NO");
            }
        }
    }
}
