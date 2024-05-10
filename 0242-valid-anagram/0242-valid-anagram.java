class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1!=n2) return false;
    
        int[] arr = new int[26];
        for(int i=0;i<n1;i++){
            int curr = s.charAt(i)-'a';
            arr[curr]+=1;
        }
        for(int i=0;i<n2;i++){
            int curr = t.charAt(i)-'a';
            arr[curr]-=1;
        }
        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        
        return true;
        
    }
}