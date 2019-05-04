package codejam19.qualificationround;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class YouCanGo {
    public static void main(String args[]) {
        YouCanGo solution = new YouCanGo();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            int dim = in.nextInt(); in.nextLine();
            String path = in.nextLine();

            StringBuilder nPath = new StringBuilder();
            for (char c : path.toCharArray()) {
                if (c == 'S') {
                    nPath.append('E');
                } else if (c == 'E') {
                    nPath.append('S');
                }
            }


            System.out.println("Case #" + i + ": " + nPath.toString());
        }

    }
}