//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Solution obj = new Solution();
            System.out.println(obj.reverse(sc.next()));
        }
	}
}

// } Driver Code Ends


class Solution {
    
    public String reverse(String S){
        String res ="";
        Stack<Character> st = new Stack<>();
        int n = S.length();
        for(int i=0;i<n;i++){
            st.push(S.charAt(i));
        }
        while(!st.empty()){
            res+=st.pop();
        }
        return res;
    }

}