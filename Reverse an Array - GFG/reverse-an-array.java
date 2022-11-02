import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
     static void reverseArray(int arr[],int l,int r){
         if(l>r){
             return;
         }
         int temp=arr[l];
         arr[l]=arr[r];
         arr[r]=temp;
         reverseArray(arr,l+1,r-1);
         
     }
     
	public static void main (String[] args)
	 {
	     Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	while(t-->0){
    	    int n = sc.nextInt();
    	    int arr[] = new int[n];
    	    for(int i=0;i<n;i++){
    	        arr[i]=sc.nextInt();
    	    }
    	    reverseArray(arr,0,n-1);
    	    for(int i:arr){
    	        System.out.print(i+" ");
    	    }
    	    System.out.println();
    	    
    	}
	 }
}