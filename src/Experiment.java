public class Experiment {

    // Create instances of Sorter and Searcher for algorithm execution
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    /**
     * Measures execution time of sorting algorithms
     * Uses System.nanoTime() for precise measurement (nanosecond precision)
     *
     * param arr array to sort (original array is not modified, a copy is used)
     * param type "basic" for Bubble Sort, otherwise for Quick Sort
     * return execution time in nanoseconds
     */
    public long measureSortTime(int[] arr, String type) {
        // Create a copy to preserve original array for other tests
        int[] copy = arr.clone();

        // Record start time before sorting
        long start = System.nanoTime();

        // Execute selected sorting algorithm
        if (type.equals("basic")) {
            sorter.basicSort(copy);     // Bubble Sort (O(n²))
        } else {
            sorter.advancedSort(copy);   // Quick Sort (O(n log n))
        }

        // Record end time after sorting
        long end = System.nanoTime();

        // Return the time difference (execution time)
        return end - start;
    }

    /**
     * Measures execution time of linear search algorithm
     *
     * param arr array to search in
     * param target value to find
     * return execution time in nanoseconds
     */
    public long measureSearchTime(int[] arr, int target) {
        // Record start time
        long start = System.nanoTime();

        // Execute linear search
        searcher.search(arr, target);

        // Record end time
        long end = System.nanoTime();

        // Return execution time
        return end - start;
    }

    /**
     * Runs complete experiment with different array sizes
     * Tests both sorting and searching algorithms on:
     * - Different array sizes (10, 100, 1000 elements)
     * - Different data types (random arrays, pre-sorted arrays)
     */
    public void runAllExperiments() {
        // Test array sizes: small, medium, large
        int[] sizes = {10, 100, 1000};

        // Loop through each array size
        for (int size : sizes) {

            System.out.println("\n==============================");
            System.out.println("ARRAY SIZE: " + size);
            System.out.println("==============================");

            // Generate random array for this test iteration
            int[] randomArray = sorter.generateRandomArray(size);

            // Create sorted array by sorting the random array
            int[] sortedArray = randomArray.clone();
            sorter.basicSort(sortedArray);  // Use Bubble Sort to create sorted copy

            // =============================================
            // PART 1: SORTING PERFORMANCE ON RANDOM ARRAY
            // =============================================
            long bubbleRandom = measureSortTime(randomArray, "basic");
            long quickRandom = measureSortTime(randomArray, "advanced");

            System.out.println("\n--- RANDOM ARRAY ---");
            System.out.println("Bubble Sort time: " + bubbleRandom + " ns");
            System.out.println("Quick Sort time: " + quickRandom + " ns");

            // =============================================
            // PART 2: SORTING PERFORMANCE ON SORTED ARRAY
            // =============================================
            long bubbleSorted = measureSortTime(sortedArray, "basic");
            long quickSorted = measureSortTime(sortedArray, "advanced");

            System.out.println("\n--- SORTED ARRAY ---");
            System.out.println("Bubble Sort time: " + bubbleSorted + " ns");
            System.out.println("Quick Sort time: " + quickSorted + " ns");

            // =============================================
            // PART 3: SEARCHING PERFORMANCE
            // Target = middle element of random array
            // =============================================
            int target = randomArray[size / 2];
            long searchTime = measureSearchTime(randomArray, target);

            System.out.println("\n--- SEARCH ---");
            System.out.println("Linear Search time: " + searchTime + " ns");
        }
    }
}