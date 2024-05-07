class Solution {
    public int trap(int[] height) {
        
        int n =height.length;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];
        
        int maxx=0;
        for(int i=0;i<n;i++){
            maxx=height[i]>maxx?height[i]:maxx;
            leftMax[i]=maxx;
        }
        maxx=0;
        for(int i=n-1;i>=0;i--){
             maxx=height[i]>maxx?height[i]:maxx;
            rightMax[i]=maxx;
        }
        int[] min= new int[n];
        for(int i=0;i<n;i++){
            min[i]=leftMax[i]<rightMax[i]?leftMax[i]:rightMax[i];
        }
        
        int[] calc = new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            calc[i]=min[i]-height[i];   
            sum+=calc[i];
        }
        
        return sum;
        
    }
}