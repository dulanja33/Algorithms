package eular;

/*
*
*
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

d2d3d4=406 is divisible by 2
d3d4d5=063 is divisible by 3
d4d5d6=635 is divisible by 5
d5d6d7=357 is divisible by 7
d6d7d8=572 is divisible by 11
d7d8d9=728 is divisible by 13
d8d9d10=289 is divisible by 17
Find the sum of all 0 to 9 pandigital numbers with this property.
*
*
* */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution43 {
    public static void main(String args[]) {
        Solution43 solution = new Solution43();
        solution.solve();
    }

    private void solve() {
        BigInteger sum = BigInteger.ZERO;
        for (String st : generatePandigit(0, 9)) {
            if (check(st)) {
                sum = sum.add(new BigInteger(st));
            }
        }

        System.out.println(sum);
    }

    private List<String> generatePandigit(int l, int h) {
        List<String> nums = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        for (int i = l; i <= h; i++) {
            builder.append(i);
        }

        permute(nums, builder.toString(), 0, h);
        return nums;
    }

    private boolean check(String s) {
        int d24 = new Integer(s.substring(1, 4));
        int d35 = new Integer(s.substring(2, 5));
        int d46 = new Integer(s.substring(3, 6));
        int d57 = new Integer(s.substring(4, 7));
        int d68 = new Integer(s.substring(5, 8));
        int d79 = new Integer(s.substring(6, 9));
        int d810 = new Integer(s.substring(7, 10));
        return d810 % 17 == 0 && d79 % 13 == 0 && d68 % 11 == 0 && d57 % 7 == 0 && d46 % 5 == 0
                && d35 % 3 == 0 && d24 % 2 == 0;
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
}
