class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int n = nums.length;
        int num=0;
        for(int i=0;i<n;i++){
            num^=nums[i];
        }
        return num;
        
    }
}