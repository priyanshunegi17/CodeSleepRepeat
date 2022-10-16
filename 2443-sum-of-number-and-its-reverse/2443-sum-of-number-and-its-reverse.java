class Solution {
    int getReverse(int n){
        int r=0,tmp=0;
        while(n>0){
            r=r*10 + n%10;
            n/=10;
        }
        return r;
    }
    public boolean sumOfNumberAndReverse(int num) {
        
        for(int i=0;i<=num;i++){
            int val = getReverse(i);
            if(val+i==num){
                return true;
            }
        }
        return false;
    }
}