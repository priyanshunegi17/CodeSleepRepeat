class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int leftMin[] = new int[n];
        int rightMax[]=new int[n];
        
        int min=prices[0];
        for(int i=0;i<n;i++){
            min=prices[i]<min?prices[i]:min;
            leftMin[i]=min;
        }
        
        int maxx = prices[n-1];
        for(int i=n-1;i>=0;i--){
            maxx=prices[i]>maxx?prices[i]:maxx;
            rightMax[i]=maxx;
        }
        
        int res = 0;
        for(int i=0;i<n;i++){
            int curr = rightMax[i]-leftMin[i];
            res=curr>res?curr:res;
        }
        return res;
    }
}