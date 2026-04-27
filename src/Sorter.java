import java.util.Random;

public class Sorter {

    /**
     Bubble Sort - O(n²) worst case complexity
     Repeatedly swaps adjacent elements if they are in wrong order
     param arr array to be sorted
     */
    public void basicSort(int[] arr) {
        // Edge case: null or empty array check
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        // Outer loop: number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop: compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // If elements are in wrong order, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     Quick Sort - O(n log n) average case complexity
     Divides array around a pivot and recursively sorts partitions
     param arr array to be sorted
     */
    public void advancedSort(int[] arr) {
        // Edge case: null or empty array check
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     Recursive Quick Sort implementation
     param arr array to sort
     param low starting index
     param high ending index
     */
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find partition index (pivot position)
            int pi = partition(arr, low, high);

            // Recursively sort left and right subarrays
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     Partition function: places pivot in correct position
     all elements smaller than pivot go to left, larger to right
     param arr array to partition
     param low starting index
     param high ending index (pivot element)
     return final position of pivot
     */
    private int partition(int[] arr, int low, int high) {
        // Choose last element as pivot
        int pivot = arr[high];
        int i = low - 1; // Index of smaller element

        // Traverse through all elements
        for (int j = low; j < high; j++) {
            // If current element is smaller than pivot
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return pivot position
    }

    /**
     Prints array elements to console
     param arr array to print
     */
    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     Generates array with random integers
     param size desired array size
     return array filled with random numbers (0-9999)
     */
    public int[] generateRandomArray(int size) {
        // Edge case: invalid size
        if (size <= 0) {
            return new int[0];
        }

        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }

        return arr;
    }
}