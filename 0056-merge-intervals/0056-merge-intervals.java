class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        
        int rows=intervals.length;
        int cols=intervals[0].length;
        
        List<int[]> curr = new ArrayList<>();        
        for(int i=0;i<rows;i++){
            if(curr.size()==0){
                curr.add(intervals[i]);
            }
            else{
                int[] arr = curr.get(curr.size()-1);
                int prevEnd = arr[1];
                
                // overlapping
                if(intervals[i][0]<=prevEnd){
                    arr[1]=Math.max(prevEnd,intervals[i][1]);
                    
                }
                // not overlapping
                else{
                    curr.add(intervals[i]);
                }
                
            }
        }
        return curr.toArray(new int[0][]);
    }
}