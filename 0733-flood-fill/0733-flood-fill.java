class Solution {
    
    boolean helper(int[][] image,int sr, int sc,int m, int n, int check, int color){
        if(sr<0 || sc<0 || sr>=m || sc>=n || image[sr][sc]==color || image[sr][sc]!=check) return false;
        
        image[sr][sc]=color;
        if(helper(image,sr,sc+1,m,n,check,color)) return true;        
        if(helper(image,sr,sc-1,m,n,check,color)) return true;        
        if(helper(image,sr+1,sc,m,n,check,color)) return true;        
        if(helper(image,sr-1,sc,m,n,check,color)) return true;
        return false;
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        helper(image,sr,sc,m,n,image[sr][sc],color);
        return image;
    }
}