
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



    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 78, 7 };
        // Node Node1 = new Node(arr[2], null);a = Node("A")
        Node a = new Node(12);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next=b;

        // System.out.println(Node1.data);
        Node head = ConArrToLL(arr);
        // head=reverseList(head);
        // head=RecursiveReverse(head)
        System.out.println(DetectLoop(a));
        Node start=StartingNode(a);
        System.out.println("staring node is"+start.data);
        System.out.println("The length of loop is"+LengthofLoop(a));
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }
}
