class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row[] = new int[9];
        int col[] = new int[9];
        int square[] = new int[9];
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if (board[i][j]=='.')
                    continue;
                int squareIndex = ((i/3)*3 + (j/3));
                int ch = board[i][j] -'1';
                if ( ( row[i] &  (1<<ch) ) >0 
                    || (col[j] &  (1<<ch) )>0 
                    ||  ( square[squareIndex] & (1<<ch) ) >0 ) {
                    return false;
                }
                row[i] |= (1<<ch);
                col[j] |= (1<<ch);
                square[squareIndex] |= (1<<ch);
            }
        }
        return true;
    }
}
