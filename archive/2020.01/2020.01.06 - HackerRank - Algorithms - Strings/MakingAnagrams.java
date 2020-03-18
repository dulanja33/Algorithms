package competition;

import utils.InputReader;
import utils.OutputWriter;

public class MakingAnagrams {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        char[] a = in.nextString().toCharArray();
        char[] b = in.nextString().toCharArray();

        int[] fra = new int[26];
        for (int i = 0; i < a.length; i++) {
            fra[a[i] - 'a']++;
        }

        for (int i = 0; i < b.length; i++) {
            fra[b[i] - 'a']--;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(fra[i]);
        }

        out.println(count);
    }
}
