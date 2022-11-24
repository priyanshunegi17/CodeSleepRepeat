class Solution {
    
    int solve(String s,int index,int n, HashSet<String> dict,HashMap<Integer,Integer> map){
        if(index==n){
            return 1;
        }
        if(map.containsKey(index)) return map.get(index);
        String temp = "";
        for(int i=index;i<n;i++){
            temp+=s.charAt(i);
            if(dict.contains(temp) && solve(s,i+1,n,dict,map)>0){
                map.put(index,1);
                return 1;
            }
        }
        map.put(index,0);
        return 0;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> dict = new HashSet<>(wordDict);
        HashMap<Integer,Integer> map = new HashMap<>();
        return solve(s,0,s.length(),dict,map)>0;
        
    }
}