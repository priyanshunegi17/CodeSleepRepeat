class Solution {
    boolean helper(int[][]image,int i, int j,int color, int check){
        int m = image.length;
        int n=image[0].length;
        
        if(i<0 || j<0 || i>=m || j>=n || image[i][j]==color || image[i][j]!=check) return false;
        
        image[i][j]=color;
        if(helper(image,i,j+1,color,check)) return true;
        if(helper(image,i,j-1,color,check)) return true;
        if(helper(image,i+1,j,color,check)) return true;
        if(helper(image,i-1,j,color,check)) return true;
        
        return false;
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        helper(image,sr,sc,color,image[sr][sc]);
        return image;
    }
}