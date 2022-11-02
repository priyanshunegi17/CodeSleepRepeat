//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    //taking total number of elements
		    int n=sc.nextInt();
		    
		    //calling printFibb() method
		    long[] res = new Solution().printFibb(n);
		    
		    //printing the elements of the array
		    for (int i = 0; i < res.length; i++)
		        System.out.print (res[i]+" ");
		    System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    static HashMap<Integer,Long> map = new HashMap<>();
    static long getFib(int n){
        if(n==1 || n==2) return 1;
        if(map.containsKey(n)){
            return map.get(n);
        }
        else{
            return getFib(n-1)+getFib(n-2);
        }
    }
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        long res[] = new long[n];
        int i=1;
        while(i<=n){
            long val=getFib(i);
            res[i-1]=val;
            map.put(i,val);
            i++;
        }
        return res;
    }
}