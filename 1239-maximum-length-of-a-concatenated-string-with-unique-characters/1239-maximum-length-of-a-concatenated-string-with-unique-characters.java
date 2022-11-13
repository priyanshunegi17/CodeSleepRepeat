// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
class Solution {
    boolean checkUnique(String s,int []check){
        // self check
        int arr[] = new int[26];
        for(char ch:s.toCharArray()){
            if(arr[ch-'a']==1) return false;
            arr[ch-'a']=1;
        }
        
        for(char ch:s.toCharArray()){
            if(check[ch-'a']==1) return false;
        }
        return true;
    }
    
    int helper(List<String> arr, int index,int len,int check[]){
        if(index>=arr.size()){
            return len;
        }
        
        
        String s = arr.get(index);
        if(checkUnique(arr.get(index),check)){
            //pick
             for(char ch:s.toCharArray()){
                check[ch-'a']=1;
            }
            int op1 = helper(arr,index+1,len+s.length(),check);
            for(char ch:s.toCharArray()){
               check[ch-'a']=0;
            }
            int op2 = helper(arr,index+1,len,check);
            return Math.max(op1,op2);
        }
        else{
            return helper(arr,index+1,len,check);
        }
        
    }
    
    public int maxLength(List<String> arr) {
        int check[] = new int[26];
        return helper(arr,0,0,check);
        // return yoyo;
    }
}