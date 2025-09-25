package bst;

import java.util.*;
import java.util.function.Consumer;

public class BinarySearchTree<E> implements BST<E> {
    private Node<E> root;

    private final Comparator<? super E> cmp;

    private final class Node<E> {
        E key;
        int size = 1; // 以该节点为根节点的子树大小
        Node<E> left, right;

        Node(E key) {
            this.key = key;
        }

        Node(E key, Node<E> left, Node<E> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.size = 3;
        }
    }

    public BinarySearchTree() {
        this.cmp = null;
    }

    public BinarySearchTree(Comparator<? super E> comparator) {
        this.cmp = comparator;
    }

    @SuppressWarnings("unchecked")
    private int compare(E a, E b) {
        if (cmp != null) return cmp.compare(a, b);
        return ((Comparable<? super E>) a).compareTo(b);
    }

    @Override
    public Comparator<? super E> comparator() {
        return cmp;
    }

    private int size(Node<E> node) {
        return (node == null ? 0 : node.size);
    }

    private void pull(Node<E> node) {
        if (node != null) {
            node.size = 1 + size(node.left) + size(node.right);
        }
    }

    /**
     * 插入操作，如果以存在则覆盖
     * @param key 要插入的值
     */
    @Override
    public void put(E key) {
        root = put(key, root);
    }

    private Node<E> put(E key, Node<E> node) {
        if (node == null) {
            return new Node<>(key);
        }

        int c = compare(key, node.key);
        if (c < 0) {
            node.left = put(key, node.left);
        } else if (c > 0) {
            node.right = put(key, node.right);
        } else {
            // 已存在则覆盖
            node.key = key;
        }

        pull(node); // 更新 size
        return node;
    }

    @Override
    public boolean contains(E key) {
        return contains(key, root);
    }

    private boolean contains(E key, Node<E> node) {
        if (node == null) {
            return false;
        }

        int c = compare(key, node.key);
        if (c == 0) {
            return true;
        } else if (c < 0) {
            return contains(key, node.left);
        } else {
            return contains(key, node.right);
        }
    }

    @Override
    public void remove(E key) {
        root = remove(key, root);
    }

    private Node<E> remove(E key, Node<E> node) {
        if (node == null) {
            return null;
        }

        int c = compare(key, node.key);
        if (c == 0) {
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            Node<E> min = minNode(node.right);
            node.key = min.key;
            node.right = deleteMin(node.right);
        } else if (c < 0) {
            node = remove(key, node.left);
        } else {
            node = remove(key, node.right);
        }

        pull(node);
        return node;
    }

    private Node<E> deleteMin(Node<E> node) {
        if (node == null) return null;
        if (node.left == null) return node.right;

        node.left = deleteMin(node.left);
        pull(node);
        return node;
    }

    private Node<E> minNode(Node<E> node) {
        if (node == null) {
            return null;
        }

        while (node.left != null){
            node = node.left;
        }

        return node;
    }

    @Override
    public Optional<E> min() {
        Node<E> minNode = minNode(root);
        return (minNode == null ? Optional.empty() : Optional.of(minNode.key));
    }

    @Override
    public Optional<E> max() {
        Node<E> maxNode = maxNode(root);
        return (maxNode == null ? Optional.empty() : Optional.of(maxNode.key));
    }

    private Node<E> maxNode(Node<E> node) {
        if (node == null) {
            return null;
        }

        while (node.right != null){
            node = node.right;
        }

        return node;
    }

    @Override
    public Optional<E> floor(E key) {
        return Optional.empty();
    }

    @Override
    public Optional<E> ceil(E key) {
        return Optional.empty();
    }

    @Override
    public int size() {
        return size(root);
    }



    @Override
    public int height() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void inorder(Consumer<E> action) {
        Objects.requireNonNull(action);
        Deque<Node<E>> st = new ArrayDeque<>();
        Node<E> cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) { st.push(cur); cur = cur.left; }
            cur = st.pop();
            action.accept(cur.key);
            cur = cur.right;
        }
    }

    @Override
    public void preorder(Consumer<E> action) {

    }

    @Override
    public void postorder(Consumer<E> action) {

    }

    @Override
    public void levelOrder(Consumer<E> action) {

    }

    @Override
    public boolean isValidBST() {
        return false;
    }
}
