package eulr;

import java.util.ArrayList;
import java.util.List;

public class Solution41 {

  public static void main(String args[]) {
    Solution41 solution = new Solution41();
    int answer = solution.solve();
    System.out.println("Solution: " + answer);
  }

  private int solve() {
      /*  int num = partialSolve(12, 21);
        num = Math.max(partialSolve(123, 321), num);  // every number in this range divisible by 3  , because 1+2+3 = 6 etc.
        num = Math.max(partialSolve(1234, 4321), num); this should check
        num = Math.max(partialSolve(12345, 54321), num);  // every number in this range divisible by 3
        num = Math.max(partialSolve(123456, 654321), num); // every number in this range divisible by 3
        num = Math.max(partialSolve(1234567, 7654321), num); // this should check
        num = Math.max(partialSolve(12345678, 87654321), num);  //  every number in this range divisible by 3
        num = Math.max(partialSolve(123456789, 987654321), num);  // every number in this range divisible by 3
      */
    return Math.max(partialSolve(1234, 4321), partialSolve(1234567, 7654321));
  }

  private int partialSolve(int lb, int ub) {
    int num = 1;
    for (int i = lb; i <= ub; i++) {
      if (panDigitalCheck(Integer.toString(i)) && isPrime(i)) {
        num = Math.max(num, i);
      }
    }
    return num;
  }

  private boolean panDigitalCheck(String a) {
    List<Character> arry = new ArrayList<Character>();

    for (char aa : a.toCharArray()) {

      if (a.length() < (aa - '0')) {
        return false;
      }

      if (aa != '0' && !arry.contains(aa)) {
        arry.add(aa);
      } else {
        return false;
      }
    }

    return arry.size() == a.length();
  }


  private boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    } else if (n <= 3) {
      return true;
    } else if (n % 2 == 0 || n % 3 == 0) {
      return false;
    }

    int i = 5;
    while (i * i <= n) {
      if (n % i == 0 || n % (i + 2) == 0) {
        return false;
      }
      i += 6;
    }
    return true;
  }
}
