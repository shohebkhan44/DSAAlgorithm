import java.util.Stack;

class MinStack {

    private Stack<Integer> mainStack = new Stack<>();
    
int min=-999999999;
    // Push element x onto stack
    public void push(int x) {


        if (mainStack.isEmpty()){

            mainStack.push(x);
            min=x;
        }
        else if (x < min) {
          
                mainStack.push(2 * x - min); // Store a transformed value
                min = x;
            }
       else{
         mainStack.push(x);
       }
      
    }

     

    // Remove the element on top of the stack
    public void pop() {
        if (mainStack.isEmpty()) return;

        int removed = mainStack.pop();

        // If removed element is smallest, pop from minStack too
        if (removed < min) {
            min = 2 * min - removed; // Restore the previous minimum
        }
    }

    // Get the top element
    public int top() {
        if (mainStack.isEmpty()) return -1;
        
        int top = mainStack.peek();
        // If top is transformed, retrieve the original value   
        return top < min ? min : top; // Return the original value or the current minimum
    }

    // Get the minimum element in constant time
    public int getMin() {
        if (mainStack.isEmpty()) return -1;
        return min; // Return the current minimum
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(5);
        System.out.println("Minimum: " + minStack.getMin()); // Returns 3
        minStack.push(2);
        minStack.push(1);
        System.out.println("Minimum: " + minStack.getMin()); // Returns 1
        minStack.pop();
        System.out.println("Top: " + minStack.top()); // Returns 2
        System.out.println("Minimum: " + minStack.getMin()); // Returns 2
    }
}
