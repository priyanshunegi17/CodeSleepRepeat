//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

// code with Alisha...

class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // create the arraylist to store resultant pairs...
        ArrayList<int[]> res = new ArrayList<>();
        
        // sort the intervals by comparing first index of each pair..
        Arrays.sort(Intervals,(a,b)->a[0]-b[0]);
        
        //number of rows in the Intervals..
        int n = Intervals.length;
        
        if(n<=1){
            return Intervals;
        }
        // create a row and store first pair...
        int row[] = Intervals[0];
        // add into result...
        res.add(row);
        
        // loop through pairs..
        for(int[] interval:Intervals){
            // if element 0'th index of current interval is less then element at 1'st index of previous pair,
            // then change the value of previous pair's 1st index
            if(interval[0]<=row[1]){
                row[1]=Math.max(interval[1],row[1]);
            }
            // otherwise store the current pair in the res...
            else{
                row = interval;
                res.add(row);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}





















