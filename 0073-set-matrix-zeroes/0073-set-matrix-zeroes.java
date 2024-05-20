class Solution {
    public void setZeroes(int[][] matrix) {
        int rows= matrix.length;
        int cols = matrix[0].length;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0){
                    for(int a=0;a<rows;a++){
                        for(int b=0;b<cols;b++){
                            if((a==i || b==j)&&matrix[a][b]!=0){
                                matrix[a][b]=9090;
                            }
                        }
                    }
                }
            }
        }
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==9090){
                    matrix[i][j]=0;
                }
            }
        }
        
        
    }
}