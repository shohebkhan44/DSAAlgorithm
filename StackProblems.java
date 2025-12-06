import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StackProblems {
    

public static Boolean BalancedParanthesis(String s) {
    Stack<Character> st = new Stack<>();
    char[] str = s.toCharArray();

    for (int i = 0; i < str.length; i++) {/////////////////////

        // If opening bracket → push to stack
        if (str[i] == '(' || str[i] == '[' || str[i] == '{') {
            st.push(str[i]);
        } else {

            // If closing bracket but stack is empty → unbalanced
            if (st.empty()) {
                return false;
            }

            char top = st.peek();

            // If matching pair → pop
            if ((str[i] == ')' && top == '(') ||
                (str[i] == ']' && top == '[') ||
                (str[i] == '}' && top == '{')) 
            {
                st.pop();
            } 
            else {
                // Wrong closing bracket → unbalanced
                return false;   
            }
        }
    }

    // Balanced only if no unmatched opening brackets remain
    return st.empty();
}

//Infix to postfix conversion

public static String InfixToPostfix(String infix) {
    Stack<Character> stack = new Stack<>();
    StringBuilder postfix = new StringBuilder();
    for (char c : infix.toCharArray()) {
        if (Character.isLetterOrDigit(c)) {
            postfix.append(c); // Add operands directly to output
        }
        else if (c == '(') {
            stack.push(c); // Push '(' onto stack
        }
        else if (c == ')') {
            while (!stack.isEmpty() && stack.peek() != '(') {
                postfix.append(stack.pop()); // Pop until '('
            }
            stack.pop(); // Pop the '('
        }
        else { // Operator case
            while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                postfix.append(stack.pop()); // Pop operators with higher or equal precedence
            }
            stack.push(c); // Push current operator onto stack
        
    }
}
   while (!stack.isEmpty()) {
        postfix.append(stack.pop()); // Pop all remaining operators
    }
    return postfix.toString();
}




//infix to prefix conversion
  // MAIN function to convert infix to prefix
    public static String infixToPrefix(String exp) {

        // Step 1: Reverse the infix
        StringBuilder reversed = new StringBuilder(exp).reverse();

        // Swap '(' and ')'
        for (int i = 0; i < reversed.length(); i++) {
            if (reversed.charAt(i) == '(') {
                reversed.setCharAt(i, ')');
            } else if (reversed.charAt(i) == ')') {
                reversed.setCharAt(i, '(');
            }
        }

        // Step 2: Convert reversed infix to postfix
        String postfix = InfixToPostfix(reversed.toString());

        // Step 3: Reverse postfix to get prefix
        String prefix = new StringBuilder(postfix).reverse().toString();

        return prefix;
    }

private static int precedence(char operator) {
    switch (operator) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
        default:
            return -1;
    }
}

//next greater element

public static int[] nextGreaterElement(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && stack.peek() <= nums[i]) {
            //if current element is greater than or equal to top of stack,
            //  pop the stack
            stack.pop();
        }
        //if stack is empty, no greater element to the right
        // else, the top of the stack is the next greater element
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(nums[i]);
    }
    return result;
}

//previous smaller element
public static int[] previousSmallerElement(int[] nums) {
    int n = nums.length;    
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && stack.peek() >= nums[i]) {
            stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(nums[i]);
    }
    return result;
}
//trapping rain water
public static int trappingRainWater(int[] height) {

    // Implementation goes here
    int Rmax=0;
    int Lmax=0;
    int totalwater=0;
    int left=0;
    int right=height.length-1;

    while (left<right) {
//explaining each step
// Compare heights at left and right pointers
// Move the pointer with the smaller height
// Update Lmax or Rmax accordingly
        if (height[left]<=height[right]) {
            // Move left pointer
            if (height[left]>=Lmax) {// Update Lmax if current height is greater
        
                Lmax=height[left];
                // No water trapped at this position
            } else {
                // Water trapped is difference between Lmax and current height
                // Add trapped water to total
                totalwater+=Lmax-height[left];
            }
            // Move left pointer to the right
            left++;
        } else {
            // Move right pointer
            if (height[right]>=Rmax) {
                // Update Rmax if current height is greater
                Rmax=height[right];
            } else {
                // Water trapped is difference between Rmax and current height
                // Add trapped water to total
                totalwater+=Rmax-height[right];
            }
            // Move right pointer to the left
            right--;
        }
        
    }
    return totalwater;

}

