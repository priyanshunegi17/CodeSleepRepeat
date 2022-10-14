// https://leetcode.com/problems/find-a-peak-element-ii/submissions/
// striver...

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        
        int ans[]=new int[2];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int check = 1;
                int element = mat[i][j];
                // check top
                if(i!=0){
                    if(!(mat[i][j]>mat[i-1][j])){
                        check=0;
                        continue;
                    }
                }                
                // check bottom
                if(i!=row-1){
                    if(!(mat[i][j]>mat[i+1][j])){
                        check=0;
                        continue;
                    }
                }                
                // check left
                if(j!=0){
                    if(!(mat[i][j]>mat[i][j-1])){
                        check=0;
                        continue;
                    }
                }                
                // check right
                if(j!=col-1){
                    if(!(mat[i][j]>mat[i][j+1])){
                        check=0;
                        continue;
                    }
                }
                
                if(check==1){
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }
        return ans;
    }
}