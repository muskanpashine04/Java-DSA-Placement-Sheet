class FindMissing {
    public static int findMissingNumber(int[] arr, int n) {
        // Calculate the expected sum of numbers from 1 to n
        int expectedSum = n * (n + 1) / 2;

        // Calculate the actual sum of the numbers in the array
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        // The missing number is the difference between the expected and actual sum
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] numbers = {1, 2, 4, 6, 3, 7, 8};
        int n = 8;
        int missing = findMissingNumber(numbers, n);
        System.out.println("The missing number is: " + missing); // Output: 5

        int[] numbers2 = {1};
        int n2 = 2;
        int missing2 = findMissingNumber(numbers2, n2);
        System.out.println("The missing number is: " + missing2); // Output: 2

        int[] numbers3 = {2, 3, 4, 5};
        int n3 = 5;
        int missing3 = findMissingNumber(numbers3, n3);
        System.out.println("The missing number is: " + missing3); // Output: 1
    }
}
---------------------------------------------------------------------------------------------------------------------------------

class FindMissingEasy {
    public static int findMissing(int[] arr, int n) {
        int sum = n * (n + 1) / 2;
        for (int num : arr) {
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 5};
        int n = 5;
        int missing = findMissing(numbers, n);
        System.out.println("Missing number: " + missing); // Output: 3
    }
}
