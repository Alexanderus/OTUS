package home_7.simple;

import home_6.NumberGenerator;

public class TestSimpleBST {

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE/4);
//        testWithRandomValues();
//        testWithIncreasedValues();

        int[] inputArray = new int[] {50, 25, 23, 20, 100, 88, 64, 55, 43, 90, 150, 40};
        SimpleBST simpleBST = new SimpleBST();
        for(int i: inputArray) {
            simpleBST.insert(i);
        }

        simpleBST.remove(88);

        System.out.println("test");


    }

    public static void testWithRandomValues() {
        SimpleBST simpleBST = new SimpleBST();
        int n = Integer.MAX_VALUE/4;
        int[] arr = NumberGenerator.generateArray(n, n);

        for (int i: arr) {
            simpleBST.insert(i);
        }

        long startSearchTime = System.currentTimeMillis();
        for (int i = 0; i < n/10; i++) {
            simpleBST.search(arr[i]);
        }
        long finishSearchTime = System.currentTimeMillis();
        System.out.println(String.format("Время работы поиска n/10 чисел равно %s.", finishSearchTime - startSearchTime));

        long startRemoveTime = System.currentTimeMillis();
        for (int i = 0; i < n/10; i++) {
            simpleBST.remove(arr[i]);
        }
        long finishRemoveTime = System.currentTimeMillis();
        System.out.println(String.format("Время работы удаления n/10 чисел равно %s.", finishRemoveTime - startRemoveTime));
    }

    public static void testWithIncreasedValues() {
        SimpleBST simpleBST = new SimpleBST();
        int n = 12500; //Integer.MAX_VALUE/20;
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i: arr) {
            simpleBST.insert(i);
        }

        long startSearchTime = System.currentTimeMillis();
        for (int i = n/10; i >= 0; i--) {
            simpleBST.search(arr[i]);
        }
        long finishSearchTime = System.currentTimeMillis();
        System.out.println(String.format("Время работы поиска n/10 чисел равно %s.", finishSearchTime - startSearchTime));

        long startRemoveTime = System.currentTimeMillis();
        for (int i = n/10; i >= 0; i--) {
            simpleBST.remove(arr[i]);
        }
        long finishRemoveTime = System.currentTimeMillis();
        System.out.println(String.format("Время работы удаления n/10 чисел равно %s.", finishRemoveTime - startRemoveTime));
    }

}
