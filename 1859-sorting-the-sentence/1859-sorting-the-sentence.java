class Solution {
    public String sortSentence(String s) {
        int n=s.length();
        int count=1;
        for(int i=0;i<n;i++){
            if(s.charAt(i)==' '){
                count++;
            }
        }
        // System.out.println(count);
        String arr[] = new String[count+1];
        String temp = "";
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(s.charAt(i)==' '){
                temp="";
            }
            else if(ch>='1' && ch<='9'){
                arr[ch-'0']=temp;
            }
            else{
                temp+=ch;
            }
        }
        String res = "";
        for(int i=1;i<arr.length-1;i++){
            res+=arr[i];
            res+=' ';
        }
        res+=arr[arr.length-1];
        
        return res;
        }
}