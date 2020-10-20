package home_6;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

//        checkCountSorting();
//        checkRadixSort();
//        checkMergeSort();

    }

    public static void checkCountSorting() {
        int[] rawArray = NumberGenerator.generateArray(1_000_000_000, 65536);

        long startTime = System.currentTimeMillis();
        int[] sorted = new CountingSort().sort(rawArray);
        long finishTime = System.currentTimeMillis();
        System.out.println(String.format("Время работы сортировки подсчетом %s мс.", finishTime - startTime));
    }

    public static void checkRadixSort() {
        int[] rawArray = NumberGenerator.generateArray(1_000_000_000, 65536);

        long startTime = System.currentTimeMillis();
        int[] sorted = new RadixSort().sort(rawArray);
        long finishTime = System.currentTimeMillis();
        System.out.println(String.format("Время работы поразрядной сортировки %s мс.", finishTime - startTime));
    }

    public static void checkMergeSort() {
        String pathToTestData = "hw6.in";

//        NumberGenerator.generateArrayToFile(pathToTestData, 1_000_000_000);

        MergeSortingManager mergeSortingManager = new MergeSortingManager();
        long startTime = System.currentTimeMillis();
        mergeSortingManager.sortLargeFile(pathToTestData, 2, 1000);
        long finishTime = System.currentTimeMillis();
        System.out.println(String.format("Время работы поразрядной сортировки %s мс.", finishTime - startTime));
    }

}
