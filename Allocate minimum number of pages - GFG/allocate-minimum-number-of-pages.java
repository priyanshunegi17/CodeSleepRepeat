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


//User function Template for Java

class Solution 
{
    
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
    
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        int min = Integer.MAX_VALUE,max=Integer.MIN_VALUE,sum=0;
        for(int i:A){
            sum+=i;
            min=i<min?i:min;
            max=i>max?i:max;
        }   
        
        if(M==1){
            return sum;
        }
        if(M==N){
            return max;
        }
        if(N<M){
            return -1;
        }
        
        int low=min,high=sum;
        int ans=-1;
        while(low<=high){
            int mid = (low+high)/2;
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
