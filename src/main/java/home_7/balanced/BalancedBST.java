package home_7.balanced;

public class BalancedBST implements BBST {
    private BNode root;

    @Override
    public BNode getRoot() {
        return this.root;
    }

    @Override
    public void insert(int value) {
        if (this.root == null) {
            this.root = new BalancedNode(value);
        } else {
            root = insert(root, value);
        }
    }

    private int getNodeHeight(BNode node) {
        return node == null ? -1 : node.getHeight();
    }

    private BNode insert(BNode node, int value) {
        if (node == null) {
            return new BalancedNode(value);
        }
        if (value < node.getValue()) {
            node.setLeftChild(this.insert(node.getLeftChild(), value));
            if (getNodeHeight(node.getLeftChild()) - getNodeHeight(node.getRightChild()) == 2) {
                if (value < node.getLeftChild().getValue()) {
                    node = smallRightRotation(node);
                } else {
                    node = bigRightRotation(node);
                }
            }
        } else if (node.getValue() < value) {
            node.setRightChild(this.insert(node.getRightChild(), value));
            if (getNodeHeight(node.getRightChild()) - getNodeHeight(node.getLeftChild()) == 2) {
                if (value > node.getRightChild().getValue()) {
                    node = smallLeftRotation(node);
                } else {
                    node = bigLeftRotation(node);
                }
            }
        }
        node.setHeight(Math.max(getNodeHeight(node.getLeftChild()), getNodeHeight(node.getRightChild())) + 1);
        return node;
    }

    @Override
    public boolean search(int searchingValue) {
        return this.search(searchingValue, root);
    }

    private boolean search(int searchingValue, BNode currentNode) {
        if (currentNode == null) {
            return false;
        }
        if (currentNode.getValue() < searchingValue) {
            return search(searchingValue, currentNode.getRightChild());
        }
        if (searchingValue < currentNode.getValue()) {
            return search(searchingValue, currentNode.getLeftChild());
        }
        return true;
    }

    @Override
    public void remove(int valueToRemove) {
        boolean isLeftSubTree = false;
        if (root != null && root.getValue() == valueToRemove) {
            if (root.getRightChild() != null) {
                int lowestSubTreeValue = getLowestInSubTreeValue(root.getRightChild());
                root.setValue(lowestSubTreeValue);
                root.setRightChild(delete(root.getRightChild(), lowestSubTreeValue, false));
            } else if (root.getLeftChild() != null){
                int highestSubTreeValue = getHighestInSubTreeValue(root.getLeftChild());
                root.setValue(highestSubTreeValue);
                root.setLeftChild(delete(root.getLeftChild(), highestSubTreeValue, true));
            } else {
                root = (delete(root, valueToRemove, isLeftSubTree));
            }
        } else {
            isLeftSubTree = root.getValue() > valueToRemove;
            root = (delete(root, valueToRemove, isLeftSubTree));
        }

    }

    private BNode delete(BNode currentNode, int value, boolean isLeftSubTree) {
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
            if (isLeftSubTree) {
                int highestSubTreeValue = getHighestInSubTreeValue(currentNode.getLeftChild());
                currentNode.setValue(highestSubTreeValue);
                currentNode.setLeftChild(this.delete(currentNode.getLeftChild(), highestSubTreeValue, isLeftSubTree));
            } else {
                int lowestSubTreeValue = getLowestInSubTreeValue(currentNode.getRightChild());
                currentNode.setValue(lowestSubTreeValue);
                currentNode.setRightChild(this.delete(currentNode.getRightChild(), lowestSubTreeValue, isLeftSubTree));
            }

        } else if (value < currentNode.getValue()) {
            currentNode.setLeftChild(this.delete(currentNode.getLeftChild(), value, isLeftSubTree));
        } else if (currentNode.getValue() < value) {
            currentNode.setRightChild(this.delete(currentNode.getRightChild(), value, isLeftSubTree));
        }
        if (getNodeHeight(currentNode.getRightChild()) - getNodeHeight(currentNode.getLeftChild()) == 2) {
            if (value < currentNode.getRightChild().getValue()) {
                currentNode = smallLeftRotation(currentNode);
            } else {
                currentNode = smallRightRotation(currentNode);
            }
        }
        return currentNode;
    }

    private int getLowestInSubTreeValue(BNode node) {
        return node.getLeftChild() == null ? node.getValue()
                : getLowestInSubTreeValue(node.getLeftChild());
    }

    private int getHighestInSubTreeValue(BNode node) {
        return node.getRightChild() == null ? node.getValue()
                : getLowestInSubTreeValue(node.getRightChild());
    }

    @Override
    public BNode smallLeftRotation(BNode root) {
        BNode newRoot = root.getRightChild();
        root.setRightChild(newRoot.getLeftChild());
        newRoot.setLeftChild(root);
        root.setHeight(this.getMaxChildHeight(root.getLeftChild(), root.getRightChild()) + 1);
        newRoot.setHeight(this.getMaxChildHeight(newRoot.getLeftChild(), newRoot.getRightChild()) + 1);
        return newRoot;
    }

    @Override
    public BNode smallRightRotation(BNode root) {
        BNode newRoot = root.getLeftChild();
        root.setLeftChild(newRoot.getRightChild());
        newRoot.setRightChild(root);
        root.setHeight(this.getMaxChildHeight(root.getLeftChild(), root.getRightChild()) + 1);
        newRoot.setHeight(this.getMaxChildHeight(newRoot.getLeftChild(), newRoot.getRightChild()) + 1);
        return newRoot;
    }

    @Override
    public BNode bigLeftRotation(BNode root) {
        root.setRightChild(smallRightRotation(root.getRightChild()));
        return this.smallLeftRotation(root);
    }

    @Override
    public BNode bigRightRotation(BNode root) {
        root.setLeftChild(smallLeftRotation(root.getLeftChild()));
        return this.smallRightRotation(root);
    }

    @Override
    public void reBalance(BNode tree) {

    }

    private int getMaxChildHeight(BNode leftChild, BNode rightChild) {
        return Math.max(
                leftChild != null ? leftChild.getHeight() : -1,
                rightChild != null ? rightChild.getHeight() : -1);
    }
}
