package TreesDSA;
 class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
}
public class TreesIntroduction {
    // A tree is a non-linear data structure that consists of nodes connected by edges.
    // It is used to represent hierarchical relationships between elements.
    // Key characteristics of trees:
    // 1. Root Node: The topmost node in a tree.
    // 2. Parent and Child Nodes: Each node (except the root) has a parent node and can have multiple child nodes.
    // 3. Leaf Nodes: Nodes that do not have any children.
    // 4. Subtree: A tree formed by a node and its descendants.
    // 5. Depth and Height: Depth is the level of a node in the tree, while height is the longest path from the root to a leaf.
    // Common types of trees:
    // 1. Binary Tree: Each node has at most two children.
    // 2. Binary Search Tree (BST): A binary tree where the left child is less than the parent node, and the right child is greater.
    // 3. AVL Tree: A self-balancing binary search tree.
    // 4. Red-Black Tree: A self-balancing binary search tree with additional properties to ensure balance.
    // 5. N-ary Tree: A tree where nodes can have more than two children.

// Tree Traversal Methods:
// 1. Preorder Traversal: Visit the root node first, then recursively traverse the
// left subtree, followed by the right subtree.
// 2. Inorder Traversal: Recursively traverse the left subtree, visit the root node,
// and then recursively traverse the right subtree.
// 3. Postorder Traversal: Recursively traverse the left subtree, then the right subtree,
// and finally visit the root node.

public static Node PreorderTraversal(Node node) {
    if (node == null) {
        return null;
    }
    System.out.print(node.value + " ");
    PreorderTraversal(node.left);   

    PreorderTraversal(node.right);
    return node;
}

public static Node InorderTraversal(Node node) {

if(node ==null) {
    return null;
}

    InorderTraversal(node.left);
    System.out.print(node.value + " ");
    InorderTraversal(node.right);
return node;
}

public static Node PostorderTraversal(Node node) {
    if(node == null) {
        return null;
    }
    PostorderTraversal(node.left);
    PostorderTraversal(node.right); 
    System.out.print(node.value + " ");
    return node;
}

//level order traversal

public static Node LevelOrderTraversal(Node node) {
    if (node == null) {
        return null;
    }
    java.util.Queue<Node> queue = new java.util.LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
        // here we are using poll() method to retrieve and remove the head of the queue
        Node current = queue.poll();
        // Process the current node
        System.out.print(current.value + " ");
        if (current.left != null) {
            queue.add(current.left);
        }
        if (current.right != null) {
            queue.add(current.right);
        }
    }
    return node;
}
//iterative preorder traversal
public static void IterativePreorderTraversal(Node root) {
    if (root == null) {
        return;
    }
    java.util.Stack<Node> stack = new java.util.Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        Node current = stack.pop();
        System.out.print(current.value + " ");
        if (current.right != null) {
            stack.push(current.right);
        }
        //why first left then right? because stack is LIFO, so we push right 
        //  first to ensure left is processed first    
        if (current.left != null) {
            stack.push(current.left);
        }
    }
}
//iterative inorder traversal

public static void InorderIterativeTraversal(Node root) {
    if (root == null) {
        return;
    }   
    java.util.Stack<Node> stack = new java.util.Stack<>();
    Node current = root;
    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        System.out.print(current.value + " ");
        current = current.right;
    }
}   
//postorder iterative traversal
public static void PostorderIterativeTraversal(Node root) {
    if (root == null) {
        return;
    }
    java.util.Stack<Node> stack1 = new java.util.Stack<>();
    java.util.Stack<Node> stack2 = new java.util.Stack<>();
    stack1.push(root);
    while (!stack1.isEmpty()) {
        //write comments explaining the logic
        // Pop a node from stack1 and push it onto stack2
        // Push the left and right children of the popped node onto stack1
        // This way, stack2 will have the nodes in postorder sequence
        // Finally, pop all nodes from stack2 to get the postorder traversal
        Node current = stack1.pop();
        stack2.push(current);
        if (current.left != null) {
            stack1.push(current.left);
        }
        if (current.right != null) {
            stack1.push(current.right);
        }
    }
    while (!stack2.isEmpty()) {
        Node current = stack2.pop();
        System.out.print(current.value + " ");
    }
}
//using single stack for postorder iterative traversal
public static void PostorderIterativeSingleStack(Node root) {
    if (root == null) {
        return;
    }
    java.util.Stack<Node> stack = new java.util.Stack<>();
    Node current = root;
    Node lastVisited = null;
    while (current != null || !stack.isEmpty()) {
        // Traverse to the leftmost node
        while (current != null) {
            // Push the current node onto the stack
            stack.push(current);
            current = current.left;
            // Move to the left child
        }
        Node peekNode = stack.peek();
        // If the right child exists and hasn't been visited yet, move to the right child
        if (peekNode.right != null && lastVisited != peekNode.right) {
            // Move to the right child
            current = peekNode.right;
            // Continue the loop
        } else {
            // If the right child doesn't exist or has already been visited, visit the node
            // Print the value of the node
            System.out.print(peekNode.value + " ");
            lastVisited = stack.pop();
        }
    }
}

//maximum depth od BT
public static int MaxmimumDepth(Node root){

    if(root==null){
        return 0;
    }
    int lh= MaxmimumDepth(root.left);
    int rh=MaxmimumDepth(root.right);

    return 1+Math.max(lh,rh);

}
//balanced BT
public static boolean isBalanced(Node root){
    if(root==null){
        return true;
    }
    int lh=MaxmimumDepth(root.left);
    int rh=MaxmimumDepth(root.right);
    if(Math.abs(lh-rh)<=1 && isBalanced(root.left) && isBalanced(root.right)){
        return true;
    }
    return false;
}
    
    public static void main(String[] args) {
        System.out.println("Thi class provides an introduction to Trees \n in Data Structures and Algorithms.");

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left= new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);    
        root.right.right.right = new Node(10);
        root.right.right.left = new Node(9);
        System.out.println("Root Node: " + root.value);
        System.out.println("Left Child: " + root.left.value);
        System.out.println("Right Child: " + root.right.value);
        //print the binary tree structure in tree format console
        System.out.println("        " + root.value);
        System.out.println("      /   \\");
        System.out.println("     " + root.left.value + "     " + root.right.value);
        System.out.println("    / \\   / \\");      
        System.out.println("   " + root.left.left.value + "  " + root.left.right.value + " " + root.right.left.value + "  " + root.right.right.value);
        System.out.println("      /       / \\");
        System.out.println("     " + root.left.right.left.value + "      " + root.right.right.left.value + "  " + root.right.right.right.value);
      System.out.println("Predorder" + PreorderTraversal(root));
       System.out.println();
      System.out.println("Inorder" + InorderTraversal(root));
       System.out.println();
       System.out.println("Postorder" + PostorderTraversal(root));
       System.out.println();
       System.out.println("Level Order" + LevelOrderTraversal(root));
       System.out.println();
       System.out.println("Iterative Preorder Traversal: ");
       IterativePreorderTraversal(root);
       System.out.println();
       //time complexity of tree traversals is O(n) where n is number of nodes in the tree
       //space complexity is O(h) where h is height of the tree due to recursive stack space
    }




}
