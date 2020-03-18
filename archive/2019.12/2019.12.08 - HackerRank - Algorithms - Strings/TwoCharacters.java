package competition;

import utils.InputReader;
import utils.OutputWriter;

public class TwoCharacters {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        String a = in.nextString();

        int max = 0;
        for (int i = 0; i < 25; i++) {
            for (int j = i + 1; j < 26; j++) {
                String rem1 = String.valueOf((char) (i + 'a'));
                String rem2 = String.valueOf((char) (j + 'a'));
                String rem = "[^" + rem1 + rem2 + "]";
                String k = a.replaceAll(rem, "");
                //out.println(k);
                boolean found = true;
                for (int l = 0; l < k.length() - 2; l++) {
                    if (k.charAt(l) != k.charAt(l + 2)) {
                        found = false;
                        break;
                    }

                    if (k.charAt(l) == k.charAt(l + 1)) {
                        found = false;
                        break;
                    }
                }

                if (found && k.length() > 2) {
                    max = Math.max(max, k.length());
                } else if (found && k.length() == 2) {
                    if (k.charAt(0) != k.charAt(1)) {
                        max = Math.max(max, 2);
                    }
                }
            }
        }

        out.print(max);


    }
}
