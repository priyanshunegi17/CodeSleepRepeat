class Solution {
    boolean isPresent(String curr, HashSet<String> dict){
        if(dict.contains(curr)) return true;
        return false;
    }
    
    int helper(String s,int index, HashSet<String> dict,HashMap<Integer,Integer>map){
        int n = s.length();
        if(index==n) return 1;
        if(map.containsKey(index)){
            return map.get(index);
        }
        String temp =  "";
        for(int i=index;i<n;i++){
            temp+=s.charAt(i);
            if(isPresent(temp,dict)){
                if(helper(s,i+1,dict,map)>0){
                    map.put(index,1);
                    return 1;
                }
            }
        }
        map.put(index,0);
        return 0;
        
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String str:wordDict){
            set.add(str);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = helper(s,0,set,map);
        return ans>0;
    }
}