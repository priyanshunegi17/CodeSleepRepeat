class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int mn = m+n;
        int i=m-1,j=n-1,k=m+n-1;
        while(i>=-1 && j>=0){
            if(i==-1){
                nums1[k--]=nums2[j--];
            }
            else if(nums1[i]>=nums2[j]){
                nums1[k--]=nums1[i--];
            }
            else{
                nums1[k--]=nums2[j--];
            }
        }
        
    }
}