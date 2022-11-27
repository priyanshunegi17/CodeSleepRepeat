class Solution {
    
    int helper(HashSet<String> dict,int index,int n, String s,HashMap<Integer,Integer> map){
        if(index==n){
            return 1;
        }
        if(map.containsKey(index)) return map.get(index);
        String temp="";
        for(int i=index;i<n;i++){
            temp+=s.charAt(i);
            if(dict.contains(temp) && helper(dict,i+1,n,s,map)>0){
                map.put(index,1);
                return 1;
            }
        }
        map.put(index,0);
        return 0;
        
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<Integer,Integer> map = new HashMap<>();
        if(helper(set,0,s.length(),s,map)>0) return true;
        return false;
    }
}