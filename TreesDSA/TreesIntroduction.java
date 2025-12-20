package TreesDSA;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

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
    // A tree is a non-linear data structure that consists of nodes connected by
    // edges.
    // It is used to represent hierarchical relationships between elements.
    // Key characteristics of trees:
    // 1. Root Node: The topmost node in a tree.
    // 2. Parent and Child Nodes: Each node (except the root) has a parent node and
    // can have multiple child nodes.
    // 3. Leaf Nodes: Nodes that do not have any children.
    // 4. Subtree: A tree formed by a node and its descendants.
    // 5. Depth and Height: Depth is the level of a node in the tree, while height
    // is the longest path from the root to a leaf.
    // Common types of trees:
    // 1. Binary Tree: Each node has at most two children.
    // 2. Binary Search Tree (BST): A binary tree where the left child is less than
    // the parent node, and the right child is greater.
    // 3. AVL Tree: A self-balancing binary search tree.
    // 4. Red-Black Tree: A self-balancing binary search tree with additional
    // properties to ensure balance.
    // 5. N-ary Tree: A tree where nodes can have more than two children.

    // Tree Traversal Methods:
    // 1. Preorder Traversal: Visit the root node first, then recursively traverse
    // the
    // left subtree, followed by the right subtree.
    // 2. Inorder Traversal: Recursively traverse the left subtree, visit the root
    // node,
    // and then recursively traverse the right subtree.
    // 3. Postorder Traversal: Recursively traverse the left subtree, then the right
    // subtree,
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

        if (node == null) {
            return null;
        }

        InorderTraversal(node.left);
        System.out.print(node.value + " ");
        InorderTraversal(node.right);
        return node;
    }

    public static Node PostorderTraversal(Node node) {
        if (node == null) {
            return null;
        }
        PostorderTraversal(node.left);
        PostorderTraversal(node.right);
        System.out.print(node.value + " ");
        return node;
    }

    // level order traversal

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
            if (current.right != null) {
                queue.add(current.right);
            }
            if (current.left != null) {
                queue.add(current.left);
            }

        }
        return node;
    }

    // iterative preorder traversal
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
            // why first left then right? because stack is LIFO, so we push right
            // first to ensure left is processed first
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }
    // iterative inorder traversal

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

    // postorder iterative traversal
    public static void PostorderIterativeTraversal(Node root) {
        if (root == null) {
            return;
        }
        java.util.Stack<Node> stack1 = new java.util.Stack<>();
        java.util.Stack<Node> stack2 = new java.util.Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            // write comments explaining the logic
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

    // using single stack for postorder iterative traversal
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
            // If the right child exists and hasn't been visited yet, move to the right
            // child
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

    // maximum depth od BT
    public static int MaxmimumDepth(Node root) {

        if (root == null) {
            return 0;
        }
        int lh = MaxmimumDepth(root.left);
        int rh = MaxmimumDepth(root.right);

        return 1 + Math.max(lh, rh);

    }

    // balanced BT
    public static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        int lh = MaxmimumDepth(root.left);
        int rh = MaxmimumDepth(root.right);
        if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }

    // Diameter of Binary Tree

    // helper function

    public static int Height(Node root, int[] Diameter) {

        if (root == null) {
            return 0;
        }
        int lh = Height(root.left, Diameter);
        int rh = Height(root.right, Diameter);

        Diameter[0] = Math.max(Diameter[0], lh + rh);

        return 1 + Math.max(lh, rh);

    }

    public static int DiameterOfBT(Node root) {

        int[] Diameter = new int[1];
        Height(root, Diameter);
        return Diameter[0];

    }
    // maximum Sum path

    public static int MaximumSumpath(Node root, int[] Diameter) {

        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, MaximumSumpath(root.left, Diameter));
        int rightSum = Math.max(0, MaximumSumpath(root.right, Diameter));

        Diameter[0] = Math.max(Diameter[0], leftSum + rightSum + root.value);

        return root.value + Math.max(leftSum, rightSum);

    }
    // isTree similar

    public static Boolean IsTreeSame(Node p, Node q) {

        // both are null → same tree
        if (p == null && q == null) {
            return true;
        }

        // one is null, the other is not → not same
        if (p == null || q == null) {
            return false;
        }
        return (p.value == q.value && IsTreeSame(p.left, q.left)
                && IsTreeSame(p.right, q.right));

    }

    public static void ZigZagTraversal(Node root) {
        if (root == null)
            return;
        Boolean LeftToRight = true;
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            int[] level = new int[size];
            

            for (int i = 0; i < size; i++) {
               Node current = que.poll();
              int  index = LeftToRight ? i : size - 1 - i;
               level[index]=current.value;

                if(current.left!=null){
                    que.add(current.left);
                }

                 if(current.right!=null){
                    que.add(current.right);
                }

            }
            for (int val : level) {
                System.out.print(" "+val);
            }

            LeftToRight=!LeftToRight;

        }



    }

    //Boundry traversal


    // Function to print boundary traversal
   public static void boundaryTraversal(Node root) {
        if (root == null)
            return;

        // 1. Print root node
        System.out.print(root.value + " ");

        // 2. Print left boundary (excluding leaves)
        printLeftBoundary(root.left);

        // 3. Print all leaf nodes
        printLeaves(root.left);
        printLeaves(root.right);

        // 4. Print right boundary (excluding leaves)
        printRightBoundary(root.right);
    }

    // Function to print left boundary
   public static void printLeftBoundary(Node node) {
        if (node == null)
            return;

        if (node.left != null) {
            System.out.print(node.value + " ");
            printLeftBoundary(node.left);
        } else if (node.right != null) {
            System.out.print(node.value + " ");
            printLeftBoundary(node.right);
        }
        // Do nothing if it's a leaf node
    }

    // Function to print leaf nodes
   public static void printLeaves(Node node) {
        if (node == null)
            return;

        printLeaves(node.left);

        if (node.left == null && node.right == null)
            System.out.print(node.value + " ");

        printLeaves(node.right);
    }

    // Function to print right boundary
   public static void printRightBoundary(Node node) {
        if (node == null)
            return;

        if (node.right != null) {
            printRightBoundary(node.right);
            System.out.print(node.value + " ");
        } else if (node.left != null) {
            printRightBoundary(node.left);
            System.out.print(node.value + " ");
        }
        // Do nothing if it's a leaf node
    }

    public static boolean isMirror(Node left, Node right) {

    // If both nodes are null, they are symmetric
    if (left == null && right == null)
        return true;

    // If one is null and other is not, not symmetric
    if (left == null || right == null)
        return false;

    // Check value and recursive mirror condition
    return (left.value == right.value)
            && isMirror(left.left, right.right)
            && isMirror(left.right, right.left);
}
public static boolean isSymmetric(Node root) {

    // If tree is empty, it is symmetric
    if (root == null)
        return true;

    // Check if left and right subtrees are mirror images
    return isMirror(root.left, root.right);
}

