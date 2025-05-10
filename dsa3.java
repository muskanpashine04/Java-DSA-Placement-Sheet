import java.util.Arrays;

public class KthMinMaxSimple {

    public static void findKthMinMax(int[] arr, int k) {
        if (k > arr.length || k <= 0) {
            System.out.println("Invalid value of k.");
            return;
        }
        Arrays.sort(arr);
        int kthMin = arr[k - 1];
        int kthMax = arr[arr.length - k];
        System.out.println(k + "th minimum element: " + kthMin);
        System.out.println(k + "th maximum element: " + kthMax);
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        findKthMinMax(arr, k);
        // Output:
        // 3th minimum element: 7
        // 3th maximum element: 15

        int[] arr2 = {1, 4, 2, 5, 3};
        int k2 = 2;
        findKthMinMax(arr2, k2);
        // Output:
        // 2th minimum element: 2
        // 2th maximum element: 4
    }
}
