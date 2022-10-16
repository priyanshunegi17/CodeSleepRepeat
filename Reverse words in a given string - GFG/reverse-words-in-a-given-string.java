//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    StringBuilder reverse(StringBuilder s){
        int n=s.length();
        StringBuilder res = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            res.append(s.charAt(i));
        }
        return res;
    }
    String reverseWords(String S)
    {
        int n = S.length();
     StringBuilder tmp = new StringBuilder();
     StringBuilder res = new StringBuilder();
    for(int i=n-1;i>=0;i--){
        if(S.charAt(i)=='.'){
            res.append(reverse(tmp));
            res.append('.');
            tmp=new StringBuilder("");
        }
        else if(i==0){
            tmp.append(S.charAt(i));
            res.append(reverse(tmp));
        }
        else{
            tmp.append(S.charAt(i));
        }
    }
    
     return res.toString();
    }
}