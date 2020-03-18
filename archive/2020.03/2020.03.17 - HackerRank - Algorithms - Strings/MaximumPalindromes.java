package competition;

import utils.InputReader;
import utils.OutputWriter;

public class MaximumPalindromes {

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
