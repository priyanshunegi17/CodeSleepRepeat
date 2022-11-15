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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int[][] ans = ob.ShortestDistance(matrix);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    boolean helper(int[][]arr,int i,int j, int n,int[][] ans){
        if(i==n-1 && j==n-1){
            ans[i][j]=1;
            return true;
        }
        if(i>=n|| j>=n || arr[i][j]==0){
            return false;
        }
        ans[i][j]=1;
        for(int steps=1;steps<=arr[i][j];steps++){
            if(helper(arr,i,j+steps,n,ans)) return true;
            if(helper(arr,i+steps,j,n,ans)) return true;
        }
        ans[i][j]=0;
        return false;
        
    }
    public int[][] ShortestDistance(int[][] matrix)
    {
        int n = matrix.length;
        int[][] ans = new int[n][n];
        if(!helper(matrix,0,0,n,ans)) return new int[][]{{-1}};
        // helper(matrix,0,0,n,ans);
        // System.out.println(ans);
        return ans;
    }
}