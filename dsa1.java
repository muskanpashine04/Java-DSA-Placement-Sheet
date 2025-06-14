Q1   Find the maximum and minimum element in an array.
public class FindMinMax {
    public static void findMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Minimum element: " + min);
        System.out.println("Maximum element: " + max);
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 88, 3, 10};
        findMinMax(arr); // Output: Minimum element: 3, Maximum element: 88

        int[] emptyArr = {};
        findMinMax(emptyArr); // Output: Array is empty.

        int[] singleElementArr = {7};
        findMinMax(singleElementArr); // Output: Minimum element: 7, Maximum element: 7
    }
}
