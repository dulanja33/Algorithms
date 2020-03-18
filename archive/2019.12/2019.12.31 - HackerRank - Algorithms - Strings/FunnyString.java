package competition;

import utils.InputReader;
import utils.OutputWriter;

public class FunnyString {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s = in.nextString();

        int[] diff = new int[s.length() - 1];
        for (int i = 0; i < s.length() - 1; i++) {
            diff[i] = Math.abs(s.charAt(i + 1) - s.charAt(i));
        }

        boolean funny = true;
        for (int i = 0; i < diff.length / 2; i++) {
            if (diff[i] != diff[diff.length - i - 1]) {
                funny = false;
                break;
            }
        }

        if (funny) out.println("Funny");
        else out.println("Not Funny");
    }
}
