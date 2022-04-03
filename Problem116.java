/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {return root;}
        int nextLevPow2 = 2;
        int count = 1;
        Queue<Node> bfs = new LinkedList<>();
        bfs.add(root);
        while (!bfs.isEmpty()) {
            Node n = bfs.remove();
            // System.out.println(n.val);
            if (count < nextLevPow2 - 1) {
                //there is always something in the queue
                n.next = bfs.peek();
            } else {
                nextLevPow2 = nextLevPow2*2;
            }
            if (n.left != null ) {bfs.add(n.left);}
            if (n.right != null ) {bfs.add(n.right);}
            count++;
        }
        return root;
    }
}
