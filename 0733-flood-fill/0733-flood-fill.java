class Solution {
    
    boolean helper(int[][] image,int i,int j,int m,int n, int check,int color){
        
        if(i<0 || j<0 || i>=m || j>=n || image[i][j]!=check || image[i][j]==color) return false;
        
        image[i][j]=color;
        
        if(helper(image,i,j+1,m,n,check,color)) return true;
        if(helper(image,i,j-1,m,n,check,color)) return true;
        if(helper(image,i+1,j,m,n,check,color)) return true;
        if(helper(image,i-1,j,m,n,check,color)) return true;
        return false;
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n=image[0].length;
        helper(image,sr,sc,m,n,image[sr][sc],color);
        return image;
        
    }
}