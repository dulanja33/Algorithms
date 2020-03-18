package competition;

import utils.InputReader;
import utils.OutputWriter;

public class Pangrams {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        char[] arr = in.readLine().toCharArray();

        int[] a = new int[26];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 'Z' && arr[i] >= 'A') {
                a[arr[i] - 'A']++;
            } else if (arr[i] <= 'z' && arr[i] >= 'a') {
                a[arr[i] - 'a']++;
            }
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (a[i] > 0) {
                count++;
            }
        }

        if (count == 26) {
            out.print("pangram");
        } else {
            out.print("not pangram");
        }
    }
}
