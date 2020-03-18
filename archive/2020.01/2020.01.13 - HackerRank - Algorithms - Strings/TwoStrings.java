package competition;

import utils.InputReader;
import utils.OutputWriter;

public class TwoStrings {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String a = in.nextString();
        String b = in.nextString();

        boolean found = false;
        int[] fa = new int[26];
        int[] fb = new int[26];

        for (int i = 0; i < a.length(); i++) {
            fa[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            fb[b.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (fa[i] > 0 && fb[i] > 0) {
                out.println("YES");
                found = true;
                break;
            }
        }


        if (!found) out.println("NO");

    }

}
