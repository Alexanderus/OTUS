package home_4.queue;

import home_4.queue.mylist.MyLinkedList;

public class PriorityQueue<T> implements Queue<T> {
    private int size;
    private int maxPriority;
    private MyLinkedList<T>[] listByPriority;
    private int defaultPriority = 0;

    public PriorityQueue() {
        this(3);
    }

    public PriorityQueue(int maxPriority) {
        this.maxPriority = maxPriority;
        this.listByPriority = new MyLinkedList[maxPriority];
    }

    @Override
    public void enqueue(int priority, T item) {
        if (!(maxPriority < priority)) {
            if (listByPriority[priority] == null) {
                listByPriority[priority] = new MyLinkedList<>();
            }
            listByPriority[priority].add(item);
            size++;
        }
    }

    public void enqueue(T item) {
        this.enqueue(defaultPriority, item);
    }

    @Override
    public T dequeue() {
        for (int i = 0; i < listByPriority.length; i++) {
            if (listByPriority[i] != null && listByPriority[i].size() > 0) {
                size--;
                return listByPriority[i].get();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
