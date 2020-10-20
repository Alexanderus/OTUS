package home_6;

public class HeapSort {

    public void sort(int[] array) {
        int len = array.length;

        for(int i = len/2 - 1; i >= 0; i--) {
            heapify(array, len, i);
        }

        for (int i = len - 1; i >=0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            heapify(array, i, 0);
        }
    }

    public void heapify(int[] arr, int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[max]) {
            max = left;
        }

        if (right < n && arr[right] > arr[max]) {
            max = right;
        }

        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

            heapify(arr, n, max);
        }
    }
}
