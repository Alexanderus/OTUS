package home_5;

import testsys.InData;

import java.util.Optional;
import java.util.function.Function;

public class ShellSort {

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

        System.out.println(String.format("Сортировка Шелла. Колличество элементов %s.", length));
        System.out.println(String.format("Номер теста %s. Время выполнения: %s миллисекунд.\n"
                , x.getTestNumber(), finishTime - startTime));
        return Optional.empty();
    };

    public int[] sort(int[] array) {
//        int step = 2;
//        int step = 4;
        int step = 8;
        int gap = array.length / step;
        int temp;
        int j;
        for (; gap > 0; gap /= step) {
            for (int i = gap; i < array.length; i++) {
                for (j = i - gap; j >= 0 && array[j] > array[j + gap]; j -= gap) {
                    temp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = temp;
                }
            }
        }
        return array;
    }
}
