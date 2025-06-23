
    public class Sort012 {
    public static void sort012(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap arr[low] and arr[mid]
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    // Swap arr[mid] and arr[high]
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
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
        int[] arr = {0, 1, 2, 0, 1, 2, 1, 0};
        System.out.print("Original array: ");
        printArray(arr); // Output: Original array: 0 1 2 0 1 2 1 0
        sort012(arr);
        System.out.print("Sorted array: ");
        printArray(arr); // Output: Sorted array: 0 0 0 1 1 1 2 2

        int[] arr2 = {1, 1, 0, 2, 2, 0};
        System.out.print("Original array: ");
        printArray(arr2); // Output: Original array: 1 1 0 2 2 0
        sort012(arr2);
        System.out.print("Sorted array: ");
        printArray(arr2); // Output: Sorted array: 0 0 1 1 2 2
    }
}
