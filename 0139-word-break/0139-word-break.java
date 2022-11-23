class Solution {
    
    int helper(String s, int index,int n, HashSet<String> dict,HashMap<Integer,Integer>dp){
        System.out.println(index);
        if(index==n) return 1;
        if(dp.containsKey(index)) return dp.get(index);
        String temp="";
        for(int i=index;i<n;i++){
            temp+=s.charAt(i);
            if(dict.contains(temp) && helper(s,i+1,n,dict,dp)>0){
                dp.put(index,1);
                return 1;
            }
        }
        dp.put(index,0);
        return 0;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        HashMap<Integer,Integer>dp = new HashMap<>();
         return helper(s,0,s.length(),dict,dp)>0;
    }
}