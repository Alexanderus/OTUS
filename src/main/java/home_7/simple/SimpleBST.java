package home_7.simple;

import home_7.BST;

public class SimpleBST implements BST {
    private Node root;

    @Override
    public void insert(int value) {
        if (this. root == null) {
            this.root = new Node(value);
        } else {
            root.add(root, value);
        }
    }

    @Override
    public boolean search(int value) {
        if (this.root == null) {
            return false;
        }
        return this.root.has(root, value);
    }

    @Override
    public void remove(int value) {
        if (root != null) {
            root = root.delete(root, value);
        }
    }

    class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        private Node() {

        }

        private Node(int value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        private Node add(Node currentNode, int value) {
            if (currentNode == null) {
                return new Node(value);
            }

            if (this.value < value) {
                leftChild.add(currentNode, value);
            }
            if (value < this.value) {
                rightChild.add(currentNode, value);
            }
            return currentNode;
        }

        private boolean has(Node currentNode, int value) {
            if (currentNode == null) {
                return false;
            }

            if (currentNode.value == value) {
                return true;
            }

            return currentNode.value < value ?
                    currentNode.leftChild.has(currentNode.leftChild, value) :
                    currentNode.rightChild.has(currentNode.rightChild, value);
        }

        private Node delete(Node currentNode, int value) {
            if (currentNode == null) {
                return null;
            }
            if (currentNode.value == value) {
                if (currentNode.leftChild == null && currentNode.rightChild == null) {
                    return null;
                }
                if (currentNode.leftChild == null) {
                    return currentNode.rightChild;
                }
                if (currentNode.rightChild == null) {
                    return currentNode.leftChild;
                }
                int maxInLeftSubTree = getHighestInSubTree(currentNode.leftChild);
                currentNode.value = maxInLeftSubTree;
                currentNode.leftChild = currentNode.delete(currentNode.leftChild, maxInLeftSubTree);
                return currentNode;
            }
            if (currentNode.value < value && currentNode.leftChild != null) {
                currentNode.leftChild = currentNode.leftChild.delete(currentNode.leftChild, value);
            }
            if (currentNode.rightChild != null) {
                currentNode.rightChild = currentNode.rightChild.delete(currentNode.rightChild, value);
            }
            return currentNode;
        }

        private int getHighestInSubTree(Node node) {
            return node.rightChild == null ? node.value : getHighestInSubTree(node.rightChild);
        }

    }
}
