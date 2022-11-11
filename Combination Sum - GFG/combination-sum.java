//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends


//https://practice.geeksforgeeks.org/problems/combination-sum-1587115620/1

class Solution
{
    static void helper(ArrayList<Integer> arr,int index,int currSum, int sum,ArrayList<Integer> curr,ArrayList<ArrayList<Integer>> ans){
        if(currSum==sum){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(currSum>sum) return;
        if(index>=arr.size()) return;
        
        // pick
        curr.add(arr.get(index));
        helper(arr,index,currSum+arr.get(index),sum,curr,ans);
        curr.remove(curr.size()-1);
        // not pick
    // skip the same elements (only if we are skipping the current element...)
        while(index<arr.size()-1 && arr.get(index)==arr.get(index+1)){
            // i++;
            index++;
        }
        helper(arr,index+1,currSum,sum,curr,ans);
    }
    
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr=new ArrayList<>();
        Collections.sort(A);
        helper(A,0,0,B,curr,ans);
        return ans;
    }
}