
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

    //iterative approach
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

    //Recursive Approach

    public static Node RecursiveReverse(Node head)
    {

      while (head==null || head.next==null) {
        
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

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 78, 7 };
      //  Node Node1 = new Node(arr[2], null);
        //System.out.println(Node1.data);
        Node head = ConArrToLL(arr);
         //head=reverseList(head);
         //head=RecursiveReverse(head)
        Node temp=head;
    while(temp!=null)
    {
        System.out.print(temp.data+ " ");
        temp=temp.next;
    }

    }
}
