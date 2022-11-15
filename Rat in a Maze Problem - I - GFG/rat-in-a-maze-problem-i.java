//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    
    static void helper(int[][] m,int i,int j,int n,String curr,ArrayList<String> ans){
        if(i<0 || j<0 || i==n || j==n || m[i][j]==0) return;
        if(m[i][j]==-1) return;
        if(i==n-1 && j==n-1){
            ans.add(new String(curr));
            return;
        }
        int visited = m[i][j];
        m[i][j]=-1;
        helper(m,i,j-1,n,curr+'L',ans);
        helper(m,i,j+1,n,curr+'R',ans);
        helper(m,i-1,j,n,curr+'U',ans);
        helper(m,i+1,j,n,curr+'D',ans);
        m[i][j]=visited;
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        helper(m,0,0,n,"",ans);
        // System.out.println(ans);
        return ans;
    }
}