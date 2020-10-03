package home_5;

import testsys.InData;

import java.util.Optional;
import java.util.function.Function;

public class HeapSort {

    public Function<InData, Optional<int[]>> sort = x -> {
        String rawData = x.getNext();
        String[] incomingData = rawData.split("\\r?\\n");

        Integer length = Integer.valueOf(incomingData[0]);
        String[] stringArray = incomingData[1].split(" ");

        int[] array = new int[stringArray.length];
        for(int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }
        long startTime = System.currentTimeMillis();
        int[] rawResult = this.sort(array);
        long finishTime = System.currentTimeMillis();

        System.out.println(String.format("Сортировка кучей. Колличество элементов %s.", length));
        System.out.println(String.format("Номер теста %s. Время выполнения: %s миллисекунд.\n"
                , x.getTestNumber(), finishTime - startTime));
        return Optional.empty();
    };

    public int[] sort(int[] array) {
        int len = array.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(array, len, i);
        }

        for (int i = len - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
        return array;
    }

    private void heapify(int[] array, int len, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < len && array[largest] < array[left]) {
            largest = left;
        }

        if (right < len && array[largest] < array[right]) {
            largest = right;
        }

        if (largest != root) {
            int temp = array[root];
            array[root] = array[largest];
            array[largest] = temp;
            heapify(array, len, largest);
        }
    }
}
