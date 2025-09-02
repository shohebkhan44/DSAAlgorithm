class Node {

    int data;
    Node next;
    Node back;

   Node(int val,Node next,Node back)
    {
              this.data=val;
              this.next=next;
              this.back=back;
    }
    Node(int val){
        this.data=val;
        this.next=null;
        this.back=null;
    }
    
}



public class DoublyLL {

//Convert array to DLL

public static Node ConvertToArray(int[] arr){

    Node head=new Node(arr[0]);
    Node prev=head;
    for(int i=1;i<arr.length;i++)
    {
        Node temp=new Node(arr[i],null,prev);
        prev.next=temp;
        prev=temp;
    }
return head;
}
    
//DeleteHead

public static Node DeleteHead(Node head)
{
   Node temp=head;
   if(head==null ||head.next==null) return null;
       head=head.next;
       temp.next=null;
       head.back=null;

       return head;
}

//deleting tail of a DLL
public static Node DeleteTail(Node head)
{
   Node temp=head;
   if(head==null ||head.next==null) return null;
Node prev=null;
   while(temp.next!=null)
   {
prev=temp;
    temp=temp.next;
   }
       prev.next=null;
       temp.back=null;

       return head;
}

//Delete Kth element in DLL

public static Node DeleteKth(Node head,int k)
{
   Node temp=head;
   int cnt=1;
   if(k==1) {
         head=head.next;
         temp.next=null;
         head.back=null;
   }

Node prev=null;
   while(temp !=null && cnt<k)
   {
    cnt++;
prev=temp;
    temp=temp.next;
   }
       prev.next=temp.next;
       temp.back=null;
       temp.next=null;

       return head;
}


//Insert at Head

public static Node InsertHead(Node head,int val)
{

    if(head==null){
        return new Node(val);
    }
    Node newNode=new Node(val);
    newNode.next=head;
    head.back=newNode;
    return newNode;

}

public static Node InsertTail(Node head,int val)
{
Node tail=head;
Node prev=null;
while(tail.next!=null)
{
prev=tail;
    tail=tail.next;
}
Node newnode=new Node(val,null,tail);
tail.next=newnode;
return head;
}

public static Node ReverseDLL(Node head){

Node current=head;
Node temp=null;
    while (current!=null) {
        
        temp=current.back;
        current.back=current.next;
        current.next=temp;


        current=current.back;
    }

     // After the loop, temp is at the new head's previous node
        if (temp != null) {
            head = temp.back;
        }
    return head;
}
public static void main(String[] args) {
    int arr[]={1,2,3,4,5,6,7};
    Node head=ConvertToArray(arr);
    // head=DeleteHead(head);
   // head=DeleteTail(head);
   //head=DeleteKth(head, 3);
   head=InsertHead(head,7878);
   head=InsertTail(head, 56);
   head=ReverseDLL(head);
   Node temp=head;
    while(temp!=null)
    {
        System.out.print(temp.data+ " ");
        temp=temp.next;
    }
         


}


}
