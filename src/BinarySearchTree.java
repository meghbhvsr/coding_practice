
public class BinarySearchTree<E extends Comparable<E>> {

    private class BinaryNode<E extends Comparable<E>> extends Node<E> {
        BinaryNode<E> left;
        BinaryNode<E> right;
        BinaryNode(E val) { super(val); }
    }

    private BinaryNode<E> head;
    private int size;

    public BinarySearchTree() {}

    public BinarySearchTree(E val) {
        this.head = new BinaryNode<>(val);
        this.size++;
    }

    public void add(E val) {
        // no existing tree add new node
        if (head == null) {
            head = new BinaryNode<>(val);
        } else {
            // add val to existing tree
            add(head, val);
        }
        this.size++;
    }

    private void add(BinaryNode<E> node, E val) {
        if (val.compareTo(node.val) < 0) {
            // new value must go on left sub tree
            // if left sub tree null, add new node else recurse
            if (node.left == null) {
                node.left = new BinaryNode<>(val);
            } else {
                add(node.left, val);
            }
        } else {
            // new value must go on right sub tree
            // if right sub tree null, add new node else recurse
            if (node.right == null) {
                node.right = new BinaryNode<>(val);
            } else {
                add(node.right, val);
            }
        }
    }

    public void print() {
        print(head);
        System.out.println();
    }

    private void print(BinaryNode<E> node) {
        if (node != null) {
            print(node.left);
            System.out.print(node + ",");
            print(node.right);
        }
    }

    public boolean contains(E val) {
        return contains(head, val);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return this.size;
    }

    private boolean contains(BinaryNode<E> node, E val) {
        // node not found
        if (node == null) {
            return false;
        }
        // node found
        if (val.compareTo(node.val) == 0) {
            return true;
        }
        if (val.compareTo(node.val) < 0) {
            // recurse on left if val is less then current val
            return contains(node.left, val);
        } else {
            // recurse on right if val is greater then current val
            return contains(node.right, val);
        }
    }

    public void remove(E val) {
        // checks if the value to be removed is in the tree
        if (!contains(val)) {
            return;
        }
        // checks if the head is the value to be removed
        if (head.val.compareTo(val) == 0) {
            // if it has 0 children, just removed head by making it null
            if (head.left == null && head.right == null) {
                head = null;
            } else if (head.left == null) { // if head has right child, then set head to its right
                head = head.right;
            } else if (head.right == null) { // if head has left child, then set head to its left
                head = head.left;
            } else {
                // storing ref to left sub tree
                BinaryNode<E> leftSubTree = head.left;

                // always set head to its right sub tree
                head = head.right;

                // attach left sub tree to left of left most node
                findLeftMost(head).left = leftSubTree;
            }
        } else {
            remove(null, head, val);
        }
        this.size--;
    }

    private void remove(BinaryNode<E> parent, BinaryNode<E> node, E val) {
        // if node to remove
        if (val.compareTo(node.val) == 0) {
            // check if it has 0 children
            if (node.left == null && node.right == null) {
                // check if node is on left or right side of parent
                // remove ref of node from parent
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (node.left == null) { // if node has right only
                // replace ref of node from parent to nodes right
                if (parent.left == node) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
            } else if (node.right == null) { // if node has left only
                // replace ref of node from parent to nodes left
                if (parent.left == node) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
            } else {
                // storing ref to left sub tree
                BinaryNode<E> leftSubTree = node.left;

                // always replace ref of node from parent to nodes right
                if (parent.left == node) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }

                // attach left sub tree to left of left most node
                findLeftMost(node.right).left = leftSubTree;
            }
        } else if (val.compareTo(node.val) < 0) {
            // recurse on left sub tree if val is less then current value
            remove(node, node.left, val);
        } else {
            // recurse on right sub tree if val is greater then current value
            remove(node, node.right, val);
        }
    }

    public int depth() {
        return depth(this.head, 0);
    }

    private int depth(BinaryNode<E> node, int level) {
        if (node == null) {
            return level;
        }

        return Math.max(depth(node.left, ++level), depth(node.right, ++level));
    }

    // node != null
    private BinaryNode<E> findLeftMost(BinaryNode<E> node) {
        // recurse on left until left is null
        // if left null return node
        return node.left != null ? findLeftMost(node.left) : node;
    }
}