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
    void helper(List<String> arr, int index, String curr){
        int n=curr.length();
        int check=getUniqueLength(curr);
        if(check==-1) return;
        yoyo=Math.max(check,yoyo);
        if(index>=arr.size()) return;
        
        helper(arr,index+1,curr+arr.get(index));
        helper(arr,index+1,curr);
        
    }
    
    public int maxLength(List<String> arr) {
        helper(arr,0,"");
        return yoyo;
    }
}