package org.example;
public class BinarySearchTree<T extends Comparable<T>> {
    Node<T> root;
    int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }


    public void insert(T data) {
        root = this.insertHelper(this.root, data);
        this.size++;
    }


    private Node<T> insertHelper(Node<T> root, T data) {
        if (root == null) {
            root = new Node<>(data);
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = this.insertHelper(root.left, data);
        } else {
            root.right = this.insertHelper(root.right, data);
        }

        return root;
    }


    public void inorder() {
        this.inorderHelper(this.root);
    }


    private void inorderHelper(Node<T> root) {
        if (root == null) {
            return;
        }

        inorderHelper(root.left);
        System.out.print(root.data + " ");
        inorderHelper(root.right);
    }
}
