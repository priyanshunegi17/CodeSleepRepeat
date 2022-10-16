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
    int atoi(String str) {
        int n=str.length();
        String tmp  = "";
        // for(int i=n;i>=0;i--){
        //     tmp+=str.charAt(i);
        // }
        int ans=0,neg=1;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='-' && i==0){
                neg=-1;
            }
            else if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                ans=ans*10+(str.charAt(i)-'0');
            }
            else{
                return -1;
            }
        }
        // System.out.println(ans);
        return ans*neg;
    }
}
