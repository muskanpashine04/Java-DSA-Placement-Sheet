import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Finds the leaders in an array.
     * A leader is an element that is greater than all the elements to its right.
     * The rightmost element is always a leader.
     *
     * @param arr The input array of integers.
     * @return A list containing the leaders in the array.
     */
    public List<Integer> findLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int n = arr.length;

        if (n == 0) {
            return leaders; // Empty array has no leaders
        }

        // The rightmost element is always a leader
        leaders.add(arr[n - 1]);
        int maxRight = arr[n - 1];

        // Iterate from right to left (excluding the last element)
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxRight) {
                leaders.add(arr[i]);
                maxRight = arr[i];
            }
        }

        return leaders;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {16, 17, 4, 3, 5, 2};
        List<Integer> leaders1 = solution.findLeaders(arr1);
        System.out.println("Leaders in " + java.util.Arrays.toString(arr1) + ": " + leaders1); // Output: [2, 5, 17]

        int[] arr2 = {1, 2, 3, 4, 5};
        List<Integer> leaders2 = solution.findLeaders(arr2);
        System.out.println("Leaders in " + java.util.Arrays.toString(arr2) + ": " + leaders2); // Output: [5]

        int[] arr3 = {5, 4, 3, 2, 1};
        List<Integer> leaders3 = solution.findLeaders(arr3);
        System.out.println("Leaders in " + java.util.Arrays.toString(arr3) + ": " + leaders3); // Output: [1, 2, 3, 4, 5]

        int[] arr4 = {7, 1, 5, 2, 10};
        List<Integer> leaders4 = solution.findLeaders(arr4);
        System.out.println("Leaders in " + java.util.Arrays.toString(arr4) + ": " + leaders4); // Output: [10, 5, 7]

        int[] arr5 = {};
        List<Integer> leaders5 = solution.findLeaders(arr5);
        System.out.println("Leaders in " + java.util.Arrays.toString(arr5) + ": " + leaders5); // Output: []
    }
}
----------------------------------------------------------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.List;

class SolutionEasy {
    public List<Integer> findLeadersEasy(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int n = arr.length;

        if (n > 0) {
            int maxRight = arr[n - 1];
            leaders.add(maxRight);

            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] > maxRight) {
                    leaders.add(arr[i]);
                    maxRight = arr[i];
                }
            }
        }
        return leaders;
    }

    public static void main(String[] args) {
        SolutionEasy solution = new SolutionEasy();
        int[] arr = {16, 17, 4, 3, 5, 2};
        List<Integer> leaders = solution.findLeadersEasy(arr);
        System.out.println("Leaders: " + leaders); // Output: Leaders: [2, 5, 17]
    }
}
