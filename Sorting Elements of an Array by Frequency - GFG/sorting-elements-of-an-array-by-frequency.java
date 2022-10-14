import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 Scanner sc = new Scanner(System.in);
	 
	 int t = sc.nextInt();
	 while(t-->0){
	     int n = sc.nextInt();
	   //  int arr[] = new int[n];
	   ArrayList<Integer> arr= new ArrayList<>();
	     
	     HashMap<Integer,Integer> map = new HashMap<>();
	     
	     for(int i=0;i<n;i++){
	       //  arr[i]=sc.nextInt();
	       //  if(map.containsKey(arr[i])){
	       //      map.put(arr[i],map.get(arr[i])+1);
	       //  }
	       //  else{
	       //      map.put(arr[i],1);
	       //  }
	         arr.add(sc.nextInt());
	         if(map.containsKey(arr.get(i))){
	             map.put(arr.get(i),map.get(arr.get(i))+1);
	         }
	         else{
	             map.put(arr.get(i),1);
	         }
	     }
	     
        Collections.sort(arr,new Comparator<Integer>(){
            public int compare(Integer n1, Integer n2){
                int freq1 = map.get(n1);
                int freq2 = map.get(n2);
                
                if(freq1==freq2){
                    return n1-n2;
                }else{
                    return freq2-freq1;
                }
                
            }
        });
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
	 }
	 
	 }
}