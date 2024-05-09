class Solution {
    public void sortColors(int[] nums) {
        
        int a=0,b=0,c=0;
        for(int i:nums){
            if(i==0){
                a++;
            }
            else if(i==1){
                b++;
            }
            else{
                c++;
            }
        }
            for(int k=0;k<nums.length;k++){
                if(a>0){
                    nums[k]=0;
                    a--;
                }
                else if(b>0){
                    nums[k]=1;
                    b--;
                }
                else{
                    nums[k]=2;
                    c--;
                }
            }
    }
}