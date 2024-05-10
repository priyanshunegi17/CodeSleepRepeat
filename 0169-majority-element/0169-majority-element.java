class Solution {
    public int majorityElement(int[] nums) {
        
        int element=0;
        int count=0;
        int n = nums.length;
        
        for(int i=0;i<n;i++){
           if(count==0){
               element = nums[i];
               count++;
           }
            else if(nums[i]==element){
                count++;
            }
            else if(nums[i]!=element){
                count--;
            }
        }
        return element;
    }
}