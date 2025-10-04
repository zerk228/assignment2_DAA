package cli;

import algorithms.HeapSort;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) throws IOException {
        int[] sizes = args.length > 0
                ? Arrays.stream(args).mapToInt(Integer::parseInt).toArray()
                : new int[]{100, 1000, 5000, 10000, 50000};

        try (FileWriter out = new FileWriter("results_heapsort.csv")) {
            out.write("n;runtime_ns;comparisons;swaps;allocations\n");

            for (int n : sizes) {
                int[] arr = new Random(42).ints(n, -10000, 10000).toArray();
                PerformanceTracker t = new PerformanceTracker();

                long start = System.nanoTime();
                HeapSort.sort(arr, t);
                long end = System.nanoTime();
                t.runtimeNanos = end - start;

                out.write(String.format("%d;%d;%d;%d;%d%n",
                        n, t.runtimeNanos, t.comparisons, t.swaps, t.allocations));

                System.out.printf("n=%d | time=%.3f ms | cmp=%d | swaps=%d%n",
                        n, t.runtimeNanos / 1_000_000.0, t.comparisons, t.swaps);
            }
        }

        System.out.println("\nResults saved → results_heapsort.csv");
    }
}
