class Solution {
    public boolean isAnagram(String s, String t) {

        int n1 = s.length();
        int n2 = t.length();
        if(n1!=n2) return false;
        
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<n1;i++){
            System.out.println(arr1[i]+" "+arr2[i]);
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
        
    }
}