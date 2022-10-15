//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


// https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
// Using Striver's YT Video..

class Solution 
{
    // function: for given mid, check how many groups can be made....
    static boolean calculateM(int arr[],int m,int mid){
        int n = arr.length;
        int count=1,curr=0;
        for(int i=0;i<n;i++){
            if(arr[i]>mid){
                return false;
            }
            curr+=arr[i];
            if(curr>mid){
                curr=arr[i];
                count++;
            }
        }
        return count<=m;
    }
    
    // Main function...
    public static int findPages(int[]A,int N,int M)
    {
        int min = Integer.MAX_VALUE,max=Integer.MIN_VALUE,sum=0;
        for(int i:A){
            sum+=i;
            min=i<min?i:min;
            max=i>max?i:max;
        }   
        // if only 1 group has to be created.. then max will be the sum..
        if(M==1){
            return sum;
        }
        // if number of groups is equals to size of the array.. then maximum element will be the answer..
        if(M==N){
            return max;
        }
        //(Edge case..)// if groups are more then N.. it's not possible...
        if(N<M){
            return -1;
        }
        // search space would be from minimum element upto the sum....
        int low=min,high=sum;
        int ans=-1;
        while(low<=high){
            int mid = (low+high)/2;
            // if it's true, then try to find minimum value by shifting in left half...
            // otherwise check in the right half...
            if(calculateM(A,M,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
};
