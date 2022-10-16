//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String s;
            s = sc.next();
            
            Solution obj = new Solution();
            int res = obj.maxDepth(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

// https://practice.geeksforgeeks.org/problems/maximum-nesting-depth-of-the-parentheses/1
// ps: it was mentioned that the strings will be always VPS (valid parenthesis string)

class Solution {
    public static int maxDepth(String s) {
        int count=0,curr=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            // if it's opening parenthesis, increase the count...
            if(s.charAt(i)=='('){
                curr++;
                count=curr>count?curr:count;
            }
            // if it's closing parenthesis, then decrement the count by one...
            else if(s.charAt(i)==')'){
                curr--;
            }
        }
        return count;
    }
}
        
