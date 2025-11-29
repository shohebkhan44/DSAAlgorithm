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

//implement minimum Stack



    public static void main(String[] args) {
        String infix="a+b*(c^d-e)^(f+g*h)-i";
          System.out.println(BalancedParanthesis("()"));          // true
    System.out.println(BalancedParanthesis("([]{})"));
    System.out.println(BalancedParanthesis("([)]"));        // false
    System.out.println(BalancedParanthesis("(]")); 
    System.out.println(InfixToPostfix("a+b*(c^d-e)^(f+g*h)-i")); // abcd^e-fgh*+^*+i- 
     

     System.out.println("Infix  : " + infix);
        System.out.println("Prefix : " + infixToPrefix(infix));


    }
}
