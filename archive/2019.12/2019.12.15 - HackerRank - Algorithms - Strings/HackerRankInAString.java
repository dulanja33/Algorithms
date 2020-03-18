package competition;

import utils.InputReader;
import utils.OutputWriter;

public class HackerRankInAString {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        char[] arr = in.nextString().toCharArray();
        char[] orig = new char[]{'h', 'a', 'c', 'k', 'e', 'r', 'r', 'a', 'n', 'k'};

        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == orig[p]) {
                p++;
            }

            if (orig.length == p) {
                break;
            }
        }

        if (orig.length == p) {
            out.println("YES");
        } else {
            out.println("NO");
        }

    }
}
