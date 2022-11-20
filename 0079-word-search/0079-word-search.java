class Solution {
    
    boolean helper(char[][] board,int i,int j, int m ,int n,int k, String word){
        if(k==word.length()){
            return true;
        }
        
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]=='#' || board[i][j]!=word.charAt(k)) return false;
        
        char ch = board[i][j];
        board[i][j]='#';
        if(helper(board,i,j+1,m,n,k+1,word)) return true;
        if(helper(board,i,j-1,m,n,k+1,word)) return true;
        if(helper(board,i+1,j,m,n,k+1,word)) return true;
        if(helper(board,i-1,j,m,n,k+1,word)) return true;
        board[i][j]=ch;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(board,i,j,m,n,0,word)) return true;
                }
            }
        }
        return false;
        
    }
}