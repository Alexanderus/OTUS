package home_4.arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayListWrapper<T> implements Array<T> {

    private List<T> array;

    public ArrayListWrapper() {
        this.array = new ArrayList<T>();
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void append(T item) {
        array.add(item);
    }

    @Override
    public T get(int nr) {
        if (nr >= array.size() || nr < 0) {
            throw new RuntimeException("Указан неверный индекс массива.");
        }
        return array.get(nr);
    }

    @Override
    public void insert(T item, int nr) {
        if (0 <= nr && nr < array.size()) {
            array.add(nr, item);
        }
    }

    @Override
    public void remove(T item) {
        array.remove(item);
    }

    @Override
    public T remove(int nr) {
        if (nr >= array.size() || nr < 0) {
            throw new RuntimeException("Указан неверный индекс массива.");
        }
        return array.remove(nr);
    }

    @Override
    public String toString() {
        return "ArrayListWrapper";
    }
}
