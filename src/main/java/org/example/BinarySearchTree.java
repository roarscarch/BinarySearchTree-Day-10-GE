package org.example;

public class BinarySearchTree<T extends Comparable<T>> {
    Node<T> root;
    int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public void search(T data) {
        boolean found = searchHelper(root, data);
        System.out.println(found ? "Found node " + data : "Cannot find node " + data);
    }

    private boolean searchHelper(Node<T> root, T data) {
        if (root == null) {
            return false;
        }
        int res = data.compareTo(root.data);
        if (res < 0) {
            return searchHelper(root.left, data);
        } else if (res > 0) {
            return searchHelper(root.right, data);
        } else {
            return true;
        }
    }

    public void insert(T data) {
        root = insertHelper(root, data);
        size++;
    }

    private Node<T> insertHelper(Node<T> root, T data) {
        if (root == null) {
            root = new Node<>(data);
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = insertHelper(root.left, data);
        } else {
            root.right = insertHelper(root.right, data);
        }

        return root;
    }

    public void inorder() {
        inorderHelper(root);
    }

    private void inorderHelper(Node<T> root) {
        if (root == null) {
            return;
        }

        inorderHelper(root.left);
        System.out.print(root.data + " ");
        inorderHelper(root.right);
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}
