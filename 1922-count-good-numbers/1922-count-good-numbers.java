class Solution {
    int mod=1000000007;
    long getPow(long x,long n){
        if(n==0) return 1;
        long ans = getPow(x,n/2);
        if(n%2==0){
            return (ans*ans)%mod;
        }
        else{
            return (x*ans*ans)%mod;
        }
    }
    public int countGoodNumbers(long n) {
        long odd = n/2;
        long even = n/2+n%2;
        return (int)((getPow(5,even)%mod)*(getPow(4,odd)%mod)%mod);
         
    }
}


