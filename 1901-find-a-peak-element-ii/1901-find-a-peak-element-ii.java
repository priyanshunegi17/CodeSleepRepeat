// https://leetcode.com/problems/find-a-peak-element-ii/submissions/
// Approch: using binary search:
// first try to find mid column and find the maximum element in that column..
// once we got the max element in a column, check for the left and right element in the same row.. and compare with them.
// if the max element of mid column is greater then both left and right element, then return it..
// otherwise if left element is big, then move to left otherwise right...

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int row=mat.length,col=mat[0].length;
        
        int startCol=0,endCol=col-1;
        while(startCol<=endCol){
            int mid=(startCol+endCol)/2;
            // variable to store the row of maximum element in the mid column...
            int maxRow=0;
            for(int i=0;i<row;i++){
                maxRow=mat[i][mid]>mat[maxRow][mid]?i:maxRow;
            }
            // check for left and right element, and compare with the max element of mid column.
            boolean isLeftBig = mid-1>=startCol && mat[maxRow][mid-1]>mat[maxRow][mid];
            boolean isRightBig = mid+1<=endCol && mat[maxRow][mid+1]>mat[maxRow][mid];
            if(!isLeftBig && !isRightBig){
                return new int[]{maxRow,mid};   
            }
            if(isLeftBig){
                endCol=mid-1;
            }
            else{
                startCol=mid+1;
            }
        }
        return null;
    }
}