class Solution {
    
    void helper(int[] arr,int index,List<Integer> curr,List<List<Integer>> ans){
        
        if(index>=arr.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        curr.add(arr[index]);
        helper(arr,index+1,curr,ans);
        curr.remove(curr.size()-1);
        while(index<arr.length-1 && arr[index]==arr[index+1]) index++;
        helper(arr,index+1,curr,ans);
        
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>();       
         List<Integer> curr = new ArrayList<>();       
        Arrays.sort(nums);
        helper(nums,0,curr,ans);
        return ans;
    }
}