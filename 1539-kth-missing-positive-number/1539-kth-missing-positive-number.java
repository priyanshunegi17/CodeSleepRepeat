class Solution {
    
    public int findKthPositive(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int missing = arr[n-1]-arr[0]+1;
        
        int b = 1;
        for(int i=0;i<n;i++){
            if(arr[i]!=b){
                k--;
                if(k==0){
                    return b;
                }
                b++;
                i--;
            }
            else{
                b++;
            }
        }
        return b+k-1;
    }
}