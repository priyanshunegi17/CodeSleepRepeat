class Solution {
    boolean helper(int[][] image,int i, int j,int m, int n, int color,int check){
        if(i<0 || j<0 || i>=m || j>=n || image[i][j]==color || image[i][j]!=check) return false;
        
        image[i][j]=color;
        if(helper(image,i,j+1,m,n,color,check)) return true;
        if(helper(image,i,j-1,m,n,color,check)) return true;
        if(helper(image,i+1,j,m,n,color,check)) return true;
        if(helper(image,i-1,j,m,n,color,check)) return true;
        
        return false;
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        helper(image,sr,sc,m,n,color,image[sr][sc]);
        return image;
    }
}