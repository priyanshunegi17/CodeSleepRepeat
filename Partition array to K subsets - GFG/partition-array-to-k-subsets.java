//{ Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method */

class Solution
{
    
    void helper(int arr[],int index,int currSum,int sum, ArrayList<Integer> curr,Set<ArrayList<Integer>> set){
        if(currSum==sum){
            set.add(new ArrayList<>(curr));
            return;
        }
        if(currSum>sum) return;
        if(index>=arr.length) return;
        
        // check
        curr.add(arr[index]);
        helper(arr,index+1,currSum+arr[index],sum,curr,set);
        curr.remove(curr.size()-1);
        while(index<arr.length-1 && arr[index]==arr[index+1]) index++;
        helper(arr,index+1,currSum,sum,curr,set);
    }
    
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	
	    ArrayList<Integer> curr = new ArrayList<>();
	    int sum = 0;
	    for(int i:a) sum+=i;
	    if(sum%k!=0) return false;
	    sum=sum/k;
	    Arrays.sort(a);
	    Set<ArrayList<Integer>> set = new HashSet<>();
	    helper(a,0,0,sum,curr,set);
	   // System.out.println("size: "+set.size());
	   // System.out.println(set);
	    return set.size()>=k;
    }
}
