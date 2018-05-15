package eular;

import java.util.ArrayList;
import java.util.List;

public class Solution38 {

  public static void main(String args[]) {
    Solution38 solution = new Solution38();
    int count = solution.solve();
    System.out.println("Solution: " + count);
  }

  private int solve() {
    int count = 0;
    int fullNum = 0;
    StringBuilder pal;
    for (int i = 1; i < 9999; i++) {
      String iS = Integer.toString(i);
      pal = new StringBuilder(iS);
      if (isDiffNums(iS)) {
        for (int j = 2; j <= 9; j++) {
          int mul = i * j;
          String mulS = Integer.toString(mul);
          pal.append(mulS);

          if (pal.toString().length() == 9 && isDiffNums(pal.toString())) {
            Integer k = new Integer(pal.toString());
            if (fullNum < k) {
              count = i;
              fullNum = k;
            }
            break;
          }
        }
      }

    }

    System.out.println(fullNum);
    return count;
  }

  private boolean isDiffNums(String s) {
    List<Character> bucket = new ArrayList<>();

    if (s.charAt(0) != '0') {
      bucket.add(s.charAt(0));
    }

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) != '0' && !bucket.contains(s.charAt(i))) {
        bucket.add(s.charAt(i));
      }
    }

    return bucket.size() == s.length();
  }

}
