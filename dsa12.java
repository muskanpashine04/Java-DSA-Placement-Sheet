import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountOccurrences {

    // Method 1: Iterating through the array
    public static int countOccurrencesIterative(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    // Method 2: Using a HashMap to count occurrences of all elements
    public static int countOccurrencesUsingMap(int[] arr, int target) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        return counts.getOrDefault(target, 0);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 2, 4, 2, 5};
        int elementToCount = 2;

        // Using the iterative method
        int count1 = countOccurrencesIterative(numbers, elementToCount);
        System.out.println("Occurrences of " + elementToCount + " (iterative): " + count1);

        // Using the HashMap method
        int count2 = countOccurrencesUsingMap(numbers, elementToCount);
        System.out.println("Occurrences of " + elementToCount + " (using HashMap): " + count2);
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------

  public class CountEasy {
    public static int count(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 2, 4, 2, 5};
        int elementToCount = 2;
        int occurrences = count(numbers, elementToCount);
        System.out.println("Occurrences of " + elementToCount + ": " + occurrences);
    }
}
