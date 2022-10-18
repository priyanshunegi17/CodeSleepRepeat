class Solution {
    String reverse(String s){
        String temp="";
        for(int i=s.length()-1;i>=0;i--){
            temp+=s.charAt(i);
        }
        return temp;
    }
    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        
        String ans="";
        int carry=0;
        int i=n1-1, j=n2-1;
        while(i>=0 || j>=0){
            if(i>=0 && j>=0){
                int val= carry + num1.charAt(i)+num2.charAt(j)-2*'0';
                carry = val/10;
                int dig = val%10;
                ans+=dig;
                i--;
                j--;
            }
            else if(i>=0){
                int val= carry + num1.charAt(i)-'0';
                carry = val/10;
                int dig = val%10;
                ans+=dig;
                i--;
            }
            else if(j>=0){
                int val= carry + num2.charAt(j)-'0';
                carry = val/10;
                int dig = val%10;
                ans+=dig;
                j--;
            }
        }
        if(carry>0){
            ans+=carry;
        }
        
        return reverse(ans);
    }
}