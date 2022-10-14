//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            String line[] = read.readLine().trim().split("\\s+");
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[c++]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    // function to find the number of elements greater then 'element'
    int elementsLessThenMid(int arr[],int element){
        int n = arr.length;
        int low = 0,high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<=element){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
    
    int median(int matrix[][], int r, int c) {
        // high is upper limit for element within array..
        int low=1,high=2000;
        int n=r*c;
        while(low<=high){
            int mid = (low+high)/2;
            int cnt=0;
            // count number of elements less then mid...
            for(int i=0;i<r;i++){
                cnt+=elementsLessThenMid(matrix[i],mid);
            }
            // median.. which will be greater then n/2 elements...
            if(cnt<=(n/2)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
}