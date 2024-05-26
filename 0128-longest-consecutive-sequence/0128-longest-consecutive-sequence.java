class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        if(n==0) return 0;
        int maxx = 1;
        int curr=1;
        for(int i=0;i<n-1;i++){
            if(nums[i+1]-nums[i]==1){
                curr++;
                maxx=Math.max(curr,maxx);
            }
            else if(nums[i+1]-nums[i]==0){
                continue;
            }
            else{
                curr=1;
            }
        }
        return maxx;
    }
}