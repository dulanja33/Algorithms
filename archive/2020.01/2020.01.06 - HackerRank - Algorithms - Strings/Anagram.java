package competition;

import utils.InputReader;
import utils.OutputWriter;

public class Anagram {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        char[] arr = in.nextString().toCharArray();

        if (arr.length % 2 != 0) {
            out.println(-1);
        } else {
            int[] a = new int[26];
            int[] b = new int[26];
            for (int i = 0; i < arr.length / 2; i++) {
                a[arr[i] - 'a']++;
                b[arr[arr.length / 2 + i] - 'a']++;
            }

            int count = 0;
            boolean found = false;
            for (int i = 0; i < 26; i++) {
                int diff = Math.abs(a[i] - b[i]);
                if (diff == arr.length / 2) {
                    count = arr.length / 2;
                    out.println(arr.length / 2);
                    found = true;
                    break;
                } else {
                    count += diff;
                }
            }

            if (!found) out.println(count / 2);
        }
    }
}
