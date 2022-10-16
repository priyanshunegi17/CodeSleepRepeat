//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String s;
            s = sc.next();
            
            Solution obj = new Solution();
            int res = obj.maxDepth(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxDepth(String s) {
        int count=0,curr=0;
        int n=s.length();
        List<Character> tmp = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                // tmp.add('(');
                curr++;
                count=curr>count?curr:count;
            }
            else if(s.charAt(i)==')'){
                curr--;
            }
        }
        return count;
    }
}
        
