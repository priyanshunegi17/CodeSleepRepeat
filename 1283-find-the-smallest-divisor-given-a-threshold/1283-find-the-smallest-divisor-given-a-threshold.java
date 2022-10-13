class Solution {
    
    int getSum(int[] arr, int n){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+= (int)Math.ceil(arr[i]/(double)n);
        }
        return sum;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        Arrays.sort(nums);
        int low = 1, high =nums[n-1];
        int ans=0;
        while(low<=high){
            int mid = (low+high)/2;
            int count = getSum(nums,mid);
            // System.out.println(mid+" "+count+" ");
            if(count<=threshold){
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