//root to node path

public static boolean printRootToNodePath(Node root, int target) {

    // If tree is empty, path does not exist
    if (root == null)
        return false;

    // Print current node value
    System.out.print(root.value + " ");

    // If current node is target, path is found
    if (root.value == target)
        return true;

    // Check left subtree
    if (printRootToNodePath(root.left, target))
        return true;

    // Check right subtree
    if (printRootToNodePath(root.right, target))
        return true;

    // If not found in both subtrees, remove current node from path
    System.out.print("\b\b"); // removes last printed value (visual purpose)
    return false;
}

//Width of a Binary

  private static int BTWidthWithGaps(Node root) {
    if (root == null)
        return 0;

    Queue<Object[]> que = new LinkedList<>();
    que.add(new Object[]{root, 1L}); // root index = 1
    int maxWidth = 0;

    while (!que.isEmpty()) {
        int size = que.size();

        // First node index at this level
        long first = (long) que.peek()[1];
        long last = 0;

        for (int i = 0; i < size; i++) {
            Object[] current = que.poll();
            Node node = (Node) current[0];
            long index = (long) current[1];

            // Normalize index to avoid large numbers
            long normalizedIndex = index - first;
            last = normalizedIndex;

            // Add children with normalized indices
            if (node.left != null)
                que.add(new Object[]{node.left, 2 * normalizedIndex});
            if (node.right != null)
                que.add(new Object[]{node.right, 2 * normalizedIndex + 1});
        }

        // Width of this level
        maxWidth = Math.max(maxWidth, (int) (last + 1));
    }

    return maxWidth;
}


 //LCA using recursion


    // Function to find LCA of two nodes in a Binary Tree
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {

        // Base case: if tree is empty, return null
        if (root == null) {
            return null;
        }

        // If current node is either p or q, return current node
        if (root == p || root == q) {
            return root;
        }

        // Recursively find LCA in left subtree
        Node left = lowestCommonAncestor(root.left, p, q);

        // Recursively find LCA in right subtree
        Node right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are not null,
        // it means p and q are found in different subtrees
        // so current node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // If only one side is non-null, return that side
        // (it contains both p and q or one of them)
        return (left != null) ? left : right;
    }


