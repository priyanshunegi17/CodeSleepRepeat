class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        
        int ans[] = new int[n];
        
        for(int i=n-2;i>=0;i--){
            st.push(nums[i]);
        }
        
        for(int i=n-1;i>=0;i--){
            int curr=nums[i];
            if(st.isEmpty()){
                ans[i]=-1;
                st.push(curr);
            }
            else{
                while(!st.isEmpty() && st.peek()<=curr){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i]=-1;
                }
                else{
                    ans[i]=st.peek();
                }
                st.push(curr);
            }
        }
        return ans;
        
    }
}