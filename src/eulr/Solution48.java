package eulr;

public class Solution48 {
    private void solve() {
        long res = 0;
        long modulo = 100000000000L;
        for (int i = 1; i <= 1000; i++) {
           long temp = i;
           for(int j= 1; j < i ; j++){
                temp *= i;
                temp %= modulo;
           }

           res += temp;
           res %= modulo;
        }

        System.out.println(res);

    }

    public static void main(String args[]) {
        Solution48 solution = new Solution48();
        solution.solve();
    }
}
