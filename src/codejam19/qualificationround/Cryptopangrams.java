package codejam19.qualificationround;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

//TODO wrong answer

public class Cryptopangrams {
    public static void main(String args[]) {
        Cryptopangrams solution = new Cryptopangrams();
        solution.solve();
    }

    static BigInteger gcd(BigInteger a, BigInteger b) {
        while (!b.equals(BigInteger.ZERO)) {
            BigInteger t = a;
            a = b;
            b = t.mod(b);
        }
        return a;
    }

    private void solve() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            in.nextBigInteger();
            in.nextInt();
            in.nextLine();
            String[] list = in.nextLine().split(" ");
            List<BigInteger> letterValuesOrig = new ArrayList<>();
            List<BigInteger> letterValues = new ArrayList<>();

            for (int k = 1; k < list.length; k++) {
                if (!list[k].equals(list[k - 1])) {
                    int count = 0;
                    BigInteger a = new BigInteger(list[k - 1]);
                    BigInteger b = new BigInteger(list[k]);
                    BigInteger gcd = gcd(a, b);

                    letterValues.add(a.divide(gcd));
                    letterValuesOrig.add(a.divide(gcd));
                    count++;

                    letterValues.add(gcd);
                    letterValuesOrig.add(gcd);
                    count++;

                    for (int j = k-1; j > 0; j--) {
                        BigInteger c = new BigInteger(list[j]);
                        BigInteger val = letterValues.get(count + 1);
                        BigInteger divide = c.divide(val);
                        letterValues.add(divide);
                        letterValuesOrig.add(divide);
                        count++;
                    }

                    for (int j = k; j < list.length; j++) {
                        BigInteger c = new BigInteger(list[j]);
                        BigInteger val = letterValues.get(count - 1);
                        BigInteger divide = c.divide(val);
                        letterValues.add(divide);
                        letterValuesOrig.add(divide);
                        count++;
                    }

                    break;
                }
            }


            Set<BigInteger> aSet = new TreeSet<>(letterValues);
            Map<BigInteger, Character> aMap = new HashMap<>();

            int alpc = 65;
            for (BigInteger lv : aSet) {
                aMap.put(lv, (char) alpc);
                alpc++;
            }

            StringBuilder f = new StringBuilder();
            for (BigInteger bigInteger : letterValuesOrig) {
                f.append(aMap.get(bigInteger));

            }
            System.out.println("Case #" + i + ": " + f.toString());
        }

    }
}