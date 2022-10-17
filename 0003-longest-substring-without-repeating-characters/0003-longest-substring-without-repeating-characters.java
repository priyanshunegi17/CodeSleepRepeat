class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n= s.length();
        if(n==1){
            return 1;
        }
        int max=0;
        for(int i=0;i<n;i++){
            HashMap<Character,Integer> map = new HashMap<>();
            for(int j=i;j<n;j++){
                char ch = s.charAt(j);
                if(map.containsKey(ch)){
                      break;
                }
                else{
                    map.put(ch,1);
                }
                    max=Math.max(max,map.size());
            } 
        }
        
        return max;
    }
}