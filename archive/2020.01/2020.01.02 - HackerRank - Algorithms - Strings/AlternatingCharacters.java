package competition;

import utils.InputReader;
import utils.OutputWriter;

import javax.swing.plaf.IconUIResource;

public class AlternatingCharacters {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        char[] arr = in.nextString().toCharArray();

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i+1]){
                count++;
            }
        }

        out.println(count);
    }
}
