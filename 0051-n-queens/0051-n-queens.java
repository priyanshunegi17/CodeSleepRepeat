class Solution {
    
    boolean inbound(int i,int j,int n){
        if(i<0 || j<0 || i>=n || j>=n) return false;
        return true;
    }
    
    boolean checkValidPosition(int r, int c, int n,List<String> curr){
        
        for(int i=0;i<n;i++){
            if(curr.get(r).charAt(i)=='Q' || curr.get(i).charAt(c)=='Q') return false;
        }
        
        for(int i=0;i<n;i++){
            if(inbound(r-i,c-i,n) && curr.get(r-i).charAt(c-i)=='Q') return false;
            if(inbound(r-i,c+i,n) && curr.get(r-i).charAt(c+i)=='Q') return false;
            if(inbound(r+i,c-i,n) && curr.get(r+i).charAt(c-i)=='Q') return false;
            if(inbound(r+i,c+i,n) && curr.get(r+i).charAt(c+i)=='Q') return false;
        }
        return true;
    }
    
    void helper(int row, int n, List<String> curr,List<List<String>> ans){
        if(row>=n){
            ans.add(new ArrayList<String>(curr));
            return;
        }
        
        for(int i=0;i<n;i++){
            if(checkValidPosition(row,i,n,curr)){
                StringBuilder sb = new StringBuilder(curr.get(row));
                sb.setCharAt(i,'Q');
                curr.set(row,sb.toString());
                helper(row+1,n,curr,ans);
                sb.setCharAt(i,'.');
                curr.set(row,sb.toString());
            }
        }
        
    }
    
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr= new ArrayList<>();
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






