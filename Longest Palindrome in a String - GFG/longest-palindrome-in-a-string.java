//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isPalindrome(String s){
        int n=s.length();
        for(int i=0,j=n-1;i<=j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        
        return true;
    }
    static String longestPalin(String S){
        int n = S.length();
        String res="";
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                int len = j-i;
                if(len>max){
                String curr=S.substring(i,j);
                if(isPalindrome(curr)){
                        max=len;
                        res=curr;
                    }
                }
            }
        }
        
        return res;
    }
}