//total Number Nodes in A Complete BT




    // Function to count nodes in a complete binary tree
    public int countNodes(Node root) {

        // If tree is empty, return 0
        if (root == null) {
            return 0;
        }

        // Find height of left subtree
        int leftHeight = getLeftHeight(root);

        // Find height of right subtree
        int rightHeight = getRightHeight(root);

        // If left and right heights are same,
        // then this is a perfect binary tree
        if (leftHeight == rightHeight) {
            // Number of nodes in perfect tree = 2^height - 1
            return (int) Math.pow(2, leftHeight) - 1;
        }

        // Otherwise, count nodes recursively
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Function to get height by going left
    private int getLeftHeight(Node node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }

        return height;
    }

    // Function to get height by going right
    private int getRightHeight(Node node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }



    //Count leaf Nodes

    public static int countLeafNodes(Node root){

   if(root==null){
    return 0;
   }
          if(root.left!=null){
           int count;
          }
   return countLeafNodes(root.left) +countLeafNodes(root.right);

    }

    // Main method
   

    
    public static void main(String[] args) {
        System.out.println("Thi class provides an introduction to Trees \n in Data Structures and Algorithms.");

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(10);
        root.right.right.left = new Node(9);
        System.out.println("Root Node: " + root.value);
        System.out.println("Left Child: " + root.left.value);
        System.out.println("Right Child: " + root.right.value);
        // print the binary tree structure in tree format console
        System.out.println("        " + root.value);
        System.out.println("      /   \\");
        System.out.println("     " + root.left.value + "     " + root.right.value);
        System.out.println("    / \\   / \\");
        System.out.println("   " + root.left.left.value + "  " + root.left.right.value + " " + root.right.left.value
                + "  " + root.right.right.value);
        System.out.println("      /       / \\");
        System.out.println("     " + root.left.right.left.value + "      " + root.right.right.left.value + "  "
                + root.right.right.right.value);
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
        System.out.println("the diameter of the tree is" + DiameterOfBT(root));
        System.out.println();
        int[] Diameter = new int[1];
        System.out.println("the maximum sum is" + MaximumSumpath(root, Diameter));
        // time complexity of tree traversals is O(n) where n is number of nodes in the
        // tree
        // space complexity is O(h) where h is height of the tree due to recursive stack
        // space
        Node p = new Node(1);
        p.left = new Node(2);
        p.right = new Node(4);

        Node q = new Node(1);
        q.left = new Node(2);
        q.right = new Node(3);

        System.out.println(IsTreeSame(p, q));
   ZigZagTraversal(root);
   System.out.println();
   boundaryTraversal(root);


    Node roott = new Node(1);
     roott.left = new Node(2);
        roott.left.left = new Node(4);
        roott.left.left.left = new Node(6);   // Extreme left leaf

        // Right side chain
        roott.right = new Node(3);
        roott.right.right = new Node(5);
        roott.right.right.right = new Node(7); // Extreme right leaf
  // System.out.println("Width of tree"+BTWidthWithoutgaps(roott));
    System.out.println("Width of tree"+BTWidthWithGaps(roott));
    Node res=lowestCommonAncestor(root,root.right.left,root.right.right);
    System.out.println("LCA"+res.value);

    }

}
