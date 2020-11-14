package home_7;

public interface Node {
    int getValue();
    void setValue(int value);
    Node getLeftChild();
    Node getRightChild();
    void setLeftChild(Node leftChild);
    void setRightChild(Node rightChild);
}
