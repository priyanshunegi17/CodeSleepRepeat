class Solution {
    
    void helper(ArrayList<Integer> arr,int index, int currSum,int k,int target,List<Integer> curr,List<List<Integer>> ans){
        // System.out.println("-> "+curr);
        if(curr.size()>k) return;
        if(curr.size()==k && currSum==target){
            List<Integer> res = new ArrayList<>(curr);
            ans.add(res);
            return;
        }
        if(index>=arr.size()) return;
        
        curr.add(arr.get(index));
        helper(arr,index+1,currSum+arr.get(index),k,target,curr,ans);
        curr.remove(curr.size()-1);
        helper(arr,index+1,currSum,k,target,curr,ans);
        
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int limit = Math.min(n-k+1,9);
        for(int i=1;i<=limit;i++){
            arr.add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr= new ArrayList<>();
        helper(arr,0,0,k,n,curr,ans);
        return ans;
    }
}