package competition;

import utils.InputReader;
import utils.OutputWriter;

public class CaesarCipher {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        char[] arr = in.nextString().toCharArray();
        int k = in.nextInt();

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = (char) (((arr[i] - 'a' + k) % 26) + 'a');
            }

            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] = (char) (((arr[i] - 'A' + k) % 26) + 'A');
            }
        }

        StringBuilder b = new StringBuilder();
        for (int i = 0; i < n; i++) {
            b.append(arr[i]);
        }

        out.println(b.toString());

    }
}
