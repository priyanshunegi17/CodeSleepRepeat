class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int i=0;
        List<Integer> prev=new ArrayList<>();
        while(i<=rowIndex){
        List<Integer> curr = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(j==0 || i==j){
                    curr.add(1);
                }
                else{
                    curr.add(prev.get(j-1)+prev.get(j));
                }
            }
            if(i==rowIndex){
                ans=curr;
                return ans;
            }
            prev=curr;
            i++;
        }
        return ans;
    }
}