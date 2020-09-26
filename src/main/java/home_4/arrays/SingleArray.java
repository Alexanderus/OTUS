package home_4.arrays;

public class SingleArray<T> implements Array<T> {
    private T[] array;

    public SingleArray() {
        this.array = (T[]) new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public void append(T item) {
        resize();
        array[size() - 1] = item;
    }

    private void resize() {
        T[] newArray = (T[]) new Object[size() + 1];
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
        if (nr <= array.length) {
            T[] newArray = (T[]) new Object[array.length + 1];
            System.arraycopy(array, 0, newArray, 0, nr);
            newArray[nr] = item;
            if (nr < array.length) {
                System.arraycopy(array, nr, newArray, nr + 1, array.length - nr);
            }
            array = newArray;
        }
    }

    @Override
    public void remove(T item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
                deleteItem(i);
                break;
            }
        }
    }

    private void deleteItem(int nr) {
        T[] newArray = (T[]) new Object[array.length];
        System.arraycopy(array, 0, newArray, 0, nr);
        if (nr < array.length) {
            System.arraycopy(array, nr + 1, newArray, nr, array.length - nr - 1);
        }
        array = newArray;
    }

    @Override
    public T remove(int nr) {
        if (nr >= array.length || nr < 0) {
            throw new RuntimeException("Указан неверный индекс массива.");
        }
        T item = array[nr];
        deleteItem(nr);
        return item;
    }

    @Override
    public String toString() {
        return "SingleArray";
    }
}
