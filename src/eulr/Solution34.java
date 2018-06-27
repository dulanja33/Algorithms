package eulr;

public class Solution34 {

  private int[] fact = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

  public static void main(String args[]) {
    Solution34 solution = new Solution34();
    solution.solve();
  }

  private void solve() {
    int sum = 0;
    for (int i = 3; i < 2540160; i++) {
      String s = Integer.toString(i);
      int pSum = 0;
      for (int j = 0; j < s.length(); j++) {
        pSum += fact[(s.charAt(j) - '0')];
      }
      if (pSum == i) {
        sum += i;
      }
    }
    System.out.println(sum);
  }
}
