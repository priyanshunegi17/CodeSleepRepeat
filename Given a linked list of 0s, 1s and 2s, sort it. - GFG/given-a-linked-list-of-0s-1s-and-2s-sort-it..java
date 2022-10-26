//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        int zero=0,one=0,two=0;
        Node check=head;
        while(check!=null){
            if(check.data==0){
                zero++;
            }
            else if(check.data==1){
                one++;
            }
            else{
                two++;
            }
            check=check.next;
        }
        int n = zero+one+two;
        Node head2 = new Node(0);
        Node curr=head2;
        for(int i=0;i<n;i++){
            Node newNode = null;
            if(i<zero){
                newNode = new Node(0);
            }
            else if(i<zero+one){
                newNode = new Node(1);
            }
            else{
                newNode = new Node(2);
            }
            curr.next=newNode;
            curr=curr.next;
        }
        return head2.next;
    }
}


