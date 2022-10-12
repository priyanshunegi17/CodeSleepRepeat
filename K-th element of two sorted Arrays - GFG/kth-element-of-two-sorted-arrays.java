//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//https://takeuforward.org/data-structure/k-th-element-of-two-sorted-arrays/
// https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1

// 

class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        // to reduce the time complexity, we'll keep the shorter array as arr1..
        // if it's not then just rearrange the sequence..
        if(n>m){
            return kthElement(arr2,arr1,m,n,k);
        }
        
        // the minimum element we can pick from the first array is 0.. or (k-m)
        // k-m because, if there are less then k elements in 2nd array, then we must pick some element from first (then minimum can not be zero..)
        int low = Math.max(0,k-m);
        //at max we can select all the elements of arr1.. or k..
        // k because if k is less then arr1 size, then no need to select all the elements..
        int high = Math.min(n,k);
        
        // traverse until....
        while(low<=high){
            // first cut will be the mid element/index...
            int cut1 = (low+high)/2; 
            // if we picked cut1 elements.. then remaining elements are k-cut1...
            int cut2 = k-cut1;
            
            // if cut1 is at the beginning of arr1, then make l1 as smallest possible value.. 
            //so that it'll not break the conditions
            // cut-1 will be max element of left half of both the arrays..
            // cut will be lowest element of right half of both the arrays..
            int l1 = cut1==0?Integer.MIN_VALUE:arr1[cut1-1];
            int l2 = cut2==0?Integer.MIN_VALUE:arr2[cut2-1];
            int r1 = cut1==n?Integer.MAX_VALUE:arr1[cut1];
            int r2 = cut2==m?Integer.MAX_VALUE:arr2[cut2];
            
            // if condition satisfies, then we got the result...
            // when all the elements in left half of both arrays are less then right half of array..
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }
            
            // if l1 is greater then the element at r2... it means we have to move to left in arr1... so change high
            if(l1>r2){
                high = cut1-1;
            }
            // otherwise we have to move to the right... so change low to cut..
            else{
                low = cut1+1;
            }
        }
        return 1;
    }
}