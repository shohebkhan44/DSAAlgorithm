
class Node {

    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}

public class LinkedLiastMedium {

    // Implementing link list

    private static Node ConArrToLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;

        }
        return head;
    }

    // iterative approach
    public static Node reverseList(Node head) {
        Node temp = head;
        Node prev = null;
        Node nxt = null;
        while (temp != null) {
            nxt = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nxt;
        }
        return prev;
    }

    // Recursive Approach

    public static Node RecursiveReverse(Node head) {

        while (head == null || head.next == null) {

            return head;
        }

        // Recursively reverse the rest of the list
        Node newHead = RecursiveReverse(head.next);

        // Make the next node point back to current node
        head.next.next = head;

        // Set current node's next to null (becomes the tail)
        head.next = null;

        return newHead;

    }

    public static Boolean DetectLoop(Node head) {

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;

        }
        return false;

    }

    // find the starting node of the Loop

    public static Node StartingNode(Node head)

    {

        Node slow = head;
        Node fast = head;

        while (fast != null || fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {

                    slow = slow.next;
                    fast=fast.next;
                }
                return fast;

            }

        }
        return null;

    }


    //Length of the Loop

       public static int LengthofLoop(Node head)
    {
        Node slow = head;
        Node fast = head;
int count=0;
        while (fast != null || fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {

                    slow = slow.next;
                    count++;
                }
                return count;

            }

        }
        return 0;

    }

//Checking if link list is palindrome

public static Boolean IsLLpalindrome(Node head)
{

    Node temp=head;
    Node slow=head;
    Node fast=head;
    while (fast.next!=null && fast.next.next!=null) {
        
 slow=slow.next;
 fast=fast.next;
    }
    Node newhead=reverseList(slow.next);
    Node first=head;
    Node second=newhead;

    while(second!=null)
    {
           if(first.data!=second.data)
           {
            reverseList(newhead);
            return false;
           }
           first=first.next;
           second=second.next;

    }
    reverseList(newhead);
    return true;
}

//Delete Nth node from back


public static Node DeleteNthBack(Node head,int n)
{
  Node fast=head;
  Node slow=head;

  for(int i=0;i<n;i++){
    fast=fast.next;
  }

  if(fast==null) return head.next;//edge case

  while (fast.next!=null) {
    slow=slow.next;
    fast=fast.next;
  }
  slow.next=slow.next.next;
  return head;


}

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 78, 7 };
        // Node Node1 = new Node(arr[2], null);a = Node("A")
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(2);
        Node e = new Node(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        //e.next=b;

        // System.out.println(Node1.data);
        Node head = ConArrToLL(arr);
        // head=reverseList(head);
        // head=RecursiveReverse(head)
        // System.out.println(DetectLoop(a));
        // Node start=StartingNode(a);
        // System.out.println("staring node is"+start.data);
        // System.out.println("The length of loop is"+LengthofLoop(a));
        head=DeleteNthBack(head,3);
        Node temp = head;
       // Boolean flag=IsLLpalindrome(a);
       // System.out.println("the List"+ " "+flag);
        while (temp != null) {
            System.out.print(temp.data + "->"+" ");
            temp = temp.next;
        }

    }
}
