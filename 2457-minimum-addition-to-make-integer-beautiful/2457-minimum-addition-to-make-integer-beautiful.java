class Solution {
    int getSum(long num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
    public long makeIntegerBeautiful(long n, int target) {
        int currSum=getSum(n);
        if(currSum<=target){
            return 0;
        }
        long base=1;
        long n0=n;
        while(getSum(n)>target){
            n=(n/10)+1;
            base*=10;
        }
        return n*base-n0;
    }
}