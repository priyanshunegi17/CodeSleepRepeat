class Solution {
    
    boolean isValid(char ch,int i,int j,char[][] board,int n){
        for(int k=0;k<n;k++){
            if(board[i][k]==ch || board[k][j]==ch) return false;
        }
        
        int nn = (int)Math.sqrt(n);
        int startRow = i - i%nn;
        int startCol = j - j%nn;
        
        for(int r=startRow;r<startRow+nn;r++){
            for(int c=startCol;c<startCol+nn;c++){
                if(board[r][c]==ch) return false;
            }
        }
        return true;
    }
    
    boolean solve(char[][] board,int n){
        int i=0,j=0;
        boolean flag=false;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(board[i][j]=='.'){
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }
        if(i==n && j==n) return true;
        for(int num=1;num<=n;num++){
            if(isValid((char)(num+48),i,j,board,n)){
                board[i][j]=(char)(num+48);
                if(solve(board,n)) return true;
                board[i][j]='.';
            }
        }
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        solve(board,board.length);   
    }
}