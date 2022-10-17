class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==1) return 1;
        int i=0,max=0,idx=0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(i<n){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                for(int j=idx;j<i;j++){
                    char c = s.charAt(j);
                    if(map.get(c)>1){
                        map.put(c,map.get(c)-1);
                    }
                    else{
                        map.remove(c);
                    }
                    if(c==ch){
                        idx=j+1;
                      break;  
                    }
                }
                map.put(ch,1);
            }
            else{
                map.put(ch,1);
            }
            max=Math.max(max,map.size());
            i++;
        }
        return max;
    }
}