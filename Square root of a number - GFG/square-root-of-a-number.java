//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution
{
    // function to return square of given number...
    long square(long n){
        return n*n;
    }
    
     long floorSqrt(long x)
	 {
	    // search space is from 1 to x..
		long low=1,high=x;
		long ans=0;
		while(low<=high){
		    long mid=(low+high)/2;
		    long sq =square(mid);
		    // if it's a perfect square...
		    if(sq==x){
		        ans=mid;
		        return ans;
		    }
		    // if squre is more then the given x.. searh in the left half...
		    if(sq>x){
		        high=mid-1;
		    }
		    // search in right half...
		    else{
		        ans=mid;
		        low=mid+1;
		    }
		}
		return ans;
	 }
}
