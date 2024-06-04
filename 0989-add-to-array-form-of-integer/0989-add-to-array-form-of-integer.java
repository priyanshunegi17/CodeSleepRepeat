class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
        int n=num.length;
        
        List<Integer> nums = new ArrayList<>();
        
        int rem=0;
        for(int i=n-1;i>=0;i--){
            int curr=k%10;
            k=k/10;
            int sum=num[i]+curr+rem;
            rem=sum/10;
            nums.add(0,sum%10);
        }
        while(rem>0 || k>0){
              int curr=k%10;
            k=k/10;
            int sum=curr+rem;
            rem=sum/10;
            nums.add(0,sum%10);
        }
        return nums;
    }
}