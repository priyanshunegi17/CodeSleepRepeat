class Solution {
    public boolean isValid(String s) {
        int n  = s.length();
        Stack<Character> st = new Stack<>();
        Stack<Character> temp = new Stack<>();
        for(int i=0;i<n;i++){
                st.push(s.charAt(i));
        }
        while(!st.empty()){
            char ch=st.pop();
            if(ch==')' || ch==']'|| ch=='}') temp.push(ch);
            else if(temp.empty()) return false;
            else if((ch=='(' && temp.peek()==')')||(ch=='[' && temp.peek()==']')||(ch=='{' && temp.peek()=='}')){
                temp.pop();
            }
            else{
                return false;
            }
        }
        if(!temp.empty()) return false;
        
        return true;
    }
}