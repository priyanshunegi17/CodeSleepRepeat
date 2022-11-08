class Solution {
    
    int helper(String s, int index, int ans,int n,int sign){
        if(index>=n) return ans;
        int digit = s.charAt(index)-'0';
        if(digit<0 || digit>9) return ans;
        if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && Integer.MAX_VALUE%10<digit)){
            return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE*-1;
        }
        // System.out.println(ans+" ");
        ans=ans*10+digit;
        // System.out.println(ans+" ");
        
        return helper(s,index+1,ans,n,sign);
    }
    
    public int myAtoi(String s) {
        int index=0,ans=0,sign=1,n=s.length();
        
        if(n==0) return 0;
        
        while(index<n && s.charAt(index)==' '){
            index++;
        }
        if(index==n) return 0;
        if(s.charAt(index)=='+' || s.charAt(index)=='-'){
            sign=s.charAt(index)=='+'?1:-1;
            index++;
        }
        // System.out.println(s+" "+index);
        ans = helper(s,index,ans,n,sign);
        
        return ans*sign;
    }
}