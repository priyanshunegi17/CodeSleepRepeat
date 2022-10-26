//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node last = reverse(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
    
    public static Node addOne(Node head) 
    { 
        head =reverse(head);
        Node check = head;
        Node prev=null;
        int carry=1;
        while(check!=null){
            int sum= check.data+carry;
            check.data = sum%10;
            carry=sum/10;
            prev=check;
            check=check.next;
        }
        Node newNode=null;
        if(carry>0){
            newNode = new Node(carry);
            prev.next=newNode;
        }
        
        return reverse(head);
    }
}
