class Node {

    int data;
    Node next;

    // contructor
    Node(int data, Node next) {
        this.data = data;
        this.next = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListIntro {

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

    public static boolean Chkifpresent(Node head, int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }

    }

    public static Node deletehead(Node head) {

        if (head == null)
            return head;
        head = head.next;
        return head;
    }

    public static Node deleteTail(Node head) {

        Node temp = head;
        if (head == null || head.next == null)
            return null;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node DeleteKth(Node head, int k) {
        int cnt = 0;
        if (head == null)
            return head;
        if (k == 1) {
            head = head.next;
        } else {
            Node temp = head;
            while (temp != null) {
                cnt++;
                Node prev = temp;
                if (cnt == k) {
                    prev.next = prev.next.next;
                    break;
                }
                temp = temp.next;

            }
        }
        return head;

    }

    public static Node DeleteVal(Node head, int val) {

        Node prev = null;
        if (head == null)
            return head;

        else {
            Node temp = head;
            while (temp != null) {

                if (temp.data == val) {
                    prev.next = prev.next.next;
                    break;
                }
                prev = temp;
                temp = temp.next;

            }
        }
        return head;
    }

    public static Node InsertNodeAtHead(Node head, int ele) {
        return new Node(ele,head);
        // if (head == null) {
        //      temp.data=ele;
        //      temp.next=null;
        //      return temp;
        // }
        // temp.next = head;
        // temp.data = ele;
        // return temp;

        //instead of all above code
      
    }

     public static Node InsertNodeAtLast(Node head, int ele) {
     
      Node add=new Node(ele);
        Node temp=head;
      
            while (temp.next != null) {
            temp = temp.next;
        }
        temp.next=add;
        return head;
        }

    public static Node InsertAddKthpos(Node head,int ele,int pos)
    {

             int cnt=1;
             Node temp=head;
             Node newNode=new Node(ele);
             Node prev=null;
             while (temp!=null && cnt<pos-1) {
                 temp=temp.next;
                cnt++;
                    
                }
                newNode.next=temp.next;
                temp.next=newNode;
             return head;
    }

       public static Node InsertB4Val(Node head,int val,int AddEle)
    {
             Node temp=head;
             Node newNode=new Node(AddEle);
             Node prev=null;
             while (temp!=null && temp.data!=val) {
                prev=temp;
                 temp=temp.next;
                }
                prev.next=newNode;
                newNode.next=temp;
             return head;
    }

    public static void main(String[] args) {

        int[] arr = { 1,2, 3, 4, 5, 6,78, 7 };
        Node Node1 = new Node(arr[2], null);
        System.out.println(Node1.data);
        Node head = ConArrToLL(arr);
        // Node temp=head;
        // int lenghtLL=0;
        // while(temp!=null)
        // {
        // System.out.print(temp.data);
        // lenghtLL++;
        // temp=temp.next;
        // }
        // System.out.println(lenghtLL);
        // System.out.println(Chkifpresent(head, 5));
        // head=deletehead(head);
        // head=deleteTail(head);
        // head=DeleteKth(head,3);
       // head = DeleteVal(head, 4);
      // head=InsertNodeAtHead(head, 199); need to chk
      //  head=InsertNodeAtLast(head,23);
      //head=InsertAddKthpos(head, 956, 3);
      head=InsertB4Val(head, 3, 456);
        printLL(head);
    }
}
