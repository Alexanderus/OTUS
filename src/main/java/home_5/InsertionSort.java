package home_5;

import testsys.InData;

import java.util.Optional;
import java.util.function.Function;

public class InsertionSort {

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

        System.out.println(String.format("Сортировка вставкой. Колличество элементов %s.", length));
        System.out.println(String.format("Номер теста %s. Время выполнения: %s миллисекунд.\n"
                , x.getTestNumber(), finishTime - startTime));
        return Optional.empty();
    };

    public int[] sort(int[] array) {
        int item;
        for (int j, i = 1; i < array.length; i++) {
            item = array[i];
            j = i - 1;
            while (0 <= j && item < array[j]) {
                array[j + 1] = array[j];
                j -= 1;
            }

            array[j + 1] = item;
        }
        return array;
    }
}