//sum of subarray minimums
public static int sumOfSubarrayMinimums(int[] arr) {
    int n = arr.length;
    // Array to store distances to next smaller elements
    int[] left = new int[n];
    // Array to store distances to previous smaller elements
    int[] right = new int[n];
  //adding comments for clarity

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
        // Calculate left distances
        while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
            stack.pop();
            // Pop elements greater than current element
            // to find the previous smaller element
            // and calculate the distance
            // for subarray minimums
            // This helps in determining how many subarrays
            // can have arr[i] as their minimum
        }
        left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
        // If stack is empty, all previous elements are greater
        // Otherwise, calculate distance to previous smaller element
        // This distance contributes to the count of subarrays
        // where arr[i] is the minimum
        // Push current index onto stack
        stack.push(i);
    }
    // Clear stack for right distance calculation
    stack.clear();
    for (int i = n - 1; i >= 0; i--) {  
        // Calculate right distances
        // Iterate from right to left
        // to find the next smaller element
        // and calculate the distance
        // for subarray minimums
        // This helps in determining how many subarrays
        // can have arr[i] as their minimum
        while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
            stack.pop();
        }
        right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
        // Calculate right distances
        stack.push(i);
    }
    long result = 0;
    // Calculate final result using left and right distances
    int mod = 1_000_000_007;
    for (int i = 0; i < n; i++) {
        // Each element's contribution to the sum of subarray minimums
        // is its value multiplied by the number of subarrays
        // in which it is the minimum
        result = (result + (long) arr[i] * left[i] * right[i]) % mod;
        //why divide by mod?
        // To prevent integer overflow and keep the result within the range of int
        //example: if result exceeds 1_000_000_007, taking modulo ensures
        // that we get a manageable number that fits within the integer limits
        //does not affect the correctness of the final result
        // since we are only interested in the result modulo 1_000_000_007
        //
    }
    return (int) result;
}

//collision of asteroids
//to be implemented 

public static void  asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for (int asteroid : asteroids) {    
        if (asteroid > 0) {
            //commeting each line for clarity
            // If asteroid is moving right, push onto stack
            // Right-moving asteroids are simply added to the stack
            stack.push(asteroid);
        } 
        else {
            // Handle collisions with left-moving asteroid
            // While there are right-moving asteroids on the stack
            // and the top of the stack is smaller than the left-moving asteroid
            // Pop the smaller right-moving asteroids
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < 0) {
                // If stack is empty or top is left-moving, push the left-moving asteroid
                stack.push(asteroid);
                // Left-moving asteroid survives as there are no collisions
            } else if (stack.peek() == -asteroid) {
                // If top of stack is equal in size but opposite direction, both explode
                stack.pop();
            }
        }
    }
    // Convert stack to array for result
    int[] result = new int[stack.size()];   
    for (int i = result.length - 1; i >= 0; i--) {
        result[i] = stack.pop();
    }
    // You might want to return or print the result array here
    // For example, to print the result:
    for (int val : result) {
        System.out.print(val + " ");
    }
    System.out.println();
}


//remove k digits
//to be implemented

