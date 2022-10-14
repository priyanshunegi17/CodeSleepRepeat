class Solution {
    boolean isPossible(int arr[],int m,int k,int d){
        int count=0;
        int n = arr.length;
        int curr=0;
        for(int i=0;i<n;i++){
            if(d>=arr[i]){
                curr++;
            }
            else{
                curr=0;
            }
            if(curr==k){
                count++;
                curr=0;
            }
        }
        // System.out.println("day: "+d+" m:"+m+" count:"+count);
        return count>=m;
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        int ans=-1;
        int low = 1, high=1000000000;
        while(low<=high){
            int mid=(low+high)/2;
        if(isPossible(bloomDay,m,k,mid)){
            ans=mid;
            high=mid-1;
        }
        else{
            low=mid+1;
        }
        
        }
        return ans;
    }
}