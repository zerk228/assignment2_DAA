package algorithms;

import metrics.PerformanceTracker;

public class HeapSort {

    // Public entry point
    public static void sort(int[] arr, PerformanceTracker t) {
        if (arr == null || arr.length < 2) return;
        int n = arr.length;
        buildHeap(arr, n, t); // bottom-up heapify O(n)

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i, t);        // Move max to end
            heapify(arr, i, 0, t);     // Restore heap property
        }
    }

    // Floyd bottom-up heap construction
    private static void buildHeap(int[] arr, int n, PerformanceTracker t) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, t);
        }
    }

    // Iterative heapify (no recursion)
    private static void heapify(int[] arr, int heapSize, int root, PerformanceTracker t) {
        while (true) {
            int largest = root;
            int left = 2 * root + 1;
            int right = 2 * root + 2;

            if (left < heapSize) {
                t.comparisons++;
                if (arr[left] > arr[largest]) largest = left;
            }

            if (right < heapSize) {
                t.comparisons++;
                if (arr[right] > arr[largest]) largest = right;
            }

            if (largest != root) {
                swap(arr, root, largest, t);
                root = largest;
            } else break;
        }
    }

    private static void swap(int[] arr, int i, int j, PerformanceTracker t) {
        if (i == j) return;
        t.swaps++;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