public static String removeKdigits(String num, int k) {
    Stack<Character> stack = new Stack<>(); 
    for (char digit : num.toCharArray()) {
        while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
            stack.pop();
            k--;
        }
        stack.push(digit);
    }
    while (k > 0) {
        stack.pop();
        k--;
    }
    StringBuilder result = new StringBuilder();
    while (!stack.isEmpty()) {
        result.append(stack.pop());
    }   
    result.reverse();
    // Remove leading zeros
    while (result.length() > 1 && result.charAt(0) == '0') {
        result.deleteCharAt(0);
    }
    return result.toString();
}
//stockspan brute force
public static int[] stockSpanBruteForce(int[] prices) {
    int n = prices.length;  
    int[] span = new int[n];  
    for (int i = 0; i < n; i++) {
        span[i] = 1;  
        for (int j = i - 1; j >= 0 && prices[j] <= prices[i]; j--) {
            span[i]++;  
        }
    }
    return span;
}
//using stack
public static int[] stockSpanUsingStack(int[] prices) { 
    int n = prices.length;  
    int[] span = new int[n];    

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
            stack.pop();
        }
        span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
        stack.push(i);
    }
    return span;
}
//sliding window maximum
//to be implemented
public static int[] slidingWindowMaximum(int[] nums, int k) {
    int n = nums.length;    
    // Edge cases
    //this handles scenarios where the input array is empty or the window size is 1
    // If either condition is true, we can directly return the appropriate result
    if (n * k == 0) return new int[0];
    if (k == 1) return nums;
    int[] result = new int[n - k + 1];
    // Deque to store indices of useful elements in current window
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < n; i++) {
        // Remove indices of elements not in the current window
        if (!deque.isEmpty() && deque.peek() < i - k + 1) {
            // Remove the index at the front if it's out of the window
            deque.poll();
        }
        // Remove indices of elements smaller than the current element
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
            // Remove from back while current element is greater
            deque.pollLast();
        }
        // Add current element's index to the deque
        deque.offer(i);
        // The front of the deque is the largest element for the current window
        if (i >= k - 1) {
            result[i - k + 1] = nums[deque.peek()];
        }
    }
    return result;
}

//Celebrity Problem
//to be implemented
public static int findCelebrity(int[][] matrix) {
    int n = matrix.length;
    Stack<Integer> stack = new Stack<>();
    //declaration of stack to hold potential celebrities
    for (int i = 0; i < n; i++) {
        // Push all people onto the stack
        stack.push(i);
    }
    while (stack.size() > 1) {
        // While more than one person remains
        // Pop two people from the stack
        int a = stack.pop();
        int b = stack.pop();
        // Determine who knows whom
        if (matrix[a][b] == 1) {
            // If a knows b, then a cannot be the celebrity
            stack.push(b);
        } else {
            // If a does not know b, then b cannot be the celebrity
            stack.push(a);
        }
    }
    int candidate = stack.pop();
    // Verify the candidate
    // Check if the candidate knows anyone else or if anyone doesn't know the candidate
    for (int i = 0; i < n; i++) {
        if (i != candidate && (matrix[candidate][i] == 1 || matrix[i][candidate] == 0)) {
            // If candidate knows someone or someone doesn't know candidate
            // Not a celebrity
        
            return -1;
        }
    }
    return candidate;
}

    //celebrity problem using two pointer

    public static int findCelebrityTwoPointer(int[][] matrix) {
        int n = matrix.length;
        int a = 0;
        int b = n - 1;
        while (a < b) {
            if (matrix[a][b] == 1) {
                // a knows b, so a cannot be celebrity
                a++;
            } else {
                // a does not know b, so b cannot be celebrity
                b--;
            }
        }
        int candidate = a;
        // Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (matrix[candidate][i] == 1 || matrix[i][candidate] == 0)) {
                return -1; // Not a celebrity
            }
        }
        return candidate;
}


    public static void main(String[] args) {
        String infix="a+b*(c^d-e)^(f+g*h)-i";
          System.out.println(BalancedParanthesis("()"));          // true
    // System.out.println(BalancedParanthesis("([]{})"));
    // System.out.println(BalancedParanthesis("([)]"));        // false
    // System.out.println(BalancedParanthesis("(]")); 
    // System.out.println(InfixToPostfix("a+b*(c^d-e)^(f+g*h)-i")); // abcd^e-fgh*+^*+i- 
     

    //  System.out.println("Infix  : " + infix);
    //     System.out.println("Prefix : " + infixToPrefix(infix));
int[] result = nextGreaterElement(new int[]{4,5,2,10,8});
for (int val : result) {
    System.out.print(val + " ");
}
System.out.println();
int[] result2 = previousSmallerElement(new int[]{5,3,2,1,10,11,5,6,3});
for (int val : result2) {
    System.out.print(val + " ");
}
System.out.println();
int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
System.out.println(trappingRainWater(height)); //6
int[] arr={3,1,2,4};
//for asteroid collision
asteroidCollision(new int[]{4,3,-1,2,-3});

    }
}
