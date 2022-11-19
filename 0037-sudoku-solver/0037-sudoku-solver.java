class Solution {
    
    boolean helper(char[][] board,int n){
        
        boolean flag= false;
        int i=0,j=0;
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
            if(notClash((char)(num+48),i,j,board,n)){
                board[i][j]=(char)(num+48);
                if(helper(board,n))return true;
                board[i][j]='.';
            }    
        }
        return false;
    }
        
        boolean notClash(char ch,int i,int j,char[][] board,int n){
            
            // check for row and column
            for(int k=0;k<n;k++){
                if(board[i][k]==ch || board[k][j]==ch) return false;
            }
            
            // starting value of subbox..
            int s= (int)Math.sqrt(n);
            int startRow = i - i%s;
            int startCol = j - j%s;
            
            for(int r=startRow;r<startRow+s;r++){
                for(int c=startCol;c<startCol+s;c++){
                    if(board[r][c]==ch) return false;
                }
            }
            return true;
        }
        
    
    
    
    public void solveSudoku(char[][] board) {
        int n = board.length;
        int total = n*n;
        
        helper(board,n);
        
    }
}