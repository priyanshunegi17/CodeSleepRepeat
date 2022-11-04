class Solution {
    
    void helper(int[] nums,int index,List<Integer> curr,List<List<Integer>> ans){
        
        if(index>=nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        curr.add(nums[index]);
        helper(nums,index+1,curr,ans);
        curr.remove(curr.size()-1);
        helper(nums,index+1,curr,ans);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        helper(nums,0,curr,ans);
        return ans;
    }
}