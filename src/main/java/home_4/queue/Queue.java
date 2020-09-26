package home_4.queue;

public interface Queue<T> {
    void enqueue(int priority, T item);

    int size();

    T dequeue();
}
