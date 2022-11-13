class Solution {
    int getUniqueLength(String s){
        Set<Character> set = new HashSet<>();
        for(char ch:s.toCharArray()) set.add(ch);
        if(s.length()==set.size()){
            return set.size();
        }
        return -1;
    }
    int yoyo=0;
    void helper(List<String> arr, int index, String curr, String ans){
        int n=curr.length();
        yoyo=Math.max(getUniqueLength(curr),yoyo);
        if(index>=arr.size()) return;
        
        helper(arr,index+1,curr+arr.get(index),ans);
        helper(arr,index+1,curr,ans);
        
    }
    
    public int maxLength(List<String> arr) {
        String ans="";
        helper(arr,0,"",ans);
        return yoyo;
    }
}