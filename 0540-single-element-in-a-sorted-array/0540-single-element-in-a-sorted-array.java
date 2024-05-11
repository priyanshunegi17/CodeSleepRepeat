class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int n = nums.length;
        
        if(n==1) return nums[0];
        
        for(int i=0;i<n-1;i++){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
            else{
                i++;
            }
        }
        return nums[n-1];
        
    }
}