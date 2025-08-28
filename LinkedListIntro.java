 class Node{

        int data;
        Node next;

        //contructor 
        Node(int data,Node next){
             this.data=data;
             this.next=null;
        }

        Node(int data){
    this.data = data;
    this.next = null;
}
    }

   

public class LinkedListIntro {
    
//Implementing link list

 private static Node ConArrToLL(int arr[]){
            Node head=new Node(arr[0]);
              Node mover=head;
              for(int i=1;i<arr.length;i++)
              {
                Node temp=new Node(arr[i]);
                mover.next=temp;
                mover=temp;

              }
              return head;
    }
    public static boolean Chkifpresent(Node head,int val)
    {
        Node temp=head;
             while(temp!=null)
             {
              if(temp.data==val){
                return true;
              }
              temp=temp.next;
             }
             return false;
    }

    public static void printLL(Node head){
        Node temp=head;
  while(temp!=null)
           {
            System.out.print(temp.data);
            temp=temp.next;
           }

    }

    public static Node deletehead(Node head){

    
        if(head==null) return head;
        head=head.next;
        return head;
    }

     public static Node deleteTail(Node head){

    Node temp=head;
        if(head==null || head.next==null) return null;
        while(temp.next.next !=null)
        {
              temp=temp.next;
        }
        temp.next=null;
        return head;
    }

    public static Node DeleteKth(Node head,int k)
    {
int cnt=0;
        if(head==null) return head;
        if(k==1)
        {
            head=head.next;
        }
        else{
            Node temp=head;
            while(temp!=null)
            {
                cnt++;
                Node prev=temp;
                if(cnt==k){
                    prev.next=prev.next.next;
                    break;
                }
                temp=temp.next;
               

            }
        }
        return head;

    }
        public static void main(String[] args) {
        
            int[] arr={1,2,3,4,5,6,7};
            Node Node1=new Node(arr[2], null);
            System.out.println(Node1.data);
           Node head=ConArrToLL(arr);
           Node temp=head;
           int lenghtLL=0;
           while(temp!=null)
           {
            System.out.print(temp.data);
            lenghtLL++;
            temp=temp.next;
           }
            System.out.println(lenghtLL);
            System.out.println(Chkifpresent(head, 5));
             head=deletehead(head);
             head=deleteTail(head);
             head=DeleteKth(head,3);
            printLL(head);
        }
    }

     






