//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends


//  https://practice.geeksforgeeks.org/problems/k-th-missing-element3635/1

class Complete{
    
    int KthMissingElement(int arr[], int n, int k)
    {
        int actualSum=0;
        // calculate the sum of all elements of array...
        for(int i=0;i<n;i++){
            actualSum+=arr[i];
        }
        // max element present in the array..
        int mac = arr[n-1];
        // calculate the actual sum from 1 to max element..
        int sum = (mac*(mac+1))/2;
        // if calculated sum is equal to actual Sum, it means no element is missing..
        if(sum==actualSum){
            return -1;
        }
        
        // c counter will be used to keep track of missing numbers...
        // if it reaches k, then we'll return that number...
        int c=0;
        // so the number will start from 1st value present in the array..
        int b=arr[0];
        for(int i=0;i<n;i++){
            // if values are not equal, means the elment is missing...
            if(arr[i]!=b){
                // increment missing counter by 1
                c++;
                // if it becomes equal to k, simply return it...
                if(c==k){
                    return b;
                }
                // if something is missing, we should avoid incrementing i(which is increasing by 1 default)
                i--;
                b++;
            }
            else{
                b++;
            }
        }
        return -1;
    }
}











//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Complete obj = new Complete();
		   
		    int res = obj.KthMissingElement(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}



// } Driver Code Ends