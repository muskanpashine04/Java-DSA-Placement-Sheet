Q2 Reverse an array in place

public class ReverseArray {
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            // Swap arr[start] and arr[end]
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("Original array: ");
        printArray(arr); // Output: Original array: 1 2 3 4 5
        reverseArray(arr);
        System.out.print("Reversed array: ");
        printArray(arr); // Output: Reversed array: 5 4 3 2 1

        int[] arr2 = {10, 20, 30};
        System.out.print("Original array: ");
        printArray(arr2); // Output: Original array: 10 20 30
        reverseArray(arr2);
        System.out.print("Reversed array: ");
        printArray(arr2); // Output: Reversed array: 30 20 10
    }
}
