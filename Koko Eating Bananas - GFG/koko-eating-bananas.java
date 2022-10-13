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


class Solution {
    
    static int calcTime(int piles[],int speed){
        int time=0;
        for(int i=0;i<piles.length;i++){
            time+=(piles[i]/speed)+((piles[i]%speed)!=0?1:0);
        }
        return time;
    }
    
    public static int Solve(int N, int[] piles, int H) {
        Arrays.sort(piles);
        int low = 1, high =piles[N-1];
        
        int ans=0;
        while(low<=high){
            int mid = (low+high)/2;
            int time = calcTime(piles,mid);
            // System.out.println(mid+" "+time);
            if(time<=H){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
        
