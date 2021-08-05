package RBTree;

public class RBTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private static class Node {
        int e;
        Node left, right;
        boolean color;

        public Node(int e) {
            this.e = e;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }

    private Node root;
    private int size;

    /**
     * 左旋转
     */
    private Node leftRotate(Node node) {
        // 暂存
        Node x = node.right;

        // 旋转
        node.right = x.left;
        x.left = node;

        // 着色
        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 右旋转
     */
    private Node rightRotate(Node node) {
        // 暂存
        Node x = node.left;

        // 旋转
        node.left = x.right;
        x.right = node;

        // 着色
        x.color = node.color;
        node.color = RED;

        return x;
    }

    private boolean isRed(Node node) {
        return node == null ? BLACK : node.color;
    }

    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void add(int e) {
        add(root, e);
        root.color = BLACK;
    }

    private Node add(Node node, int e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (node.e > e) {
            node.left = add(node.left, e);
        }
        if (node.e < e) {
            node.right = add(node.right, e);
        }

        if (isRed(node.right) && !isRed(node.left))
            node = leftRotate(node);

        if (isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);

        if (isRed(node.left) && isRed(node.right))
            flipColors(node);

        return node;
    }
}
