class Solution {
    boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
     return true;   
    }
    
    void helper(String s,int index,List<String>curr,List<List<String>>ans){
        if(index==s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                curr.add(s.substring(index,i+1));
                helper(s,i+1,curr,ans);
                curr.remove(curr.size()-1);
            }
        }
        
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans= new ArrayList<>();
        List<String> curr = new ArrayList<>();
        helper(s,0,curr,ans);
        return ans;
    }
}