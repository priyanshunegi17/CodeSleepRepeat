// https://leetcode.com/problems/n-queens/

class Solution {
    // check if index reaches outside boundry...      
    boolean inbound(int i,int j, int n){
        if(i<0 || j<0 || i>=n || j>=n) return false;
        return true;
    }
    
    // validation check:
    // we can't place the queen in ('same-row' || 'same-column' || 'same-diagonal')
    boolean isValid(int r,int c, int n,List<String>curr){
        
        // check if other queen already exists in the same row or column...
        for(int i=0;i<n;i++){
            if(curr.get(r).charAt(i)=='Q' || curr.get(i).charAt(c)=='Q') return false;
        }
        
        // check for all the 4 possible diagonals for other queen....
        for(int i=0;i<n;i++){
            if(inbound(r-i,c-i,n) && curr.get(r-i).charAt(c-i)=='Q') return false;
            if(inbound(r-i,c+i,n) && curr.get(r-i).charAt(c+i)=='Q') return false;
            if(inbound(r+i,c-i,n) && curr.get(r+i).charAt(c-i)=='Q') return false;
            if(inbound(r+i,c+i,n) && curr.get(r+i).charAt(c+i)=='Q') return false;
        }
        return true;
    }
    
    void helper(int row, int n, List<String>curr, List<List<String>>ans){
        
        // if we reaches end of the row... it means we have successfully placed n-1 queens on the board... (0-based index)
        if(row==n){
            ans.add(new ArrayList<String>(curr));
            return;
        }
        
        // in every row, we have 'n' possible positions (i.e n-columns...). so check each of them
        for(int i=0;i<n;i++){            
            // if current position is valid to place the queen, then only proceed....
            if(isValid(row,i,n,curr)){
                // we can't set the char in 'String' directly.. that's why use StringBuilder for that...
                StringBuilder sb = new StringBuilder(curr.get(row));
                // make the changes...
                sb.setCharAt(i,'Q');
                curr.set(row,sb.toString());
                
                // move to next row....
                helper(row+1,n,curr,ans);
                // undo the changes...
                sb.setCharAt(i,'.');
                curr.set(row,sb.toString());
            }
        }
        
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr= new ArrayList<>();
        // create the matrix of n*n having all dots(.) initially...
        for(int i=0;i<n;i++){
            String s= "";
            for(int j=0;j<n;j++){
                s+='.';
            }
            curr.add(s);
        }
        
        helper(0,n,curr,ans);
        return ans;
    }
}