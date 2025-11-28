import java.util.Stack;

public class StacksAndQueues {
    
    /*
     Basic definitions:

     - Stack (LIFO - Last In, First Out):
        Elements are added and removed from the same end.
        Main operations:
          push(item)   : add an element to the top
          pop()        : remove and return the top element
          peek()/top() : return the top element without removing it
        Typical uses: function call stacks, undo mechanisms, expression evaluation.

     - Queue (FIFO - First In, First Out):
        Elements are added at the rear and removed from the front.
        Main operations:
          enqueue(item) : add an element to the rear
          dequeue()     : remove and return the front element
          peek()/front(): return the front element without removing it
        Typical uses: task scheduling, breadth-first search, buffering.
*/
public static void main(String[] args) {
     Stack<Integer> stackS = new Stack<>();
     stackS.push(1); // Push 1 onto the stack
     stackS.push(2);
     stackS.push(3);
        stackS.push(4);
     // Push 2 onto the stack    
     int topElement = stackS.pop(); // Pops 2 from the stack
System.out.println("Top element after pushes: " + stackS.peek()); // Outputs: Top element after pushes: 1



      System.out.println("Popped element: " + topElement); // Outputs: Popped element: 2
}
}

