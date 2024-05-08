class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nn = m+n;
        int temp[] = new int[nn];
        int i=0,j=0,curr=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                temp[curr++]=nums1[i++];   
            }
            else{
                temp[curr++]=nums2[j++];
            }
        }
        
        while(i<m){
            temp[curr++]=nums1[i++];
        }
        while(j<n){
            temp[curr++]=nums2[j++];
        }
        
        
        for(int k=0;k<nn;k++){
            nums1[k]=temp[k];
        }
        
        
    }
}