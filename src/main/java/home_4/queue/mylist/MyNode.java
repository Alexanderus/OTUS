package home_4.queue.mylist;

public class MyNode<T> {
    private T value;
    private MyNode<T> next;

    public MyNode(T value, MyNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public MyNode<T> getNext() {
        return next;
    }

    public void setNext(MyNode<T> node) {
        next = node;
    }

    public T getValue() {
        return value;
    }
}
