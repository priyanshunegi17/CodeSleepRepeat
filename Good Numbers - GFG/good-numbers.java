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


// https://practice.geeksforgeeks.org/problems/good-numbers4629/1

class Solution {
    boolean isGood(int n,int sum,int d){
        if(n==0) return true;
        int digit = n%10;
        if(digit==d) return false;
        if(digit<=sum) return false;
        // System.out.println(n+" , "+sum+" , "+d);
        return isGood(n/10,sum+digit,d);
        
    }
    ArrayList<Integer> goodNumbers(int L, int R, int D) {
        ArrayList<Integer> ans=new ArrayList<>();
            // System.out.println(isGood(942,1,0));
        for(int i=L;i<=R;i++){
            if(i%10==D) continue;
            if(isGood(i/10,i%10,D)) ans.add(i);
            // System.out.println(isGood(i/10,i%10,D));
        }
        return ans;
    }
}













