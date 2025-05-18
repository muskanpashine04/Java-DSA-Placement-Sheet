import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubarrayWithGivenSum {

    /**
     * Finds a contiguous subarray in a given array that sums to a target value.
     * Uses the two-pointer/sliding window approach.
     *
     * @param arr   The input array of non-negative integers.
     * @param targetSum The target sum to find.
     * @return A list containing the starting and ending indices (1-based) of the subarray if found,
     * otherwise an empty list.
     */
    public static List<Integer> subarraySum(int[] arr, int targetSum) {
        int n = arr.length;
        int start = 0;
        int currentSum = 0;
        List<Integer> result = new ArrayList<>();

        for (int end = 0; end < n; end++) {
            currentSum += arr[end];

            while (currentSum > targetSum && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            if (currentSum == targetSum) {
                result.add(start + 1); // 1-based indexing
                result.add(end + 1);   // 1-based indexing
                return result;
            }
        }

        return result; // No subarray found
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 20, 3, 10, 5};
        int sum1 = 33;
        List<Integer> result1 = subarraySum(arr1, sum1);
        if (!result1.isEmpty()) {
            System.out.println("Subarray found from index " + result1.get(0) + " to " + result1.get(1));
        } else {
            System.out.println("No subarray found with sum " + sum1);
        }

        int[] arr2 = {1, 4, 0, 0, 3, 10, 5};
        int sum2 = 7;
        List<Integer> result2 = subarraySum(arr2, sum2);
        if (!result2.isEmpty()) {
            System.out.println("Subarray found from index " + result2.get(0) + " to " + result2.get(1));
        } else {
            System.out.println("No subarray found with sum " + sum2);
        }

        int[] arr3 = {1, 2, 3, 7, 5};
        int sum3 = 12;
        List<Integer> result3 = subarraySum(arr3, sum3);
        if (!result3.isEmpty()) {
            System.out.println("Subarray found from index " + result3.get(0) + " to " + result3.get(1));
        } else {
            System.out.println("No subarray found with sum " + sum3);
        }

        int[] arr4 = {1, 2, 3, 4, 5};
        int sum4 = 15;
        List<Integer> result4 = subarraySum(arr4, sum4);
        if (!result4.isEmpty()) {
            System.out.println("Subarray found from index " + result4.get(0) + " to " + result4.get(1));
        } else {
            System.out.println("No subarray found with sum " + sum4);
        }

        int[] arr5 = {1, 2, 3, 4, 5};
        int sum5 = 1;
        List<Integer> result5 = subarraySum(arr5, sum5);
        if (!result5.isEmpty()) {
            System.out.println("Subarray found from index " + result5.get(0) + " to " + result5.get(1));
        } else {
            System.out.println("No subarray found with sum " + sum5);
        }
    }
}
---------------------------------------------------------------------------------------------------------------------------------------------


import java.util.ArrayList;
import java.util.List;

class SubarrayWithGivenSumEasy {

    public static List<Integer> findSubarray(int[] arr, int targetSum) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += arr[j];
                if (currentSum == targetSum) {
                    List<Integer> result = new ArrayList<>();
                    result.add(i + 1); // 1-based start index
                    result.add(j + 1); // 1-based end index
                    return result;
                }
            }
        }
        return new ArrayList<>(); // No subarray found
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        int sum = 33;
        List<Integer> result = findSubarray(arr, sum);
        if (!result.isEmpty()) {
            System.out.println("Subarray found from index " + result.get(0) + " to " + result.get(1));
        } else {
            System.out.println("No subarray found with sum " + sum);
        }

        int[] arr2 = {1, 2, 3, 7, 5};
        int sum2 = 12;
        List<Integer> result2 = findSubarray(arr2, sum2);
        if (!result2.isEmpty()) {
            System.out.println("Subarray found from index " + result2.get(0) + " to " + result2.get(1));
        } else {
            System.out.println("No subarray found with sum " + sum2);
        }
    }
}
