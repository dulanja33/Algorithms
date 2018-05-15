package eular;

public class Solution39 {

  public static void main(String args[]) {
    Solution39 solution = new Solution39();
    int answer = solution.solve();
    System.out.println("Solution: " + answer);
  }

  private int solve() {
    int num = 0;
    int maxSols = 0;
    for (int p = 13; p <= 1000; p++) {
      int sols = 0;
      System.out.println("P = " + p);
      for (int i = 1; i < p; i++) {
        for (int j = 1; j <= i; j++) {
          if (checkRTriangle(i, j, p - i - j)) {
            System.out.println(i + " " + j + " " + (p - i - j));
            sols++;
          }
        }
      }

      if (maxSols < sols) {
        System.out.println("Max Solution:" + sols);
        maxSols = sols;
        num = p;
      }
    }

    return num;
  }

  private boolean checkRTriangle(int i, int j, int k) {
    return i * i + j * j == k * k;
  }

}
