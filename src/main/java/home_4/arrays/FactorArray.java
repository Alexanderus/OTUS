package home_4.arrays;

import java.util.Optional;

public class FactorArray<T> implements Array<T> {
    private T[] array;
    private int factor;
    private int size;

    public FactorArray() {
        this.factor = 2;
        array = (T[]) new Object[8];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void append(T item) {
        if (size() == array.length) {
            resize();
        }
        array[size] = item;
        size++;

    }

    private void resize() {
        T[] newArray = (T[]) new Object[size() * factor + 1];
        if (size() >= 0) System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }

    @Override
    public T get(int nr) {
        if (nr >= array.length) {
            throw new RuntimeException("Указан неверный индекс массива.");
        }
        return array[nr];
    }

    @Override
    public void insert(T item, int nr) {
        if (nr <= size()) {
            int newCapacity = array.length;
            if (size() == array.length) {
                newCapacity = array.length * factor + 1;
            }
            T[] newArray = (T[]) new Object[newCapacity];

            System.arraycopy(array, 0, newArray, 0, nr);
            newArray[nr] = item;
            if (nr < size()) {
                System.arraycopy(array, nr, newArray, nr + 1, size() - nr);
            }
            array = newArray;
            size++;
        }
    }

    @Override
    public void remove(T item) {
        for (int i= 0; i < size; i++) {
            if (array[i].equals(item)) {
                deleteItem(i);
                break;
            }
        }
    }

    private void deleteItem(int nr) {
        T[] newArray = (T[]) new Object[array.length];
        System.arraycopy(array, 0, newArray, 0, nr);
        if (nr < size) {
            System.arraycopy(array, nr + 1, newArray, nr, size - nr - 1);
        }
        array = newArray;
        size--;
    }

    @Override
    public T remove(int nr) {
        if (nr >= size || nr < 0) {
            throw new RuntimeException("Указан неверный индекс массива.");
        }
        T item = array[nr];
        deleteItem(nr);
        return item;
    }

    @Override
    public String toString() {
        return "FactorArray";
    }
}
