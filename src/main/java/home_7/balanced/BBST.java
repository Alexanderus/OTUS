package home_7.balanced;

import home_7.BST;

public interface BBST {
    BNode getRoot();
    BNode smallLeftRotation(BNode root);
    BNode smallRightRotation(BNode root);
    BNode bigLeftRotation(BNode root);
    BNode bigRightRotation(BNode root);
    void reBalance(BNode root);
    void insert(int value);
    boolean search(int value);
    void remove(int value);
}
