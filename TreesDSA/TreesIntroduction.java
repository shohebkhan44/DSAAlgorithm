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

    int value;
    Node left;
    Node right;
    void Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }


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
    public static void main(String[] args) {
        System.out.println("This class provides an introduction to Trees \n in Data Structures and Algorithms.");

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
       PreorderTraversal(root);
       System.out.println();
       InorderTraversal(root);
       System.out.println();
       PostorderTraversal(root);
       //time complexity of tree traversals is O(n) where n is number of nodes in the tree
       //space complexity is O(h) where h is height of the tree due to recursive stack space
    }




}
