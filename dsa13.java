Q 13. Find all pairs with a given sum

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPairsWithSum {

    /**
     * Finds all pairs in an array that sum up to a given target.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return A list of pairs (represented as lists of two integers) that sum to the target.
     */
    public static List<List<Integer>> findPairs(int[] nums, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        Map<Integer, Integer> complementMap = new HashMap<>();

        for (int num : nums) {
            int complement = target - num;
            if (complementMap.containsKey(complement)) {
                pairs.add(List.of(complement, num));
            }
            complementMap.put(num, complementMap.getOrDefault(num, 0) + 1);
        }
        return pairs;
    }

    /**
     * Finds all unique pairs in an array that sum up to a given target.
     * This method handles duplicate numbers in the input array and ensures
     * that the resulting pairs are unique.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return A list of unique pairs (represented as lists of two integers) that sum to the target.
     */
    public static List<List<Integer>> findUniquePairs(int[] nums, int target) {
        List<List<Integer>> uniquePairs = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : frequencyMap.keySet()) {
            int complement = target - num;
            if (frequencyMap.containsKey(complement)) {
                if (num < complement || (num == complement && frequencyMap.get(num) > 1)) {
                    uniquePairs.add(List.of(num, complement));
                }
            }
        }
        return uniquePairs;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int sumToFind = 7;
        List<List<Integer>> allPairs = findPairs(numbers, sumToFind);
        System.out.println("All pairs that sum to " + sumToFind + ": " + allPairs);
        // Output: All pairs that sum to 7: [[6, 1], [5, 2], [4, 3]] (order might vary)

        int[] numbersWithDuplicates = {1, 2, 2, 3, 4, 4, 5};
        int sumToFindDuplicates = 6;
        List<List<Integer>> uniquePairsWithDuplicates = findUniquePairs(numbersWithDuplicates, sumToFindDuplicates);
        System.out.println("Unique pairs that sum to " + sumToFindDuplicates + ": " + uniquePairsWithDuplicates);
        // Output: Unique pairs that sum to 6: [[2, 4], [1, 5]]
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------
  import java.util.ArrayList;
import java.util.List;

public class FindPairsEasy {

    public static List<List<Integer>> findPairsWithSum(int[] numbers, int targetSum) {
        List<List<Integer>> pairs = new ArrayList<>();
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == targetSum) {
                    pairs.add(List.of(numbers[i], numbers[j]));
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int target = 7;
        List<List<Integer>> result = findPairsWithSum(nums, target);
        System.out.println("Pairs that sum to " + target + ": " + result);
        // Output: Pairs that sum to 7: [[1, 6], [2, 5], [3, 4]]
    }
}
