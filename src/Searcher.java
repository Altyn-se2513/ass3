public class Searcher {

    /**
     Linear Search - O(n) worst case complexity
     Sequentially checks each element until target is found

     param arr array to search in (can be unsorted)
     param target value to find
     return index of target if found, -1 if not found
     */
    public int search(int[] arr, int target) {
        // Edge case: null or empty array
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // If current element matches target, return its index
            if (arr[i] == target) {
                return i;
            }
        }

        // Target not found in the array
        return -1;
    }
}