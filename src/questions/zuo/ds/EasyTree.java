package questions.zuo.ds;

import java.util.Stack;

public class EasyTree {
    private EasyTreeNode root;

    public enum TraversalOrder {
        PRE_ORDER,
        IN_ORDER,
        POS_ORDER
    }

    public EasyTree() {
    }

    public EasyTree(String str, TraversalOrder tr) {

    }

    private void construct(TraversalOrder tr) {
        switch (tr) {
            case PRE_ORDER -> preOrderConstruct();
            case IN_ORDER -> inOrderConstruct();
            case POS_ORDER -> posOrderConstruct();
        }
    }

    private void preOrderConstruct() {

    }

    private void inOrderConstruct() {

    }

    private void posOrderConstruct() {

    }

    public EasyTreeNode getRoot() {
        return this.root;
    }

    public void preOrderTraversal(EasyTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void preOrderTraversalNoRecurse(EasyTreeNode root) {
        if (root != null) {
            var stack = new Stack<EasyTreeNode>();
            stack.push(root);
            while (!stack.isEmpty()) {
                var node = stack.pop();
                System.out.println(node.data);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }

    public void inOrderTraversal() {
        if (root == null) {
            return;
        }
        preOrderTraversal(root.left);
        System.out.println(root.data);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversalNoRecurse(EasyTreeNode root) {
        if (root != null) {
            var stack = new Stack<EasyTreeNode>();
            var node = root;
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    var cur = stack.pop();
                    System.out.println(cur);
                    node = cur.right;
                }
            }
        }
    }

    public void posOrderTraversal() {
        if (root == null) {
            return;
        }
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.println(root.data);
    }

    public void posOrderTraversalNoRecurseSingleStack(EasyTreeNode root) {
        if (root != null) {
            var stack = new Stack<EasyTreeNode>();
            stack.push(root);
            var monitor = root;
            while (!stack.isEmpty()) {
                var cur = stack.peek();
                if (cur.left != null && cur.left != monitor && cur.right != monitor) {
                    stack.push(cur.left);
                } else if (cur.right != null && cur.right != monitor) {
                    stack.push(cur.right);
                } else {
                    monitor = stack.pop();
                    System.out.println(monitor);
                }
            }
        }
    }

    public void postOrderTraversalNoRecurseDoubleStack(EasyTreeNode root) {
        if (root != null) {
            var stack = new Stack<EasyTreeNode>();
            var postOrder = new Stack<EasyTreeNode>();
            stack.push(root);
            while (!stack.isEmpty()) {
                var node = stack.pop();
                postOrder.push(node);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            while (!postOrder.isEmpty()) {
                System.out.println(postOrder.pop());
            }
        }
    }
}