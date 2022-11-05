//{ Driver Code Starts
//Initial Template for Java

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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    void helper(String s,int index,String curr,List<String> ans){
        if(index>=s.length()){
            if(curr.length()==0) return;
            ans.add(curr);
            return;
        }
        curr+=s.charAt(index);
        helper(s,index+1,curr,ans);
        curr=curr.substring(0,curr.length()-1);
        helper(s,index+1,curr,ans);
    }
    
    public List<String> AllPossibleStrings(String s)
    {
        List<String> ans = new ArrayList<>();
        helper(s,0,"",ans);
        Collections.sort(ans);
        return ans;
    }
}