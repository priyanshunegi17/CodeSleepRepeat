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
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    long getPower(long a,long b){
        long res =1;
        for(int i=1;i<=b;i++){
            res*=a;
        }
        return res;
    }   
    
    
    public int NthRoot(int n, int m)
    {
        long tmp=0,res=-1;
        
        for(long i=1;getPower(i,(long)n)<=m;i++){
            tmp=getPower(i,(long)n);
            res=i;
        }
        if(tmp==m){
            return (int)res;
        }
        else{
            return -1;
        }
        
        
    }
}