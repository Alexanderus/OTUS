package home_4;

import home_4.arrays.*;

import java.util.Optional;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        Array<Integer> singleArray = new SingleArray<Integer>();
        Array<Integer> vectorArray = new VectorArray<Integer>(100);
        Array<Integer> factorArray = new FactorArray<Integer>();
        Array<Integer> matrixArray = new MatrixArray<>();
        Array<Integer> arrayList = new ArrayListWrapper<>();

//        PriorityQueue priorityQueue = new PriorityQueue();
//        priorityQueue.add()

        int append = 30_000_000;
        int insert = 1_000_000;
        int removeByIndex = 1000_000;
        int removeByValue = 200_000;

//        testAppend(singleArray, append);
//        testInsert(singleArray, insert);
//        testRemoveByIndex(arrayList, removeByIndex);
//        testRemoveByValue(arrayList, removeByValue);
//        testMatrixArray(matrixArray);
    }

    private static void prepareArray(Array<Integer> array, int items) {
        for (int i = 0; i < items + 10; i++) {
            array.append(i);
        }
    }

    public static void testAppend(Array<Integer> array, int total) {
        prepareArray(array, total);

        long start = System.currentTimeMillis();
        for (int j = 0; j < total; j++) {
            array.append(j);
        }

        long finish = System.currentTimeMillis() - start;

        System.out.println(total + " " + array + " " + finish);
    }

    public static void testInsert(Array<Integer> array, int total) {
        prepareArray(array, total);

        long start = System.currentTimeMillis();
        for (int j = 0; j < total; j++) {
            array.insert(15, 15);
        }

        long finish = System.currentTimeMillis() - start;

        System.out.println(total + " " + array + " " + finish);
    }

    public static void testRemoveByIndex(Array<Integer> array, int total) {
        prepareArray(array, total);

        long start = System.currentTimeMillis();
        for (int j = 0; j < total; j++) {
            array.remove(3);
        }

        long finish = System.currentTimeMillis() - start;

        System.out.println(total + " " + array + " " + finish);

    }

    public static void testRemoveByValue(Array<Integer> array, int total) {
        prepareArray(array, total);

        long start = System.currentTimeMillis();
        for (Integer j = 0; j < total; j++) {
            array.remove(j);
        }

        long finish = System.currentTimeMillis() - start;

        System.out.println(total + " " + array + " " + finish);

    }

//    public static void testMatrixArray(Array<Integer> array) {
//        prepareArray(array, 10);
//        for(int i = 0; i < 35; i++) {
//            array.insert(i*120, i);
//        }
//        System.out.println(array.size());
//    }
}
