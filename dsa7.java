public class RotateArray {

    public static void rotateByOne(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Nothing to rotate for null or single-element array
        }

        int n = arr.length;
        int temp = arr[n - 1]; // Store the last element

        // Shift all elements to the right
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        // Place the last element at the beginning
        arr[0] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Original array: ");
        printArray(arr1);

        rotateByOne(arr1);
        System.out.println("Rotated array: ");
        printArray(arr1); // Output: 5 1 2 3 4

        int[] arr2 = {10, 20, 30};
        System.out.println("\nOriginal array: ");
        printArray(arr2);

        rotateByOne(arr2);
        System.out.println("Rotated array: ");
        printArray(arr2); // Output: 30 10 20

        int[] arr3 = {5};
        System.out.println("\nOriginal array: ");
        printArray(arr3);

        rotateByOne(arr3);
        System.out.println("Rotated array: ");
        printArray(arr3); // Output: 5

        int[] arr4 = {};
        System.out.println("\nOriginal array: ");
        printArray(arr4);

        rotateByOne(arr4);
        System.out.println("Rotated array: ");
        printArray(arr4); // Output: (empty array)
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
