package algorithms_oreilly_course.union_find;

public class QuickUnion {


    private int[] id;
    private int[] size;

    public QuickUnion(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }


    public static void main(String[] args) {

        /*
         *  0   1   5   7   8
         *      |   |       |  \
         *      2   6       3   9
         *                  |
         *                  4
         *
         *      0 1 2 3 4 5 6 7 8 9
         * id[] 0 1 1 8 3 5 5 7 8 8
         */

        QuickFind quickFind = new QuickFind(10);
        quickFind.union(3, 4);
        quickFind.union(3, 8);
        quickFind.union(6, 5);
        quickFind.union(9, 4);
        quickFind.union(2, 1);

        System.out.println(quickFind.isConnected(5, 4)); // false
        System.out.println(quickFind.isConnected(8, 9)); // true
        System.out.println(quickFind.isConnected(3, 4)); // true


    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // this will flatten the tree
            i = id[i];
        }
        return i;
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        //this is normal implementation
//        int rp = root(p);
//        int rq = root(q);
//        id[rp] = rq;

        //this is the improvement of weighted tree
        if (size[p] < size[q]) {
            id[p] = q;
            size[p] += size[q];
        } else {
            id[q] = p;
            size[q] += size[p];
        }

    }
}
