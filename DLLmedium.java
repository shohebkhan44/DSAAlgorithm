import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

class Node {

    int data;
    Node next;
    Node back;

    Node(int val, Node next, Node back) {
        this.data = val;
        this.next = next;
        this.back = back;
    }

    Node(int val) {
        this.data = val;
        this.next = null;
        this.back = null;
    }

}

public class DLLmedium {

    public static Node ConvertToDLL(int[] arr) 
    {

        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) 
        {

            Node temp=new Node(arr[i],null,prev);
            prev.next=temp;
            prev =temp;
        }

        return head;

    }

    // Delete the Occurences of given key

   public static Node DeleteOccurrences(Node head, int key) {
    Node temp = head;

    while (temp != null) {
        if (temp.data == key) {
            Node nextNode = temp.next;
            Node prevNode = temp.back;

            // If deleting the head node
            if (prevNode == null) {
                head = nextNode;
                if (head != null) {
                    head.back = null;
                }
            } else {
                prevNode.next = nextNode;
                if (nextNode != null) {
                    nextNode.back = prevNode;
                }
            }

            // Disconnect the current node
            temp.next = null;
            temp.back = null;

            // Move to the next node
            temp = nextNode;
        } else {
            temp = temp.next;
        }
    }

    return head;
}


//Helper function fr below code

public static Node getTail(Node head)
{

    Node temp=head;
    while (temp!=null && temp.next!=null ) {
        temp=temp.next;
    }
    return temp;

}
//Find the pairs for the given sum in a sorted DLL

public static List<List<Integer>> Findpairs(Node head, int sum) {
    List<List<Integer>> listOfLists = new ArrayList<>();

    Node left = head;
    Node right = getTail(head); // Assumes you have this method defined

    while (left != null && right != null && left.data < right.data) {
        int currentSum = left.data + right.data;

        if (currentSum == sum) {
            // Create a new list with the pair and add it to the main list
            List<Integer> pair = new ArrayList<>();
            pair.add(left.data);
            pair.add(right.data);
            listOfLists.add(pair);

            left = left.next;
            right = right.back;
        } else if (currentSum > sum) {
            right = right.back;
        } else {
            left = left.next;
        }
    }

    return listOfLists;
}

    public static void main(String[] args) {


        int[] arr={1,2,3,4,5,6,7,8,9,12};
        int targetSum=8;
          Node head=ConvertToDLL(arr);
        // head=DeleteOccurrences(head,4);
List<List<Integer>> result=Findpairs(head, targetSum);
         Node temp=head;
  System.out.println("Pairs with sum " + targetSum + ":");
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }
         while (temp!=null) {
            
            System.out.print
            (temp.data+"->" +" ");
            temp=temp.next;
         }
    }

}
