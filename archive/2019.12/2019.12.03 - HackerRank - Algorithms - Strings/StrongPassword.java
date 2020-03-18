package competition;

import utils.InputReader;
import utils.OutputWriter;

public class StrongPassword {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextCharacter();

        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        int len = 0;
        if (arr.length < 6) {
            len = 6 - arr.length;
        }

        boolean nc = false;
        boolean lc = false;
        boolean uc = false;
        boolean sc = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                nc = true;
            }

            if (arr[i] >= 'a' && arr[i] <= 'z') {
                lc = true;
            }

            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                uc = true;
            }

            for (char s : special_characters.toCharArray()) {
                if (arr[i] == s) {
                    sc = true;
                    break;
                }
            }
        }

        int req = 0;
        req = nc ? ++req : req;
        req = lc ? ++req : req;
        req = uc ? ++req : req;
        req = sc ? ++req : req;

        out.print(Math.max(4 - req, len));


    }
}
