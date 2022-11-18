class Solution {
    
    void helper(int[][] arr,int check,int i,int j,int m,int n,int k){
        if(i<0 || j<0 || i>=m || j>=n||arr[i][j]!=check || arr[i][j]==k) return;
        // if(arr[i][j]==-1) return;
        int visited=arr[i][j];
        
        arr[i][j]=k;
        helper(arr,check,i,j-1,m,n,k);
        helper(arr,check,i,j+1,m,n,k);
        helper(arr,check,i-1,j,m,n,k);
        helper(arr,check,i+1,j,m,n,k);
        // arr[i][j]=k;
        
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int check = image[sr][sc];
        helper(image,check,sr,sc,m,n,color);
        return image;
        
    }
}