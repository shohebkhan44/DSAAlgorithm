import java.util.Stack;

public class StackProblems {
    

public static Boolean BalancedParanthesis(String s) {
    Stack<Character> st = new Stack<>();
    char[] str = s.toCharArray();

    for (int i = 0; i < str.length; i++) {

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
        } else if (c == '(') {
            stack.push(c); // Push '(' onto stack
        } else if (c == ')') {
            while (!stack.isEmpty() && stack.peek() != '(') {
                postfix.append(stack.pop()); // Pop until '('
            }
            stack.pop(); // Pop the '('
        } else { // Operator case
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
            stack.pop();
        }
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

        if (height[left]<=height[right]) {
            if (height[left]>=Lmax) {
                Lmax=height[left];
            } else {
                totalwater+=Lmax-height[left];
            }
            left++;
        } else {
            if (height[right]>=Rmax) {
                Rmax=height[right];
            } else {
                totalwater+=Rmax-height[right];
            }
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
    }
    return (int) result;
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
    }
}
