//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int helper(String s,int index,int ans){
        if(index==s.length()) return ans;
        if(s.charAt(index)>='0' && s.charAt(index)<='9'){
            ans=ans*10+(s.charAt(index)-'0');
            return helper(s,index+1,ans);
        }
        else{
            return 0;
        }
    }
    
    int atoi(String str) {
        int isNegative=1;
        int ans=0;
	    if(str.charAt(0)=='-'){
	        isNegative=-1;
            ans=helper(str,1,0);
	    }
	    else{
            ans=helper(str,0,0);
	    }
	    if(ans==0){
	        return -1;
	    }
	    return ans*isNegative;
    }
}
