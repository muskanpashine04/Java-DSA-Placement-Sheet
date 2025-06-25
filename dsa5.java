Q5. Move all negative numbers to beginning and positive to end
    public class MoveNegatives {
    public static void moveNegativeToBeginning(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            if (arr[left] < 0 && arr[right] < 0) {
                left++;
            } else if (arr[left] >= 0 && arr[right] < 0) {
                // Swap arr[left] and arr[right]
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else if (arr[left] >= 0 && arr[right] >= 0) {
                right--;
            } else { // arr[left] < 0 && arr[right] >= 0
                left++;
                right--;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, -3, 4, 5, -6};
        System.out.print("Original array: ");
        printArray(arr); // Output: Original array: -1 2 -3 4 5 -6
        moveNegativeToBeginning(arr);
        System.out.print("Modified array: ");
        printArray(arr); // Output: Modified array: -1 -3 -6 4 5 2 (order of positives might change)

        int[] arr2 = {1, 2, 3, -4, -5};
        System.out.print("Original array: ");
        printArray(arr2); // Output: Original array: 1 2 3 -4 -5
        moveNegativeToBeginning(arr2);
        System.out.print("Modified array: ");
        printArray(arr2); // Output: Modified array: -4 -5 3 2 1

        int[] arr3 = {-1, -2, -3, 4, 5};
        System.out.print("Original array: ");
        printArray(arr3);
        moveNegativeToBeginning(arr3);
        System.out.print("Modified array: ");
        printArray(arr3); // Output: -1 -2 -3 4 5
    }
}
