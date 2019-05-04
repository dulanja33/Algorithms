package codejam19.round1c;


import java.util.Scanner;

//Robot Programming Strategy

public class RobotProgramming {
    private static String solve(int n, String[] p) {

        int max = 501;

        char[][] fa = new char[max][];

        int f = 0;
        for (int i = 0; i < n; i++) {
            char[] chars = p[i].toCharArray();
            int c = 0;
            for (char aChar : chars) {
                if (fa[c] == null) {
                    char[] ll = new char[n];
                    fa[c] = ll;
                }

                fa[c][f] = aChar;
                c++;
            }

            for (int j = chars.length; j < max; j++) {
                if (fa[c] == null) {
                    char[] ll = new char[n];
                    fa[c] = ll;
                }
                fa[c][f] = chars[j % chars.length];
                c++;
            }
            f++;
        }

        boolean[] beat = new boolean[n];

        StringBuilder b = new StringBuilder();
        for (int i = 0; i < max; i++) {
            int pc = 0, sc = 0, rc = 0;
            for (int j = 0; j < n; j++) {
                if (beat[j]) continue;

                if (fa[i][j] == 'P') {
                    pc++;
                } else if (fa[i][j] == 'S') {
                    sc++;
                } else {
                    rc++;
                }
            }

            String res = "K";

            if (pc > 0 && sc > 0 && rc > 0) {
                return "IMPOSSIBLE";
            } else if (pc > 0 && sc > 0 && rc == 0) {
                b.append("S");
                res = "S";
            } else if (pc == 0 && sc > 0 && rc > 0) {
                b.append("R");
                res = "R";
            } else if (pc > 0 && sc == 0 && rc > 0) {
                b.append("P");
                res = "P";
            } else if (pc > 0 && sc == 0 && rc == 0) {
                b.append("S");
                return b.toString();
            } else if (pc == 0 && sc == 0 && rc > 0) {
                b.append("P");
                return b.toString();
            } else if (pc == 0 && sc > 0 && rc == 0) {
                b.append("R");
                return b.toString();
            }


            for (int j = 0; j < n; j++) {
                if (beat[j]) continue;

                if (fa[i][j] == 'P' && res.equals("S")) beat[j] = true;

                if (fa[i][j] == 'S' && res.equals("R")) beat[j] = true;

                if (fa[i][j] == 'R' && res.equals("P")) beat[j] = true;

            }

        }

        return "IMPOSSIBLE";

    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();in.nextLine();
            String[] p = new String[a];
            for (int j = 0; j < a; j++) {
                p[j] = in.nextLine();
            }

            System.out.println("Case #" + (i + 1) + ": " + solve(a, p));
        }
    }
}