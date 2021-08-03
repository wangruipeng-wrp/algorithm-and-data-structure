package AVL;

public class AVL {

    // 节点类
    private static class Node {
        public int e, height;
        public Node left, right;

        public Node(int e, Node left, Node right) {
            this.height = 1;
            this.e = e;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return e + "  ";
        }
    }

    private Node root;
    private int size;

    public AVL() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 获取节点高度
     */
    public int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    /**
     * 获取平衡因子
     */
    public int getBalanceFactor(Node node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    /**
     * 左旋转
     */
    private Node leftRotate(Node a) {
        // 暂存
        Node b = a.right;
        Node e = b.left;

        // 旋转
        b.left = a;
        a.right = e;

        // 更新Height
        a.height = Math.max(getHeight(a.left), getHeight(a.right)) + 1;
        b.height = Math.max(getHeight(b.left), getHeight(b.right)) + 1;

        return b;
    }

    /**
     * 右旋转
     */
    private Node rightRotate(Node a) {
        // 暂存
        Node b = a.left;
        Node f = b.right;

        // 旋转
        b.right = a;
        a.left = f;

        // 更新Height
        a.height = Math.max(getHeight(a.left), getHeight(a.right)) + 1;
        b.height = Math.max(getHeight(b.left), getHeight(b.right)) + 1;

        return b;
    }

    public void add(int e) {
        root = add(root, e);
    }
    private Node add(Node root, int e) {
        if (root == null) {
            size++;
            return new AVL.AVL.Node(e, null, null);
        }

        if (e < root.e) root.left = add(root.left, e);
        if (e > root.e) root.right = add(root.right, e);

        // 更新Height
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

        // 平衡维护
        return keepBalance(root);
    }

    public boolean find(int e) {
        return find(root, e);
    }
    public boolean find(Node root, int e) {
        if (root == null)
            return false;

        if (root.e == e)
            return true;

        else if (e < root.e)
            return find(root.left, e);

        else
            return find(root.right, e);
    }

    /**
     * 删除最大元素
     */
    private Node delMax(Node root) {
        if (root == null) return null;

        if (root.right != null) {
            root.right = delMax(root.right);
            return root;
        } else {
            size --;
            if (root.left == null) {
                root = null;
                return null;
            } else {
                return root.left;
            }
        }
    }

    /**
     * 删除任意元素
     */
    public void delNode(int e) {
        delNode(root, e);
    }

    private Node delNode(Node root, int e) {
        if (root == null) return null;

        if (e > root.e) {
            root.right = delNode(root.right, e);
            return root;
        }
        if (e < root.e) {
            root.left = delNode(root.left, e);
            return root;
        }

        size --;
        Node retNode;
        if (root.left == null) retNode =  root.right;
        if (root.right == null) retNode = root.left;
        retNode = delMax(root.left);

        // 更新Height
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

        // 平衡维护
        return keepBalance(retNode);
    }

    /**
     * 保持平衡
     */
    private Node keepBalance(Node node) {

        // 平衡维护
        int balance = getBalanceFactor(root);

        // LL
        if (balance >= 2 && getBalanceFactor(root.left) >= 0)
            return rightRotate(root);

        // RR
        if (balance <= -2 && getBalanceFactor(root.right) <= 0)
            return leftRotate(root);

        // LR
        if (balance >= 2 && getBalanceFactor(root.left) <= 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RL
        if (balance <= -2 && getBalanceFactor(root.right) >= 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
}
