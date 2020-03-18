import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author dwij
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        MaximumPalindromes solver = new MaximumPalindromes();
        solver.solve(1, in, out);
        out.close();
    }

    static class MaximumPalindromes {
        private static long modPower(long x, int y, int m) {
            if (y == 0)
                return 1;

            long p = modPower(x, y / 2, m) % m;
            p = (p * p) % m;

            if (y % 2 == 0)
                return p;
            else
                return (x * p) % m;
        }

        private static long modInverse(long v, int mod) {
            return modPower(v, mod - 2, mod);
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {

            int mod = 1000000007;

            String word = in.nextString();
            int d = in.nextInt();


            long[] fact = new long[word.length() + 1];
            fact[0] = 1;
            for (int i = 1; i <= word.length(); i++) {
                fact[i] = ((fact[i - 1]) * (i)) % mod;
            }

            int[][] cFreq = new int[word.length() + 1][26];
            for (int i = 1; i <= word.length(); i++) {
                cFreq[i][word.charAt(i - 1) - 'a']++;
            }

            for (int i = 2; i <= word.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    cFreq[i][j] += cFreq[i - 1][j];
                }
            }


            for (int i = 0; i < d; i++) {
                String[] k = in.readLine(false).split(" ");
                int l = Integer.parseInt(k[0]);
                int r = Integer.parseInt(k[1]);

                int[] freq = new int[26];

                for (int j = 0; j < 26; j++) {
                    freq[j] = cFreq[r][j] - cFreq[l - 1][j];
                }

                int p = 0;
                int s = 0;
                int[] mo = new int[26];
                for (int j = 0; j < freq.length; j++) {
                    if (freq[j] >= 2) {
                        if (freq[j] >= 4) {
                            mo[j] = freq[j] / 2;
                        }
                        p += freq[j] / 2;
                        s += freq[j] % 2;
                    } else {
                        s += freq[j];
                    }
                }

                long t = fact[p];

                long div = 1;
                for (int value : mo) {
                    div = ((div % mod) * (fact[value] % mod)) % mod;
                }

                long inv = modInverse(div, mod);

                t = ((t % mod) * (inv % mod)) % mod;

                s = s == 0 ? 1 : s;
                long sol = ((t % mod) * (s % mod)) % mod;
                out.println(sol);

            }

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public void println(long i) {
            writer.println(i);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }

        public String readLine(boolean ignoreEmptyLines) {
            if (ignoreEmptyLines) {
                return readLine();
            } else {
                return readLine0();
            }
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

    }
}

