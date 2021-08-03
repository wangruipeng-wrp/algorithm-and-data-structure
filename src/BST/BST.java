package BST;

import Queue.ArrayQueue;
import Queue.IQueue;
import Stack.ArrayStack;
import Stack.IStack;

public class BST {

    // 节点类
    private static class Node {
        public int e;
        public Node left, right;

        public Node(int e, Node left, Node right) {
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

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public void add(int e) {
        root = add(root, e);
    }
    private Node add(Node root, int e) {
        if (root == null) {
            size++;
            return new Node(e, null, null);
        }

        if (e < root.e) {
            root.left = add(root.left, e);
        }
        if (e > root.e) {
            root.right = add(root.right, e);
        }

        return root;
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
    public boolean delNode(int e) {
        return delNode(root, e);
    }
    private boolean delNode(Node root, int e) {
        if (root == null) return false;
        if (e == root.e) {
            root = delMax(root.left);
            return true;
        }

        return delNode(e > root.e ? root.right : root.left, e);
    }

    /**
     * 前序遍历
     */
    public void preOrder(Node root) {
        if (root == null) return;

        // 使用栈来模拟递归
        IStack<Node> stack = new ArrayStack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node);

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder(Node root) {
        // 使用栈来模拟递归
        IStack<Node> stack = new ArrayStack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            Node node = stack.pop();
            System.out.print(node);

            root = node.right;
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(Node root) {
        // 使用栈来模拟递归
        IStack<Node> stack = new ArrayStack<>();

        Node prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.right != null && root.right != prev) {
                stack.push(root);
                root = root.right;
            } else {
                System.out.print(root);
                prev = root;
                root = null;
            }
        }
    }

    /**
     * 前序遍历
     */
    public void preOrderByRecursion(Node root) {
        if (root == null) return;

        System.out.print(root);
        preOrderByRecursion(root.left);
        preOrderByRecursion(root.right);
    }

    /**
     * 中序遍历
     */
    public void inOrderByRecursion(Node root) {
        if (root == null) return;

        inOrderByRecursion(root.left);
        System.out.print(root);
        inOrderByRecursion(root.right);
    }

    /**
     * 后序遍历
     */
    public void postOrderByRecursion(Node root) {
        if (root == null) return;

        postOrderByRecursion(root.left);
        postOrderByRecursion(root.right);
        System.out.print(root);
    }

    /**
     * 层序遍历
     */
    public void levelOrder(Node root) {
        IQueue<Node> queue = new ArrayQueue<>();

        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            System.out.print(node);

            queue.enqueue(node.left);
            queue.enqueue(node.right);
        }
    }
}
