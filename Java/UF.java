public class UF {
    private int[] id;
    private int[] sz;

    public UF(int N) {
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j) return;
        if (sz[i] < sz[j])  {  id[i] = j; sz[j] += sz[i];  } 
        else                {  id[j] = i; sz[i] += sz[j];  }
    }

    public static void main(String[] args) {
        int n = 9;
        UF uf = new UF(n);

        uf.union(4, 5);
        uf.union(4, 8);
        uf.union(1, 2);
        uf.union(2, 5);

        System.out.println(uf.isConnected(1, 8));
    }
}