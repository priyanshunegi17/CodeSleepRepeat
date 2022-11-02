//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int checkPal(String s,int l,int r){
        if(l>r) return 1;
        if(s.charAt(l)!=s.charAt(r)) return 0;
        return checkPal(s,l+1,r-1);
    }
    
    int isPalindrome(String S) {
        return checkPal(S,0,S.length()-1);
    }
};