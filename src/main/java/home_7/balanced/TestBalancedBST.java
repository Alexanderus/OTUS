package home_7.balanced;

import home_6.NumberGenerator;
import home_7.simple.SimpleBST;

public class TestBalancedBST {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE/32);

//        int[] inputArray = new int[] {50, 25, 23, 20, 100, 88, 64, 55, 43, 90, 150, 40};
//        BalancedBST balancedBST = new BalancedBST();
//        for(int i: inputArray) {
//            balancedBST.insert(i);
//        }

//        for (int i: inputArray) {
//            balancedBST.remove(i);
//        }
//
//
//        System.out.println("test");



        testWithRandomValues();
//        testWithIncreasedValues();

    }

    public static void testWithRandomValues() {
        BalancedBST balancedBST = new BalancedBST();
        int n = Integer.MAX_VALUE / 32;
        int[] arr = NumberGenerator.generateArray(n, n);

        for (int i : arr) {
            balancedBST.insert(i);
        }

        long startSearchTime = System.currentTimeMillis();
        for (int i = 0; i < n / 10; i++) {
            balancedBST.search(arr[i]);
        }
        long finishSearchTime = System.currentTimeMillis();
        System.out.println(String.format("Время работы поиска n/10 чисел равно %s.", finishSearchTime - startSearchTime));

        long startRemoveTime = System.currentTimeMillis();
        for (int i = 0; i < n / 10; i++) {
            balancedBST.remove(arr[i]);
        }
        long finishRemoveTime = System.currentTimeMillis();
        System.out.println(String.format("Время работы удаления n/10 чисел равно %s.", finishRemoveTime - startRemoveTime));
    }

    public static void testWithIncreasedValues() {
        BalancedBST balancedBST = new BalancedBST();
        int n = Integer.MAX_VALUE/32;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i : arr) {
            balancedBST.insert(i);
        }

        long startSearchTime = System.currentTimeMillis();
        for (int i = n / 10; i >= 0; i--) {
            balancedBST.search(arr[i]);
        }
        long finishSearchTime = System.currentTimeMillis();
        System.out.println(String.format("Время работы поиска n/10 чисел равно %s.", finishSearchTime - startSearchTime));

        long startRemoveTime = System.currentTimeMillis();
        for (int i = n / 10; i >= 0; i--) {
            balancedBST.remove(arr[i]);
        }
        long finishRemoveTime = System.currentTimeMillis();
        System.out.println(String.format("Время работы удаления n/10 чисел равно %s.", finishRemoveTime - startRemoveTime));
    }
}
