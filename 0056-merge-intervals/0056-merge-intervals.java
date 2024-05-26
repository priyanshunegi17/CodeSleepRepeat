class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        
        int rows= intervals.length;
        int cols = intervals[0].length;
        
        List<int[]> prev = new ArrayList<>();
        
        for(int i=0;i<rows;i++){
            if(i==0){
                prev.add(intervals[i]);
            }
            else{
                int[] arr = prev.get(prev.size()-1);
                int prevEnd = arr[1];
                
                if(prevEnd>=intervals[i][0]){
                    arr[1]=Math.max(prevEnd,intervals[i][1]);
                }
                else{
                    prev.add(intervals[i]);
                }
                
            }
        }
        return prev.toArray(new int[0][]);
        
    }
}