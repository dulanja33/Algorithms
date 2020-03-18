package competition;

import utils.InputReader;
import utils.OutputWriter;

public class PalindromeIndex {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        char[] arr = in.nextString().toCharArray();

        boolean found = false;
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                if (isPalindrome(arr, i)) {
                    out.println(i);
                    found = true;
                    break;
                } else if (isPalindrome(arr, arr.length - 1 - i)) {
                    out.println(arr.length - 1 - i);
                    found = true;
                    break;
                }
            }

        }

        if (!found) out.println(-1);


    }

    private boolean isPalindrome(char[] arr, int i) {
        int length = arr.length;

        for (int j = 0, k = length - 1; j < k; ) {
            if (i == j) {
                j++;
            }

            if (k == i) {
                k--;
            }

            if (arr[j] != arr[k]) {
                return false;
            } else {
                j++;
                k--;
            }

        }

        return true;
    }
}
