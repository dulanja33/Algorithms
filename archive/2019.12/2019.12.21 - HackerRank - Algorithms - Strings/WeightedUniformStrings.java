package competition;

import utils.InputReader;
import utils.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class WeightedUniformStrings {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        char[] arr = in.nextString().concat(" ").toCharArray();

        Set<Integer> set = new HashSet<>();
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (!flag && arr[i] == arr[i + 1]) {
                count++;
                set.add((arr[i] - 'a' + 1) * count);
                flag = true;
            } else if (flag && arr[i] == arr[i + 1]) {
                count++;
                set.add((arr[i] - 'a' + 1) * count);
            } else if (flag && arr[i] != arr[i + 1]) {
                flag = false;
                count++;
                set.add((arr[i] - 'a' + 1) * count);
                count = 0;
            } else {
                set.add(arr[i] - 'a' + 1);
            }
        }

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            if (set.contains(k)) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
    }
}
