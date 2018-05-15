package eular;

public class Solution36 {

  public static void main(String args[]) {
    Solution36 solution = new Solution36();
    solution.solve();
  }

  private void solve() {
    int count = 0;

    int n = 1000000;
    for (int i = 0; i < n; i++) {
      String s = Integer.toString(i);
      if (checkPalindrome(s)
          && checkPalindrome(convertToBinaryUsingString(i))) {
        count += i;
      }
    }

    System.out.println(count);
  }

  private boolean checkPalindrome(String a) {
    int count = a.length() / 2;
    for (int i = 0; i < a.length() / 2; i++) {
      if (a.charAt(i) == a.charAt(a.length() - 1 - i)) {
        count--;
      }
    }

    return count == 0;

  }

  private String convertToBinaryUsingString(int no) {
    StringBuilder result = new StringBuilder("");
    while (no > 0) {
      result.append(no % 2);
      no = no / 2;
    }
    return result.reverse().toString();
  }
}
