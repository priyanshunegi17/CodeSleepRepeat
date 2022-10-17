//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


// https://practice.geeksforgeeks.org/problems/sum-of-beauty-of-all-substrings-1662962118/1
// as we know only 26 characters are only there... so better to use array instead of hashmap...


class Solution {
    // return max frequency in the count array..
    static int getMax(int arr[]){
        int max=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
    
    // return min frequency in the count array..
    static int getMin(int arr[]){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            // ignore 0, otherwise it'll be taken as minimum... which we don't want...
            if(arr[i]!=0){
                min=Math.min(min,arr[i]);
            }
        }
        return min;
    }
    
    public static int beautySum(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            // this array will store the count of each character..
            int charCount[] = new int[26];
            for(int j=i;j<n;j++){
                // increment the count...
                charCount[s.charAt(j)-'a']+=1;
                // calculate the beauty,, within the for loop itself....
                ans+=(getMax(charCount)-getMin(charCount));
            }
        }
        return ans;
    }
}
        
