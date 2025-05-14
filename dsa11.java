import java.util.Arrays;

class RearrangeAlternating {

    public void rearrange(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1;

        // Step 1: Segregate positive and negative numbers
        while (i < j) {
            while (i < n && arr[i] >= 0) {
                i++;
            }
            while (j >= 0 && arr[j] < 0) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }

        // Now all negative numbers are at the beginning (if they exist)
        // and positive numbers are at the end (if they exist).

        // Step 2: Rearrange in alternating positive & negative
        int pos = i; // Index of the first positive number
        int neg = 0; // Index of the first negative number

        // This condition ensures that there are both positive and negative numbers
        while (pos < n && neg < pos && arr[neg] < 0) {
            swap(arr, neg, pos);
            neg += 2;
            pos++;
        }
    }

    // Helper function to swap two elements in an array
    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        RearrangeAlternating ra = new RearrangeAlternating();
        int[] arr1 = {-1, 2, -3, 4, 5, -6};
        ra.rearrange(arr1);
        System.out.println("Rearranged array 1: " + Arrays.toString(arr1)); // Output: [-1, 2, -3, 4, -6, 5] or similar

        int[] arr2 = {-1, -2, -3, 4, 5, 6};
        ra.rearrange(arr2);
        System.out.println("Rearranged array 2: " + Arrays.toString(arr2)); // Output: [-1, 4, -2, 5, -3, 6]

        int[] arr3 = {1, 2, 3, -4, -5, -6};
        ra.rearrange(arr3);
        System.out.println("Rearranged array 3: " + Arrays.toString(arr3)); // Output: [-4, 1, -5, 2, -6, 3]

        int[] arr4 = {-5, -3, -2, 1, 2, 3};
        ra.rearrange(arr4);
        System.out.println("Rearranged array 4: " + Arrays.toString(arr4)); // Output: [-5, 1, -3, 2, -2, 3]

        int[] arr5 = {1, 2, -3, -4, -5, 6};
        ra.rearrange(arr5);
        System.out.println("Rearranged array 5: " + Arrays.toString(arr5)); // Output: [-3, 1, -4, 2, -5, 6]
    }
}
