class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row=mat.length,col=mat[0].length;
        
        int low=0,high=col-1;
        while(low<=high){
            int mid=(low+high)/2;
            int maxRow=0;
            for(int i=0;i<row;i++){
                maxRow=mat[i][mid]>mat[maxRow][mid]?i:maxRow;
            }
            boolean isLeftBig = mid-1>=low && mat[maxRow][mid-1]>mat[maxRow][mid];
            boolean isRightBig = mid+1<=high && mat[maxRow][mid+1]>mat[maxRow][mid];
            if(!isLeftBig && !isRightBig){
                return new int[]{maxRow,mid};   
            }
            if(isLeftBig){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return null;
    }
}