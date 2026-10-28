class Solution {
    public int uniquePaths(int m, int n) {
        int arr[][] = new int[m][n];
        return dfs(arr, 0 , 0, new HashMap<>());
    }

    private int dfs(int arr[][] , int m, int n , Map<String, Integer> map){
        if (m >= arr.length || n>=arr[0].length)
            return 0;
        if (m == arr.length-1 && n==arr[0].length-1)
            return 1;
        String key = m+"$"+n;
        if(map.containsKey(key))
            return map.get(key);    
        int count = 0;
        count+=dfs(arr, m, n+1, map);
        count+=dfs(arr, m+1, n, map);
        map.put(key, count);
        return count;
    }
}

