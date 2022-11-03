//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int L = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            int D = Integer.parseInt(S[2]);
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.goodNumbers(L, R, D);
            for (int i : ans) System.out.print(i + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean isGood(int n,int d){
        int digit=n%10;
        int sum=digit;
        n/=10;
        if(digit==d) return false;
        while(n>0){
            digit = n%10;
            // System.out.println(digit+" -- "+sum);
            if(digit<=sum){
                return false;
            }
            if(digit==d) return false;
            sum+=digit;
            n/=10;
        }
        return true;
    }
    ArrayList<Integer> goodNumbers(int L, int R, int D) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=L;i<=R;i++){
            if(isGood(i,D)) ans.add(i);
        }
        return ans;
    }
}













