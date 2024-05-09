class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int check = n/2;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
                if(map.get(i)>check){
                    return i;
                }
            }
            else{
                map.put(i,1);
            }
        }
        return nums[0];
    }
}