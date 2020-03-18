package competition;

import utils.InputReader;
import utils.OutputWriter;

public class MarsExploration {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        char[] arr = in.nextString().toCharArray();

        char[] orig = new char[]{'S', 'O', 'S'};

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (orig[i % 3] != arr[i]) {
                count++;
            }
        }

        out.println(count);
    }
}
