//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    boolean search(char[][] board,int i,int j,int row,int col,int k,String word){
        if(k==word.length()) return true;
        if(i<0 || j<0 || i==row || j==col || board[i][j]!=word.charAt(k)) return false;
        
        char ch=board[i][j];
        board[i][j]='#';
        boolean bool1=search(board,i,j+1,row,col,k+1,word);
        boolean bool2=search(board,i+1,j,row,col,k+1,word);
        boolean bool3=search(board,i,j-1,row,col,k+1,word);
        boolean bool4=search(board,i-1,j,row,col,k+1,word);
        board[i][j]=ch;
        return bool1 || bool2 || bool3 || bool4;
        
    }
    
    public boolean isWordExist(char[][] board, String word)
    {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)){
                    if(search(board,i,j,row,col,0,word)) return true;
                }
            }
        }
        return false;
    }
}