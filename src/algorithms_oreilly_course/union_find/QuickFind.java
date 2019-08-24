package algorithms_oreilly_course.union_find;

public class QuickFind {


    private int[] id;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public static void main(String[] args) {

        /* sample connections
         *
         *    0     1 ---- 2    3 ---- 4
         *                      |      |
         *    5 ----6      7    8      9
         *
         *          0  1  2  3  4  5  6  7  8  9
         *    id[]  0  1  1  8  8  5  5  7  8  8
         */

        QuickFind quickFind = new QuickFind(10);
        quickFind.union(4, 3);
        quickFind.union(3, 8);
        quickFind.union(6, 5);
        quickFind.union(9, 4);
        quickFind.union(2, 1);

        System.out.println(quickFind.isConnected(8, 9)); // true
        System.out.println(quickFind.isConnected(5, 0)); // false
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (pid == id[i]) {
                id[i] = qid;
            }
        }
    }

    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }
}
