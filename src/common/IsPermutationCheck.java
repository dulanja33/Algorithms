package common;

public class IsPermutationCheck {
    private void solve() {
        System.out.println(isPerm(123456789,987654321));
        System.out.print(isPerm(123456789,98765432));
    }

    private boolean isPerm(int m, int n) {
        int[] arr = new int[10];

        int temp = n;
        while (temp > 0) {
            arr[temp % 10]++;
            temp /= 10;
        }

        temp = m;
        while (temp > 0) {
            arr[temp % 10]--;
            temp /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        IsPermutationCheck solution = new IsPermutationCheck();
        solution.solve();
    }
}
