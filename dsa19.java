Q 19. Merge two sorted arrays without using extra space

class Solution {
    /**
     * Merges two sorted arrays nums1 and nums2 into nums1 without using extra space.
     * Assumes nums1 has enough space to hold all elements from nums2.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Start from the end of both arrays and the end of the merged portion in nums1
        int i = m - 1;       // Index for the last element of the initial part of nums1
        int j = n - 1;       // Index for the last element of nums2
        int k = m + n - 1;   // Index for the last position in the merged nums1

        // Compare elements from the end of both arrays and place the larger one
        // at the end of nums1
        while (j >= 0) {
            // If there are still elements in nums1 AND the current element in nums1
            // is greater than the current element in nums2
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i]; // Place the larger element from nums1
                i--;
            } else {
                nums1[k] = nums2[j]; // Otherwise, place the element from nums2
                j--;
            }
            k--; // Move to the next position in the merged nums1 (towards the beginning)
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3, 0, 0, 0}; // nums1 with enough space at the end
        int m = 3;                         // Number of elements in the initial part of nums1
        int[] nums2 = {2, 5, 6};
        int n = 3;

        solution.merge(nums1, m, nums2, n);

        System.out.print("Merged array: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println(); // Output: Merged array: 1 2 2 3 5 6
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
  class Solution {
    /**
     * Merges two sorted arrays nums1 and nums2 into nums1 without using extra space.
     * Assumes nums1 has enough space.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;   // Pointer for nums1
        int j = n - 1;   // Pointer for nums2
        int k = m + n - 1; // Pointer for the merged array (in nums1)

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);

        System.out.print("Merged array: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println(); // Output: Merged array: 1 2 2 3 5 6
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
