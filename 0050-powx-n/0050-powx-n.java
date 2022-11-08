class Solution {
    double helper(double x, long n, double ans){
        if(n==0) return ans;
        
        if(n%2==1){
            ans*=x;
            n=n-1;
        }
        else{
            x=x*x;
            n=n/2;
        }
        return helper(x,n,ans);
        
        
    }
    
    public double myPow(double x, int n) {
        double ans=1.0;
        long nn=n;
        if(nn<0) nn=nn*-1;
        
        ans = helper(x,nn,ans);
        
        // while(nn>0){
        //     if(nn%2==1){
        //         ans=ans*x;
        //         nn=nn-1;
        //     }
        //     else{
        //         x=x*x;
        //         nn=nn/2;
        //     }
        // }
        if(n<0) return (double)1.0/ans;
        return ans;
        
    }
}