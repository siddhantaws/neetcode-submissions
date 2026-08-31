class Solution {
    public int uniquePaths(int m, int n) {
        int arr[][] = new int[m][n];
        return dfs(arr, 0 , 0);
    }

    private int dfs(int arr[][] , int m, int n ){
        if (m >= arr.length || n>=arr[0].length)
            return 0;
        if (m == arr.length-1 && n==arr[0].length-1)
            return 1;
        if(arr[m][n] !=0)
            return arr[m][n];
        return arr[m][n] = dfs(arr, m+1, n) + dfs(arr, m, n+1);
    }
}

