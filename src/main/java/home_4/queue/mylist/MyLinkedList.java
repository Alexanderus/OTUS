package home_4.queue.mylist;

public class MyLinkedList<T> implements MyList<T> {
    private int size;
    private MyNode<T> first;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (first == null) {
            first = new MyNode<>(item, null);
        } else {
            MyNode<T> node = first;
            while (node.hasNext()) {
                node = node.getNext();
            }
            node.setNext(new MyNode<>(item, null));
        }
        size++;
    }

    public T get() {
        MyNode<T> myNode = first;
        first = first.getNext();
        size--;
        return myNode.getValue();
    }
}
