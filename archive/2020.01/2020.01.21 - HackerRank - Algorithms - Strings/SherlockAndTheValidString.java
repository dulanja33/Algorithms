package competition;

import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class SherlockAndTheValidString {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        char[] arr = in.nextString().toCharArray();

        int[] freq = new int[26];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] - 'a']++;
        }

        Arrays.sort(freq);
        int i = 0;
        while (freq[i] == 0) i++;

        int min = freq[i];
        int max = freq[25];

        if (min == max) {
            out.println("YES");
        } else {
            if ((max - min == 1 && max > freq[24]) || (min == 1 && freq[i + 1] == max)) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
    }
}
