class Solution {
    
    List<Integer>swap(List<Integer>arr,int a, int b){
        int temp = arr.get(a);
        arr.set(a,arr.get(b));
        arr.set(b,temp);
        return arr;
    }
    
    void helper(int[] arr, int index, List<Integer> curr, List<List<Integer>> ans){
        int n =arr.length;
        if(index>=n){
            List<Integer> temp =new ArrayList<Integer>(curr);
            if(!ans.contains(temp)){
                ans.add(temp);
            }
            return;
        }
        
        for(int i=index;i<n;i++){
            // if(i>index && curr.get(i)==curr.get(i-1)) continue;
            if(i>index && curr.get(i)==curr.get(index)) continue;
            curr=swap(curr,i,index);
            helper(arr,index+1,curr,ans);
            curr=swap(curr,i,index);
        }
        
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        for(int i:nums){
            curr.add(i);
        }
        helper(nums,0,curr,ans);
        
        return ans;
    }
}