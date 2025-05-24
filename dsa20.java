class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int tempMax = Math.max(current, Math.max(maxSoFar * current, minSoFar * current));
            minSoFar = Math.min(current, Math.min(maxSoFar * current, minSoFar * current));

            maxSoFar = tempMax;

            result = Math.max(result, maxSoFar);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Maximum product of subarray: " + solution.maxProduct(nums1)); // Output: 6

        // Example 2
        int[] nums2 = {-2, 0, -1};
        System.out.println("Maximum product of subarray: " + solution.maxProduct(nums2)); // Output: 0

        // Example 3
        int[] nums3 = {-2, 3, -4};
        System.out.println("Maximum product of subarray: " + solution.maxProduct(nums3)); // Output: 24

        int[] nums4 = {-1, -2, -3, 0};
        System.out.println("Maximum product of subarray: " + solution.maxProduct(nums4)); // Output: 6
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int tempMax = Math.max(current, Math.max(maxSoFar * current, minSoFar * current));
            minSoFar = Math.min(current, Math.min(maxSoFar * current, minSoFar * current));
            maxSoFar = tempMax;
            result = Math.max(result, maxSoFar);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum product: " + solution.maxProduct(nums)); // Output: 6
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
  class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int product1 = maxSoFar * current;
            int product2 = minSoFar * current;

            int newMaxSoFar = current;
            if (product1 > newMaxSoFar) {
                newMaxSoFar = product1;
            }
            if (product2 > newMaxSoFar) {
                newMaxSoFar = product2;
            }
            maxSoFar = newMaxSoFar;

            int newMinSoFar = current;
            if (product1 < newMinSoFar) {
                newMinSoFar = product1;
            }
            if (product2 < newMinSoFar) {
                newMinSoFar = product2;
            }
            minSoFar = newMinSoFar;

            if (maxSoFar > result) {
                result = maxSoFar;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum product: " + solution.maxProduct(nums)); // Output: 6
    }
}
