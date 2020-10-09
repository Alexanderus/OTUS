package home_5;

import testsys.TestSystem;
import utils.TestDataPatches;

public class SortTesting {

    public static void main(String[] args) {
//        SelectionSort sort = new SelectionSort();
//        InsertionSort sort = new InsertionSort();
        HeapSort sort = new HeapSort();
//        ShellSort sort = new ShellSort();
        TestSystem<int[]> testSystem = new TestSystem<>();

        testSystem.loadTestData(TestDataPatches.SORTING_SORTED_TEST_DATA);
        testSystem.runTests(sort.sort);
//        testSystem.checkResults();


//        Sort sort = new ShellSort();
//        int[] toTest = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
//        toTest = sort.sort(toTest);
//        System.out.println(Arrays.toString(toTest));
    }
}
