import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 2, 5};
        findDuplicates(nums1); // Output: Duplicate numbers found: [2]

        int[] nums2 = {1, 1, 1, 4, 5};
        findDuplicates(nums2); // Output: Duplicate numbers found: [1]

        int[] nums3 = {1, 2, 3, 4, 5};
        findDuplicates(nums3); // Output: No duplicate numbers found.

        int[] nums4 = {3, 1, 3, 4, 2};
        findDuplicates(nums4); // Output: Duplicate numbers found: [3]

        int[] nums5 = {};
        findDuplicates(nums5); // Output: No duplicate numbers found.
    }

    public static void findDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1) {
            System.out.println("No duplicate numbers found.");
            return;
        }

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                duplicates.add(num);
            } else {
                seen.add(num);
            }
        }

        if (!duplicates.isEmpty()) {
            System.out.println("Duplicate numbers found: " + Arrays.toString(duplicates.toArray()));
        } else {
            System.out.println("No duplicate numbers found.");
        }
    }
}
---------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.Arrays;

public class FindDuplicateEasy {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 2, 5};
        findFirstDuplicate(nums1); // Output: First duplicate found: 2

        int[] nums2 = {1, 1, 1, 4, 5};
        findFirstDuplicate(nums2); // Output: First duplicate found: 1

        int[] nums3 = {1, 2, 3, 4, 5};
        findFirstDuplicate(nums3); // Output: No duplicate found.

        int[] nums4 = {3, 1, 3, 4, 2};
        findFirstDuplicate(nums4); // Output: First duplicate found: 3
    }

    public static void findFirstDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            System.out.println("No duplicate found.");
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    System.out.println("First duplicate found: " + nums[i]);
                    return; // Exit after finding the first duplicate
                }
            }
        }
        System.out.println("No duplicate found.");
    }
}
