package competition;

import utils.InputReader;
import utils.OutputWriter;

public class CamelCase {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s = in.nextString();

        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                count++;
            }
        }

        out.print(count);
    }
}
