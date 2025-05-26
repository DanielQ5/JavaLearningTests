package com.javalearningtests.pruebasbasicas;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeNode {

    private static class Node {
        int trackingNumber;
        Node left;
        Node right;

        public Node(int trackingNumber) {
            this.trackingNumber = trackingNumber;
        }
    }

    Node root;

    public void insert(int trackingNumber) {
        root = insertRec(root, trackingNumber);
    }

    public Node insertRec(Node root, int trackingNumber) {
        if (root == null) {
            root = new Node(trackingNumber);
        } else if (trackingNumber < root.trackingNumber) {
            root.left = insertRec(root.left, trackingNumber);
        } else if (trackingNumber > root.trackingNumber) {
            root.right = insertRec(root.right, trackingNumber);

        }
        return root;
    }

    public void inOrder() {
        inOrderRec(root);
    }

    public void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.trackingNumber + " ");
            inOrderRec(root.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
    }

    public void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.trackingNumber + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
    }

    public void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.trackingNumber + " ");
        }
    }

    public Node delete(Node root, int trackingNumber) {
        if (root == null) {
            return null;
        }
        if (trackingNumber < root.trackingNumber) {
            root.left = delete(root.left, trackingNumber);
        } else if (trackingNumber > root.trackingNumber) {
            root.right = delete(root.right, trackingNumber);
        } else {
            if (root.left == null) {
                return root.right;

            } else if (root.right == null) {
                return root.left;

            }

            Node successor = getSuccessor(root);
            root.trackingNumber = successor.trackingNumber;
            root.right = delete(root.right, successor.trackingNumber);

        }
        return root;
    }

    public Node getSuccessor(Node root) {
        if (root == null) {
            return null;
        }
        Node temp = root.right;

        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public boolean iterativeSearch(Node root, int searchNumber) {
        if (root == null) {
            return false;
        }

        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp.trackingNumber == searchNumber) {
                return true;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        return false;
    }

}

