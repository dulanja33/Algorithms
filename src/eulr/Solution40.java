package eulr;

public class Solution40 {

  public static void main(String args[]) {
    Solution40 solution = new Solution40();
    int answer = solution.solve();
    System.out.println("Solution: " + answer);
  }

  private int solve() {
    int num = 1;
    StringBuilder builder = new StringBuilder();
    for (int i = 1; i <= 1000000; i++) {
      String a = Integer.toString(i);
      builder.append(a);
    }

    int[] ary = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000};
    int count = 1;
    int index = 0;
    for (char a : builder.toString().toCharArray()) {
      if (count == ary[index]) {
        index++;
        System.out.println(a);
        num *= a - '0';
      }

      if (index == ary.length) {
        break;
      }

      count++;
    }
    return num;
  }

}
