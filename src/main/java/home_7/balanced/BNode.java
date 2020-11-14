package home_7.balanced;

import home_7.Node;

public interface BNode {
    int getValue();
    void setValue(int value);
    int getHeight();
    void setHeight(int height);
    BNode getLeftChild();
    BNode getRightChild();
    void setLeftChild(BNode node);
    void setRightChild(BNode node);
}
