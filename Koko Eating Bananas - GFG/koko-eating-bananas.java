//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

// https://practice.geeksforgeeks.org/problems/koko-eating-bananas/1
// Code with Alisha...

class Solution {
    
    static int calcTime(int[] piles,int speed){
        int n = piles.length;
        int count=0;
        for(int i=0;i<n;i++){
            count+=(int)Math.ceil(piles[i]/(double)speed);
        }
        return count;
    }
    
    public static int Solve(int N, int[] piles, int H) {
        
        // sort the array... 
        Arrays.sort(piles);
        int last = piles[N-1];
        if(N==H){
            return last;
        }
        int min=Integer.MAX_VALUE;
        int low=1,high=last;
        while(low<=high){
            int mid = (low+high)>>1;
            int val = calcTime(piles,mid);
            if(val<=H){
                min = mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return min;
    }
}
        
