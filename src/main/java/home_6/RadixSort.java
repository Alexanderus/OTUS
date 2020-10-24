package home_6;

import java.util.Arrays;

public class RadixSort {

    public int[] sort(int[] array) {
        int[] countArray = new int[10];
        int[] sorted = new int[array.length];
        Arrays.fill(countArray, 0);

        int iterationNeeded = (int) Math.log10(max(array));
        for (int k = 0; k <= iterationNeeded; k++) {

            for (int i = 0; i < array.length; i++) {
                countArray[(array[i] / (int) Math.pow(10, k)) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                countArray[i] += countArray[i - 1];
            }

            for (int i = array.length - 1; i >= 0; i--) {
                sorted[countArray[(array[i] / (int) Math.pow(10, k)) % 10] - 1] = array[i];
                countArray[(array[i] / (int) Math.pow(10, k)) % 10]--;
            }
            System.arraycopy(sorted, 0, array, 0, sorted.length);
            Arrays.fill(sorted, 0);
            Arrays.fill(countArray, 0);
        }
        return array;
    }

    public int max(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
}
