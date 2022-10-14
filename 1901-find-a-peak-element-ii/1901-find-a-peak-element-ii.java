// https://leetcode.com/problems/find-a-peak-element-ii/submissions/
// striver...

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        
        int ans[]=new int[2];
        
        int n = row*col;
        
        int low=0,high=n-1;
        while(low<=high){
            int mid = (low+high)/2;
            int check=1;
            //i-> row & j-> col
            int i=mid/col;
            int j=mid%col;
            int element = mat[i][j];
                // check top
                if(i!=0){
                    if(!(mat[i][j]>mat[i-1][j])){
                        check=0;
                    }
                }                
                // check bottom
                if(i!=row-1){
                    if(!(mat[i][j]>mat[i+1][j])){
                        check=0;
                    }
                }                
                // check left
                if(j!=0){
                    if(!(mat[i][j]>mat[i][j-1])){
                        check=0;
                    }
                }                
                // check right
                if(j!=col-1){
                    if(!(mat[i][j]>mat[i][j+1])){
                        check=0;
                    }
                }
                
                if(check==1){
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
                else{
                    low=low+1;
                }
            
        }
        
        
        return ans;
    }
}