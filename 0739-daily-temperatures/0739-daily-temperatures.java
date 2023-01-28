class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int ans[] = new int[n];
        for(int i=n-1;i>=0;i--){
            int curr = temperatures[i];
            if(st.isEmpty()){
                ans[i]=0;
                st.push(i);
            }
            else{
                if(curr>=temperatures[st.peek()]){
                    while(!st.isEmpty() && (temperatures[st.peek()]<=curr)){
                        st.pop();
                    }
                    if(!st.isEmpty()){
                        ans[i]=st.peek()-i;
                    }else{
                        ans[i]=0;
                    }
                    st.push(i);
                }
                else{
                    ans[i]=st.peek()-i;
                    st.push(i);
                }
            }
        }
    return ans;
    }
}