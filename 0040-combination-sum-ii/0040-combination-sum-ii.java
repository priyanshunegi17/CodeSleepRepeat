class Solution {
    
    void helper(int[] arr,int index, int currSum,int target,List<Integer> curr,List<List<Integer>> ans){
        
        if(currSum==target){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(currSum>target) return;
        if(index>=arr.length) return;
        
        
        curr.add(arr[index]);
        helper(arr,index+1,currSum+arr[index],target,curr,ans);
        curr.remove(curr.size()-1);
        while(index<arr.length-1 && arr[index]==arr[index+1]) index++;
        helper(arr,index+1,currSum,target,curr,ans);
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> curr= new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,0,0,target,curr,ans);
        return ans;
        
    }
}