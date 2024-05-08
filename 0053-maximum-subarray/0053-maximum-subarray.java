class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int maxx = nums[0];
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            maxx=sum>maxx?sum:maxx;
            if(sum<0){
                sum=0;
            }
        }
        return maxx;
    }
}