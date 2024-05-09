class Solution {
    public int findDuplicate(int[] nums) {
    
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                return i;
            }
            else{
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }
        return 0;
    }
}