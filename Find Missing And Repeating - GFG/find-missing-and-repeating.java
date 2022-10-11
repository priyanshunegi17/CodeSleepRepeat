//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// check "code with Alisha"
class Solve {
    int[] findTwoElement(int arr[], int n) {
    
        // declare a variable for calculating xor..
        int xorr = 0;
        // take xorr all all elements as well as xorr of number from 1 to N...
        for(int i=0;i<n;i++){
            xorr^=arr[i];
            xorr^=(i+1);
        }    
        
        // calculate the set bit..
        // it's a formula..  setbit = n & (~ n-1)... where n=number//
        int setBit = xorr&(~(xorr-1));

        // declare the result array to store repeating and missing number..
        int res[] = new int[2];
        
        // initially make both of them as 0..
        res[0]=0;  // bit set           // repeating
        res[1]=0;  // bit not set      // missing
        
        
        // now travers the array and get the setBit..
        // if it's set then put in first index, otherwise on 2nd index...
        for(int i=0;i<n;i++){
            if((arr[i]&setBit)!=0){
                res[0]^=arr[i];
            }
            else{
                res[1]^=arr[i];
            }
        // now xorr the resultant with numbers from 1 to N...
            if(((i+1)&setBit)!=0){
                res[0]^=(i+1);
            }
            else{
                res[1]^=(i+1);
            }
        }
        
        // verify whether the repeating and missing elements are on correct position..
        // if not, then just swap those....
        for(int i=0;i<n;i++){
            if(arr[i]==res[0]) break;
            if(arr[i]==res[1]){
                int temp = res[0];
                res[0]= res[1];
                res[1]=temp;
            }
        }
        return res;
    }
}