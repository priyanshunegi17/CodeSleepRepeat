class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            mini=Math.min(mini,prices[i]);
            maxi=Math.max((prices[i]-mini),maxi); 
        }
        return maxi;
        
    }
}