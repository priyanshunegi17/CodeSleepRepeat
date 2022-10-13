//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static boolean calcDays(int[] arr,int D,int mid){
        int n = arr.length;
        
        int days=1,sum=0;
        for(int i=0;i<n;i++){
            if(sum+arr[i]<=mid){
                sum+=arr[i];
            }
            else{
                days++;
                sum=arr[i];
            }
        }
        if(days<=D){
            return true;
        }
        return false;
        
    }
    
    static int leastWeightCapacity(int[] arr, int N, int D) {
        int max=0,sum=0;
        for(int i=0;i<N;i++){
            sum+=arr[i];
            max=arr[i]>max?arr[i]:max;
        }
        
        int low = max, high = sum;
        int ans=0;
        while(low<=high){
            int mid = (low+high)/2;
            
            if(calcDays(arr,D,mid)){
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














