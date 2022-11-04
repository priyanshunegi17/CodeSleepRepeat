class Solution {
    
    void reverse(char[] s,int left,int right){
        if(left>=right){
            return;
        }
        char ch = s[left];
        s[left]=s[right];
        s[right]=ch;
        reverse(s,left+1,right-1);
        
    }
    
    public void reverseString(char[] s) {
        reverse(s,0,s.length-1);
    }
}