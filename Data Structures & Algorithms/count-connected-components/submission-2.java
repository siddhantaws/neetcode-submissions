class Solution {
    private int parent[];
    private int rank[];
    public int countComponents(int n, int[][] edges) {
        this.rank = new int[n];
        this.parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
        for(int arr[] : edges) {
            if (union(arr[0], arr[1])) {
                n--;
            }
        }
        return n;
    }

    public int getParent(int i) {
        if (parent[i]!=i) {
            parent [i] = getParent(parent[i]);
        }
        return parent[i];
    }

    public boolean union(int i , int j) {
        int i1 = getParent(i);
        int j1 = getParent(j);
        if (i1 == j1)
            return false;
            if (rank[i1] > rank[j1]) {
                parent[j1] =i1;
            } else if (rank[i1] < rank[j1]) {
                parent[i1] =j1;
            } else {
                parent[j1] =i1;
                rank[i1]++;
            }
            return true;
        
        
    }
}
