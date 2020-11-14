package home_7.simple;

import home_7.Node;

class SimpleNode implements Node {
    private int value;
    private Node leftChild;
    private Node rightChild;

    SimpleNode() {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    SimpleNode(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public Node getLeftChild() {
        return this.leftChild;
    }

    @Override
    public Node getRightChild() {
        return this.rightChild;
    }

    @Override
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    @Override
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
