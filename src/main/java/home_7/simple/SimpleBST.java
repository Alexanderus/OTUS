package home_7.simple;

import home_7.BST;
import home_7.Node;

public class SimpleBST implements BST {
    private Node root;

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public void insert(int value) {
        if (this. root == null) {
            this.root = new SimpleNode(value);
        } else {
            insert(root, value);
        }
    }

    private Node insert(Node currentNode, int value) {
        if (currentNode == null) {
            return new SimpleNode(value);
        }
        if (currentNode.getValue() < value) {
            currentNode.setRightChild(insert(currentNode.getRightChild(), value));
        }
        if (value < currentNode.getValue()) {
            currentNode.setLeftChild(insert(currentNode.getLeftChild(), value));
        }
        return currentNode;
    }

    @Override
    public boolean search(int value) {
        return this.search(root, value);
    }


    private boolean search(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }

        if (currentNode.getValue() == value) {
            return true;
        }

        return currentNode.getValue() < value ?
                this.search(currentNode.getLeftChild(), value) :
                this.search(currentNode.getRightChild(), value);
    }

    @Override
    public void remove(int value) {
        delete(root, value);
    }

    private Node delete(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.getValue() == value) {
            if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
                return null;
            }
            if (currentNode.getLeftChild() == null) {
                return currentNode.getRightChild();
            }
            if (currentNode.getRightChild() == null) {
                return currentNode.getLeftChild();
            }
            int highestInSubTreeValue = getHighestInSubTreeValue(currentNode.getRightChild());
            currentNode.setValue(highestInSubTreeValue);
            currentNode.setRightChild(this.delete(currentNode.getRightChild(), highestInSubTreeValue));
            return currentNode;
        }
        if (value < currentNode.getValue()) {
            currentNode.setLeftChild(this.delete(currentNode.getLeftChild(), value));
        }
        if (currentNode.getValue() < value) {
            currentNode.setRightChild(this.delete(currentNode.getRightChild(), value));
        }
        return currentNode;
    }

    private int getHighestInSubTreeValue(Node node) {
        return node.getRightChild() == null ? node.getValue()
                : getHighestInSubTreeValue(node.getRightChild());
    }
}
