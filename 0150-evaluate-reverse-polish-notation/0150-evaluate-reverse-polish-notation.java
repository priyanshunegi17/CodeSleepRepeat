class Solution {
    public int evaluate(int a, int b, char ch){
        switch(ch){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }
        return -1;
    }
    public boolean letterOrDigit(String str){
        int n = str.length();
        if(n>1) return true;
        else if(n==1){
            if(Character.isLetterOrDigit(str.charAt(0))){
                return true;
            }
        }
        return false;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int n = tokens.length;
        for(int i=0;i<n;i++){
            if(letterOrDigit(tokens[i])){
                st.push(Integer.parseInt(tokens[i]));
            }
            else{
                char ch = tokens[i].charAt(0);
                int b = st.pop();
                int a = st.pop();
                int value = evaluate(a,b,ch);
                st.push(value);
            }
        }
        return st.pop();
    }
}