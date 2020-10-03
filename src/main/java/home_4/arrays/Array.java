package home_4.arrays;

public interface Array<T> {
    int size();

    boolean isEmpty();

    void append(T item);

    T get(int nr);

    void insert(T item, int nr);

    void remove(T item);

    T remove(int nr);
}
