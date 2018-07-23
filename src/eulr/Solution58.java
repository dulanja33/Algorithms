package eulr;

public class Solution58 {

    private int numCount = 5;
    private int primeCount = 0;
    private double ratio = 100.0;

    private void solve() {
        int i = 3;
        int j = 2;
        while (ratio > 10.0) {

            if (isPrime((i - 2) * (i - 2) + j)) { // top left diagonal
                primeCount++;
            }

            if (isPrime(i * i - j)) { // bottom left diagonal
                primeCount++;
            }

            if (isPrime(i * i)) { // top right diagonal
                primeCount++;
            }

            if (isPrime(j * j + 1)) { // bottom right diagonal
                primeCount++;
            }

            ratio = (((primeCount * 1.0) / (numCount * 1.0)) * 100);
            i += 2;
            j += 2;
            numCount += 4;
        }

        System.out.println(i - 2);
    }

    private static boolean isPrime(int n) {
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

    public static void main(String args[]) {
        Solution58 solution = new Solution58();
        long start = System.currentTimeMillis();
        solution.solve();
        long end = System.currentTimeMillis();
        System.out.print((end - start) / 1000 + " Seconds");
    }
}
