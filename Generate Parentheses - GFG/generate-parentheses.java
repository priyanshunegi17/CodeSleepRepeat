//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1

class Solution {
    void helper(int k, int index, String curr, List<String>ans,int open,int close){
        if(index>=2*k){
            ans.add(curr);
            return;
        }
        if(open<k){
            helper(k,index+1,curr+'(',ans,open+1,close);
        }
        if(close<open){
            helper(k,index+1,curr+')',ans,open,close+1);
        }
        
    }
    
    public List<String> AllParenthesis(int n) 
    {
        List<String> ans = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        String s = "";
        helper(n,0,s,ans,0,0);
        return ans;
    }
}












