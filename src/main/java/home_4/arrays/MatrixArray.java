package home_4.arrays;

public class MatrixArray<T> implements Array<T> {
    private Array<Array<T>> box;
    private int size;
    private int line;

    public MatrixArray() {
        box = new FactorArray<>();
        size = 0;
        line = 10;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void append(T item) {
        if (size == box.size() * line) {
            box.append(new VectorArray<>(line));
        }
        box.get(size / line).append(item);
        size++;
    }

    @Override
    public T get(int nr) {
        return box.get(nr / line).get(nr % line);
    }

    @Override
    public void insert(T item, int nr) {
        if (nr == size) {
            this.append(item);
        }
        if (nr < size()) {

            int positionToReplace = nr % line;
            if (nr / line < size / line) {
                item = insertIntoMiddleArray(nr / line, nr % line, item);
                positionToReplace = 0;
            }
            if (size % line == 0) {
                this.append(item);
            } else {
                T lastArrayItem = box.get(size / line).remove(size % line - 1);
                box.get(size / line).insert(item, positionToReplace);
                this.append(lastArrayItem);
            }
        }
    }

    private T insertIntoMiddleArray(int arrayNumber, int position, T item) {
        T itemToTopArray = box.get(arrayNumber).remove(line - 1);
        T nextItemToTopArray = null;
        box.get(arrayNumber).insert(item, position);
        arrayNumber++;
        while (arrayNumber < size / line) {
            nextItemToTopArray = box.get(arrayNumber).remove(line - 1);
            box.get(arrayNumber).insert(itemToTopArray, 0);
            itemToTopArray = nextItemToTopArray;
            arrayNumber++;
        }
        return itemToTopArray;
    }

    @Override
    public void remove(T item) {
        for (int i = 0; i < size; i++) {
            if (box.get(i / line).get(i % line).equals(item)) {
                deleteItem(i);
                break;
            }
        }
    }

    private void deleteItem(int nr) {
        int topArray = size / line - 1;
        int goalArray = nr / line;

        box.get(goalArray).remove(nr % line);

        T tempItem;
        while (goalArray < topArray) {
            tempItem = box.get(goalArray + 1).remove(0);
            box.get(goalArray).append(tempItem);
            goalArray += 1;
        }
        this.size--;
    }

    @Override
    public T remove(int nr) {
        if (nr >= size || nr < 0) {
            throw new RuntimeException("Указан неверный индекс массива.");
        }
        T item = box.get(nr / line).get(nr % line);
        deleteItem(nr);
        return item;
    }

    @Override
    public String toString() {
        return "MatrixArray";
    }
}
