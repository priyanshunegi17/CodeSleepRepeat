//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//https://practice.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1
// check striver's video.. similar to kth element of two sorted array..

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        if(m<n){
            return medianOfArrays(m,n,b,a);
        }
        int k = (n+m)/2;
        int low = Math.max(0,k-m);
        int high = Math.min(n,k);
        
        while(low<=high){
            int cut1 = (low+high)/2;
            int cut2 = k-cut1;
            
            int l1 = cut1==0?Integer.MIN_VALUE:a[cut1-1];
            int l2 = cut2==0?Integer.MIN_VALUE:b[cut2-1];
            int r1 = cut1==n?Integer.MAX_VALUE:a[cut1];
            int r2 = cut2==m?Integer.MAX_VALUE:b[cut2];
            
            if(l1<=r2 && l2<=r1){
                if((m+n)%2==0){
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
                }else{
                    return Math.min(r1,r2);
                }
            }
            if(l1>r2){
                high=cut1-1;
            }
            else{
                low=cut1+1;
            }
        }
        return 0;
    }
}

















