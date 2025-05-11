public class KadanesAlgorithm {

    public static int maxSubarraySum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0; // Or throw an exception, depending on the requirement for an empty array
        }

        int maxSoFar = arr[0];
        int currentMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // Either start a new subarray at the current element
            // or extend the previous subarray
            currentMax = Math.max(arr[i], currentMax + arr[i]);

            // Update the overall maximum sum found so far
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum of [-2, 1, -3, 4, -1, 2, 1, -5, 4]: " + maxSubarraySum(arr1)); // Output: 6

        int[] arr2 = {5, 4, -1, 7, 8};
        System.out.println("Maximum subarray sum of [5, 4, -1, 7, 8]: " + maxSubarraySum(arr2)); // Output: 23

        int[] arr3 = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum subarray sum of [-2, -3, 4, -1, -2, 1, 5, -3]: " + maxSubarraySum(arr3)); // Output: 7

        int[] arr4 = {-1, -2, -3, -4};
        System.out.println("Maximum subarray sum of [-1, -2, -3, -4]: " + maxSubarraySum(arr4)); // Output: -1

        int[] arr5 = {5};
        System.out.println("Maximum subarray sum of [5]: " + maxSubarraySum(arr5)); // Output: 5

        int[] arr6 = {};
        System.out.println("Maximum subarray sum of []: " + maxSubarraySum(arr6)); // Output: 0
    }
}
