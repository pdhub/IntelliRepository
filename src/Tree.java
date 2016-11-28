import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by PDeb on 11/26/2016.
 */
class Node{

    int data;
    Node left, right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
public class Tree {
    Node root;

    void iterativePreorder(Node node) {

        // Base Case
        if (node == null) {
            return;
        }

        // Create an empty stack and push root to it
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(root);

        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        while (nodeStack.empty() == false) {

            // Pop the top item from stack and print it
            Node mynode = nodeStack.peek();
            System.out.print(mynode.data + " ");
            nodeStack.pop();

            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                nodeStack.push(mynode.right);
            }
            if (mynode.left != null) {
                nodeStack.push(mynode.left);
            }
        }
    }

    public void reverseLevelOrder(Node root) {
        Stack stack = new Stack();
        Queue<Node> queue = new LinkedList();

        if (root == null)
            return;

        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            queue.offer(root.right);
            queue.offer(root.left);
            stack.push(root);
        }

        while (stack.isEmpty())
            System.out.println(stack.pop());
    }

    boolean isTreeBST(Node root) {
        Node prev = null;
        if (root != null) {
            if (!isTreeBST(root.left))
                return false;
            if (prev != null && root.data <= prev.data)
                return false;
            prev = root;
            return isTreeBST(root.right);
        }
        return true;
    }

    int heightOfTree(Node root){
        if(root==null)
            return 0;
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        if(left>right)
            return left;
        else
            return right;
    }

    void preOrderTraversal(Node root){
        if(root == null)
            return;
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    void levelOrderTraversal(Node root){
        if(root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println(temp.data);
            queue.add(temp.right);
            queue.add(temp.left);
        }
    }

    void topview(Node root){
        if(root == null)
            return;
        printLeftView(root);
        System.out.println(root.data);
        printRightView(root);
    }

    private void printLeftView(Node root) {
        if(root==null)
            return;
        System.out.println(root.data);
        printLeftView(root.left);
    }

    private void printRightView(Node root) {
        if(root==null)
            return;
        System.out.println(root.data);
        printRightView(root.right);
    }

    Node bstInsertion(Node root, int val){
        if(root == null) {
            Node temp = new Node(val);
            //temp.data = val;
            temp.left = null;
            temp.right = null;
            return temp;
        }
        if(val < root.data)
            root.left = bstInsertion(root.left,val);
        else if(val > root.data)
            root.right = bstInsertion(root.right, val);
        return root;
    }

    Node leastCommonAnncestor(Node root, int v1, int v2){

        if(root == null)
            return root;
        if(v1 < root.data && v2 < root.data)
            return leastCommonAnncestor(root.left, v1, v2);
        if(v1 > root.data && v2 > root.data)
            return leastCommonAnncestor(root.right, v1, v2);
        return root;
    }
}
