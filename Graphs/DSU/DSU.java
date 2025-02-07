package Graphs.DSU;

public class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = rank[i] = i;
    }

    public int find(int x) {
        return parent[x] = (parent[x] == x ? x : find(parent[parent[x]]));
    }

    public boolean union(int x, int y) {
        int xSet = find(x);
        int ySet = find(y);

        if (xSet == ySet)
            return false;

        if (rank[xSet] > rank[ySet]) {
            parent[y] = parent[x];
            rank[xSet] += rank[ySet];
        } else {
            parent[x] = parent[y];
            rank[ySet] += rank[xSet];
        }

        return true;
    }
}
