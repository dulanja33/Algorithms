package common;

import java.util.ArrayList;
import java.util.List;

public class PermutationsRecursion {
    private void solve() {
        List<String> perms = new ArrayList<>();
        permute(perms, "012345", 0, 5);
        for (String perm : perms) {
            System.out.println(perm);
        }
    }

    private void permute(List<String> perms, String str, int l, int r) {
        if (l == r) {
            perms.add(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(perms, str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    private String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String args[]) {
        PermutationsRecursion solution = new PermutationsRecursion();
        solution.solve();
    }
}
