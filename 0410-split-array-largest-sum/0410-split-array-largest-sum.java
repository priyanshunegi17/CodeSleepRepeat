class Solution {
    
    boolean findGroups(int arr[],int k,int mid){
        int n =arr.length;
        int curr=0,count=1;
        for(int i=0;i<n;i++){
            curr+=arr[i];
            if(curr>mid){
                curr=arr[i];
                count++;
            }
        }
        return count<=k;
    }
    public int splitArray(int[] nums, int k) {
        int max=Integer.MIN_VALUE,sum=0;
        for(int i:nums){
            sum+=i;
            max=i>max?i:max;
        }
        int low=max,high=sum,ans=0;
        while(low<=high){
            int mid =(low+high)/2;
            if(findGroups(nums,k,mid)){
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













