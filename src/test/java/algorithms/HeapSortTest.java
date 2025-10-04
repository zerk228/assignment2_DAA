package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @Test
    void handlesEmptyArray() {
        int[] arr = {};
        HeapSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void handlesSingleElement() {
        int[] arr = {42};
        HeapSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void handlesDuplicates() {
        int[] arr = {5, 1, 5, 2, 5, 3, 5};
        int[] expected = arr.clone();
        Arrays.sort(expected);
        HeapSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(expected, arr);
    }

    @Test
    void handlesAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] expected = arr.clone();
        HeapSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(expected, arr);
    }

    @Test
    void handlesReverseSortedArray() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3};
        int[] expected = arr.clone();
        Arrays.sort(expected);
        HeapSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(expected, arr);
    }

    @Test
    void sortsRandomArray() {
        Random rnd = new Random(42);
        int[] arr = rnd.ints(1000, -1000, 1000).toArray();
        int[] expected = arr.clone();
        Arrays.sort(expected);
        HeapSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(expected, arr);
    }

    @Test
    void sortsLargeArray() {
        Random rnd = new Random(123);
        int[] arr = rnd.ints(100_000, -1000, 1000).toArray();
        int[] expected = arr.clone();
        Arrays.sort(expected);
        HeapSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(expected, arr);
    }
}
