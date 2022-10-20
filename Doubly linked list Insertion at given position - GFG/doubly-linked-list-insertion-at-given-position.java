//{ Driver Code Starts
import java.util.*;

class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}

class DLinkedList
{
	
	Node newNode(Node head, int data)
	{
		Node n = new Node(data);
		if(head == null)
		{
		    head = n;
		    return head;
		}
		head.next = n;
		n.prev = head;
		head = n;
		return head;
	}
	
	
	void printList(Node node)
	{
		Node temp = node;
		while(temp.next != null)
		{
			temp = temp.next;
		}
		
		while(temp.prev != null)
		{
			temp = temp.prev;
		}
		
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		DLinkedList DLL = new DLinkedList();
		int t = sc.nextInt();
		
		while(t>0)
		{
			Node temp;
			Node head = null;
			Node root = null;
			int n = sc.nextInt();
			for(int i=0;i<n;i++)
			{
				int x = sc.nextInt();
				head = DLL.newNode(head,x);
			    if(root == null)    root = head;
			}
			head = root;
			int pos = sc.nextInt();
			int data = sc.nextInt();
			
		    GfG g = new GfG();
		    g.addNode(head,pos,data);
			
			DLL.printList(head);
			while(head.next != null)
			{
				temp = head;
				head = head.next;
			}
		    t--;
		}
	}
}
// } Driver Code Ends

// https://practice.geeksforgeeks.org/problems/insert-a-node-in-doubly-linked-list/1
/* Structure of Doubly Linked List
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}*/

class GfG
{
    void addNode(Node head_ref, int pos, int data)
	{
	    Node newNode = new Node(data);
        // if(pos==-1){
        //     newNode.next=head_ref;
        //     head_ref.prev=newNode;
        //     head_ref=newNode;
        // }		
        // else{
            Node check = head_ref;
            int i=0;
            while(i!=pos){
                check=check.next;
                i++;
            }
            if(check.next==null){
                check.next=newNode;
                newNode.prev=check;
            }
            else{
                newNode.next=check.next;
                check.next.prev=newNode;
                newNode.prev=check;
                check.next=newNode;
            }
        // }
	}
}









