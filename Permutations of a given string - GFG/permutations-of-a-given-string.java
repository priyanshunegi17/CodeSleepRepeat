//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}


// } Driver Code Ends


class Solution {
    String swap(String s, int i, int j){
        StringBuilder sb = new StringBuilder(s);
        char ch = s.charAt(i);
        sb.setCharAt(i,s.charAt(j));
        sb.setCharAt(j,ch);
        return sb.toString();
    }
    
    void helper(String s, int index, List<String> ans){
        if(index>=s.length()){
            ans.add(s);
        }
        
        for(int i=index;i<s.length();i++){
            if(i>index && s.charAt(i)==s.charAt(i-1)) continue;
            s=swap(s,i,index);
            helper(s,index+1,ans);
            s=swap(s,i,index);
        }
        
    }
    
    public List<String> find_permutation(String S) {
        List<String> ans = new ArrayList<>();
        helper(S,0,ans);
        Collections.sort(ans);
        return ans;
    }
}