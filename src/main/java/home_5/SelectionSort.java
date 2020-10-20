package home_5;

import testsys.InData;

import java.util.Optional;
import java.util.function.Function;

public class SelectionSort {

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

        System.out.println(String.format("Сортировка выбором. Колличество элементов %s.", length));
        System.out.println(String.format("Номер теста %s. Время выполнения: %s миллисекунд.\n"
                , x.getTestNumber(), finishTime - startTime));
        return Optional.empty();
    };

    public int[] sort(int[] array) {
        int tempIndex;
        int tempItem;
        for (int i = 0; i < array.length - 1; i++) {
            tempIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[tempIndex]) {
                    tempIndex = j;
                }
            }
            if (tempIndex != i) {
                tempItem = array[i];
                array[i] = array[tempIndex];
                array[tempIndex] = tempItem;
            }
        }
        return array;
    }
}
