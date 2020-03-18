package competition;

import utils.InputReader;
import utils.OutputWriter;

public class BeautifulBinaryString {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        char[] arr = in.nextString().toCharArray();

        int count = 0;
        for (int i = 0; i <= n - 3; ) {
            if (arr[i] == '0' && arr[i + 1] == '1' && arr[i + 2] == '0') {
                count++;
                i += 3;
            } else {
                i++;
            }
        }

        out.println(count);
    }
}
