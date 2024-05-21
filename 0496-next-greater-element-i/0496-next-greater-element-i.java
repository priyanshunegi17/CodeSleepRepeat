class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        for(int i=n2-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            int res = st.isEmpty()?-1:st.peek();
            map.put(nums2[i],res);
            st.push(nums2[i]);
        }
        
        int[] res= new int[n1];
        int k=0;
        for(int i:nums1){
            res[k++]=map.get(i);
        }
        
        return res;
    }
}