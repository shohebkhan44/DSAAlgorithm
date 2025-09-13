
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
       Node temp = head;     // Current node we’re visiting
    Node prev = null;     // Previous node (starts as null for the new tail)
    Node nxt = null;      // Next node (used for temporary storage)
    
    while (temp != null) {
        nxt = temp.next;   // Save next node
        temp.next = prev;  // Reverse the link
        prev = temp;       // Move prev forward
        temp = nxt;        // Move temp forward
    }
    
    return prev;           // New head of the reversed list
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

//Delete middle node

public static Node DeleteMiddleNode(Node head)
{

Node slow=head;
Node fast=head;
Node temp=head;

// Edge case: list is empty or has only one node
    if (head == null || head.next == null)
        return null;

  while (fast != null && fast.next != null) {
 temp=slow;
    slow=slow.next;
    fast=fast.next.next;

}
temp.next=temp.next.next;
return head;

}


//frm cht

    // Function to sort the linked list
    public static Node sortList(Node head) {
        // Base case: if list is empty or has one element
        if (head == null || head.next == null)
            return head;

        // Step 1: Split the list into two halves
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;

        // Disconnect the left half from the right half
        middle.next = null;

        // Step 2: Recursively sort both halves
        Node left = sortList(head);
        Node right = sortList(nextOfMiddle);

        // Step 3: Merge the two sorted halves
        Node sortedList = merge(left, right);
        return sortedList;
    }

    // Helper function to get the middle of the linked list
    public static Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slow = head;
        Node fast = head;

        // Move fast by 2 and slow by 1
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper function to merge two sorted linked lists
    public static Node merge(Node left, Node right) {
        // Dummy node to start the merged list
        Node dummy = new Node(0);
        Node tail = dummy;

        // Merge the two lists by comparing their values
        while (left != null && right != null) {
            if (left.data <= right.data) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        // If there are remaining nodes in either list, attach them
        if (left != null) {
            tail.next = left;
        } else if (right != null) {
            tail.next = right;
        }

        // Return the head of the sorted list
        return dummy.next;
    }


//sort 0s ,1s,2s in LL

public static Node SortLinkList(Node head)

{

 Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);

        // Tail pointers for each sub-list
        Node zerotail = zeroDummy, onetail = oneDummy, twotail = twoDummy;
Node temp=head;

while (temp!=null) {
   
    
    if(temp.data==0)
    {

        zerotail.next=temp;
        zerotail=zerotail.next;
    }
     if(temp.data==1)
    {

        onetail.next=temp;
        onetail=onetail.next;
    }
     if(temp.data==2)
    {

        twotail.next=temp;
        twotail=twotail.next;
    }
    temp=temp.next;

}

  // Now connect the three lists together: 0s -> 1s -> 2s
        // Important: Handle if one of the lists is empty
     zerotail.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        onetail.next = twoDummy.next;
        twotail.next = null;

        // Head of the new list
        return zeroDummy.next;
}


//helper function fr below code
public static Node check(Node t1,Node t2)
{

    if(t1==t2){
        return t1;
    }
    t1=t1.next;
    t2=t2.next;
    return null;
}
//Find the Intersection Point


public static Node IntersectionNode(Node head1,Node head2)
{

 Node t1=head1;Node t2=head2;
 int n1=0,n2=0;//Lengths of Lists

 while (t1!=null) {
    
    n1++;
    t1=t1.next;
 }
 while (t2!=null) {
    
    n2++;
    t2=t2.next;
 }
 t1=head1;t2=head2;

 int diff=Math.abs(n2-n1);

    if(n2>n1)
    {
        for(int i=0;i<diff;i++)
        {
            t2=t2.next;
        }
    }
    else
    {
        for(int j=1;j<=diff;j++)
        {
            t1=t1.next;
        }
    }

        // Traverse both lists together until nodes are same or end reached
    while (t1 != null && t2 != null) {
        if (t1 == t2) {
            return t1;  // Intersection found
        }
        t1 = t1.next;
        t2 = t2.next;
    }

   return null;
}

    public static void main(String[] args) {
        int[] arr = { 5,2,1,3,6, 6, 78, 7 };
        int[] ar2=  {0,1,2,1,2,0,0,2,1};
        // Node Node1 = new Node(arr[2], null);a = Node("A")
        Node head1 = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(2);
        Node e = new Node(1);
        head1.next = b;
        b.next = c;
   Node head2 =new Node(11);
        Node Intersection=new Node(24);
 c.next = Intersection;
 head2.next=Intersection;
 Intersection.next=d;
 d.next=e;

        
        //e.next=b;

        // System.out.println(Node1.data);
        //Node head = ConArrToLL(arr);
        Node head = ConArrToLL(ar2);
         head=SortLinkList(head);
        // head=reverseList(head);
        // head=RecursiveReverse(head)
        // System.out.println(DetectLoop(a));
        // Node start=StartingNode(a);
        // System.out.println("staring node is"+start.data);
        // System.out.println("The length of loop is"+LengthofLoop(a));
       // head=DeleteNthBack(head,3);
       //head=DeleteMiddleNode(head);
      // head=SortLinkList(head);
        Node temp = head;
       // Boolean flag=IsLLpalindrome(a);
       // System.out.println("the List"+ " "+flag);

Node result = IntersectionNode(head1, head2);
        if (result != null) {
            System.out.println("Intersection at node with data = " + result.data);
        } else {
            System.out.println("No intersection found.");
        }


        while (temp != null) {
            System.out.print(temp.data + "->"+" ");
            temp = temp.next;
        }

    }
}
