public class CheckSortedRotated {

    public static boolean isSortedAndRotated(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true; // Empty or single-element array is considered sorted and rotated
        }

        int n = arr.length;
        int rotations = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) { // Check for a point where the order breaks (potential rotation point)
                rotations++;
            }
        }

        return rotations <= 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, 1, 2};
        System.out.println("Is [3, 4, 5, 1, 2] sorted and rotated? " + isSortedAndRotated(arr1)); // Output: true

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Is [1, 2, 3, 4, 5] sorted and rotated? " + isSortedAndRotated(arr2)); // Output: true

        int[] arr3 = {5, 1, 2, 3, 4};
        System.out.println("Is [5, 1, 2, 3, 4] sorted and rotated? " + isSortedAndRotated(arr3)); // Output: true

        int[] arr4 = {1, 3, 2};
        System.out.println("Is [1, 3, 2] sorted and rotated? " + isSortedAndRotated(arr4)); // Output: false

        int[] arr5 = {3, 2, 1};
        System.out.println("Is [3, 2, 1] sorted and rotated? " + isSortedAndRotated(arr5)); // Output: false

        int[] arr6 = {10, 20, 5, 6, 8};
        System.out.println("Is [10, 20, 5, 6, 8] sorted and rotated? " + isSortedAndRotated(arr6)); // Output: false

        int[] arr7 = {1};
        System.out.println("Is [1] sorted and rotated? " + isSortedAndRotated(arr7)); // Output: true

        int[] arr8 = {};
        System.out.println("Is [] sorted and rotated? " + isSortedAndRotated(arr8)); // Output: true
    }
}
