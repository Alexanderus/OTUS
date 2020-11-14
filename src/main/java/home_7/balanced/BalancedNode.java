package home_7.balanced;

public class BalancedNode implements BNode {
    private int value;
    private BNode leftChild;
    private BNode rightChild;
    private int height;

    public BalancedNode() {
        this.value = 0;
        this.leftChild = null;
        this.rightChild = null;
        this.height = 0;
    }

    public BalancedNode(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
        this.height = 0;
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
    public BNode getLeftChild() {
        return this.leftChild;
    }

    @Override
    public BNode getRightChild() {
        return this.rightChild;
    }

    @Override
    public void setLeftChild(BNode leftChild) {
        this.leftChild = leftChild;
    }

    @Override
    public void setRightChild(BNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }
//    private int value;
//    private BalancedNode leftChild;
//    private BalancedNode rightChild;
//    private int depth;
//

//
//    public int getValue() {
//        return this.value;
//    }
//
//    private BalancedNode add(BalancedNode currentNode, int value) {
//        if (currentNode == null) {
//            return new BalancedNode(value);
//        }
//        if (currentNode.value < value) {
//            currentNode.rightChild = currentNode.add(currentNode.rightChild, value);
//
//        }
//        if (value < currentNode.value) {
//            currentNode.leftChild = currentNode.add(currentNode.leftChild, value);
//        }
//        return currentNode;
//    }
//
//    private boolean has(BalancedNode currentNode, int value) {
//        if (currentNode == null) {
//            return false;
//        }
//
//        if (currentNode.value == value) {
//            return true;
//        }
//
//        return currentNode.value < value ?
//                currentNode.has(currentNode.leftChild, value) :
//                currentNode.has(currentNode.rightChild, value);
//    }
//
//    private BalancedNode delete(BalancedNode currentNode, int value) {
//        if (currentNode == null) {
//            return null;
//        }
//        if (currentNode.value == value) {
//            if (currentNode.leftChild == null && currentNode.rightChild == null) {
//                return null;
//            }
//            if (currentNode.leftChild == null) {
//                return currentNode.rightChild;
//            }
//            if (currentNode.rightChild == null) {
//                return currentNode.leftChild;
//            }
//            int lowestInSubTree = getLowestInSubTree(currentNode.leftChild);
//            currentNode.value = lowestInSubTree;
//            currentNode.leftChild = currentNode.delete(currentNode.leftChild, lowestInSubTree);
//            return currentNode;
//        }
//        if (currentNode.value < value && currentNode.leftChild != null) {
//            currentNode.leftChild = currentNode.leftChild.delete(currentNode.leftChild, value);
//        }
//        if (currentNode.rightChild != null) {
//            currentNode.rightChild = currentNode.rightChild.delete(currentNode.rightChild, value);
//        }
//        return currentNode;
//    }
//
//    private int getLowestInSubTree(BalancedNode node) {
//        return node.leftChild == null ? node.value : getLowestInSubTree(node.leftChild);
//    }
//
//    @Override
//    public Node getLeftChild() {
//        return null;
//    }
//
//    @Override
//    public Node getRightChild() {
//        return null;
//    }
//
//    @Override
//    public void setLeftChild(Node leftChild) {
//
//    }
//
//    @Override
//    public void setRightChild(Node leftChild) {
//
//    }
//
//    @Override
//    public int getHeight() {
//        return 0;
//    }
//
//    @Override
//    public void setHeight(int x) {
//
//    }
//
//    @Override
//    public Node getRoot() {
//        return null;
//    }
//
//    @Override
//    public void insert(int value) {
//
//    }
//
//    @Override
//    public boolean search(int value) {
//        return false;
//    }
//
//    @Override
//    public void remove(int value) {
//
//    }
}