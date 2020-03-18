package competition;

import utils.InputReader;
import utils.OutputWriter;

public class StringConstruction {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        char[] arr = in.nextString().toCharArray();

        int[] freq = new int[26];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                count++;
            }
        }

        out.println(count);
    }
}
