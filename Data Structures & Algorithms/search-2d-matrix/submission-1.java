class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int l= 0; int r= (row * col) -1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            int i = mid/col;int j = mid%col;
            if (matrix[i][j] <target) {
                l = mid+1;
            } else if (matrix[i][j] >target) {
                r= mid-1;
            } else {
                return true;
            }
        }
        return false;
    }
}
