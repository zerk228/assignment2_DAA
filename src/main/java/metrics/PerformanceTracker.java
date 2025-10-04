package metrics;

public class PerformanceTracker {
    public long comparisons = 0;
    public long swaps = 0;
    public long allocations = 0;
    public long runtimeNanos = 0;

    public void reset() {
        comparisons = swaps = allocations = runtimeNanos = 0;
    }
}
