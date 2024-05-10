class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1!=n2) return false;
        
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i=0;i<n1;i++){
            int curr = s.charAt(i)-97; 
            arr1[curr]+=1;
        }
        for(int i=0;i<n2;i++){
            int curr = t.charAt(i)-97; 
            arr2[curr]+=1;
        }
        for(int i=0;i<n1;i++){
            int curr = s.charAt(i)-97;
            if(arr1[curr]!=arr2[curr]){
                return false;
            }
        }
        
        return true;
        
    }
}