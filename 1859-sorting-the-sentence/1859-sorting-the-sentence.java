class Solution {
    public String sortSentence(String s) {
        String[] str = s.split(" ");
        int n = str.length;
        String arr[] = new String[n];
        for(String st:str){
            int i = st.charAt(st.length()-1)-'0';
            arr[i-1]=st.substring(0,st.length()-1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<arr.length-1;i++){
            sb.append(arr[i]).append(" ");
        }
        sb.append(arr[arr.length-1]);
        
        return sb.toString();
    }
}