package home_6;

public class CountingSort {

    public int[] sort(int[] array) {
        int maxValue = max(array);

        int[] numCounts = new int[maxValue + 1];

        for(int n: array) {
            numCounts[n] ++;
        }

        int[] sorted = new int[array.length];
        int index = 0;

        for (int i = 0; i < numCounts.length; i++) {
            int count = numCounts[i];

            for (int j = 0; j < count; j++) {
                sorted[index] = i;
                index ++;
            }
        }
        return sorted;
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
