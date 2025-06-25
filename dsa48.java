Q48. Find median in a row-wise sorted matrix
    import java.util.Arrays;

public class MedianInRowWiseSortedMatrix {

    /**
     * Finds the median in a row-wise sorted matrix.
     * Assumes that the matrix has an odd number of elements to ensure a unique median.
     *
     * @param matrix The input matrix, where each row is sorted.
     * @return The median of the matrix elements.
     */
    public int findMedian(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix cannot be empty or null.");
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Ensure the total number of elements is odd for a unique median
        if ((rows * cols) % 2 == 0) {
            System.out.println("Warning: The matrix has an even number of elements. " +
                               "Returning the lower median. For a true median, " +
                               "consider the definition for even-sized sets.");
        }

        // Initialize min and max values to determine the search range
        // The median must lie between the minimum and maximum elements in the matrix.
        int minVal = matrix[0][0];
        int maxVal = matrix[0][cols - 1];

        // Find the overall minimum and maximum values in the matrix
        // (min of first column, max of last column)
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] < minVal) {
                minVal = matrix[i][0];
            }
            if (matrix[i][cols - 1] > maxVal) {
                maxVal = matrix[i][cols - 1];
            }
        }

        // The target count of elements less than or equal to the median
        // For 'n' elements, the median is the element at (n/2)th position (0-indexed)
        // or (n/2 + 1)th position (1-indexed) in a sorted array.
        // For an odd number of elements, (totalElements / 2) is the index of the median.
        // We need 'desiredCount' elements to be less than or equal to the median.
        int desiredCount = (rows * cols + 1) / 2; // (total elements / 2) + 1, for 1-based indexing, or (total elements / 2) for 0-based.
                                                  // For example, if 9 elements, we need 5th smallest element, which is (9+1)/2 = 5
                                                  // If 5 elements, we need 3rd smallest, which is (5+1)/2 = 3

        int median = 0;

        // Binary search for the median value
        while (minVal <= maxVal) {
            int midVal = minVal + (maxVal - minVal) / 2; // Calculate mid value to avoid overflow
            int countSmallerOrEqual = 0;

            // Count elements less than or equal to midVal in each row
            for (int i = 0; i < rows; i++) {
                // Use binary search (upper_bound concept) in each row
                // to find the count of elements <= midVal efficiently.
                // Arrays.binarySearch returns (-(insertion point) - 1) if not found.
                // The insertion point is the index of the first element greater than the key.
                // So, `pos` will be the count of elements less than or equal to midVal.
                int low = 0;
                int high = cols - 1;
                int rowCount = 0;
                while (low <= high) {
                    int m = low + (high - low) / 2;
                    if (matrix[i][m] <= midVal) {
                        rowCount = m + 1; // All elements from 0 to m are <= midVal
                        low = m + 1;
                    } else {
                        high = m - 1;
                    }
                }
                countSmallerOrEqual += rowCount;
            }

            // If countSmallerOrEqual is less than desiredCount, it means our midVal is too small.
            // We need to look in the upper half.
            if (countSmallerOrEqual < desiredCount) {
                minVal = midVal + 1;
            } else {
                // If countSmallerOrEqual is greater than or equal to desiredCount,
                // midVal could be the median, or the median is in the lower half (or equal).
                // We try to find the smallest possible value that satisfies the condition.
                median = midVal;
                maxVal = midVal - 1;
            }
        }
        return median;
    }

    public static void main(String[] args) {
        MedianInRowWiseSortedMatrix solver = new MedianInRowWiseSortedMatrix();

        // Test Case 1: Odd number of elements
        int[][] matrix1 = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };
        // Flattened and sorted: [1, 2, 3, 3, 5, 6, 6, 9, 9]
        // Median (9 elements): 5th element is 5
        System.out.println("Median of matrix 1: " + solver.findMedian(matrix1)); // Expected: 5

        // Test Case 2: Different dimensions, odd number of elements
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
            {17, 18, 19, 20}
        }; // Total 20 elements, this code will return the lower median (10th element)
        // For a unique median, we assume odd number of elements as per common problem definitions.
        // If we strictly want the true median for even elements (average of two middle),
        // the logic needs to be adjusted.
        // Flattened and sorted: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
        // Middle elements are 10 and 11. Lower median is 10.
        System.out.println("Median of matrix 2: " + solver.findMedian(matrix2)); // Expected: 10 (or a value near it)

        // Test Case 3: Simple case
        int[][] matrix3 = {
            {1},
            {2},
            {3}
        };
        System.out.println("Median of matrix 3: " + solver.findMedian(matrix3)); // Expected: 2

        // Test Case 4: Larger values
        int[][] matrix4 = {
            {10, 20, 30},
            {15, 25, 35},
            {5, 12, 18}
        };
        // Flattened and sorted: [5, 10, 12, 15, 18, 20, 25, 30, 35]
        // Median: 18
        System.out.println("Median of matrix 4: " + solver.findMedian(matrix4)); // Expected: 18

        // Test Case 5: All same elements
        int[][] matrix5 = {
            {7, 7, 7},
            {7, 7, 7},
            {7, 7, 7}
        };
        System.out.println("Median of matrix 5: " + solver.findMedian(matrix5)); // Expected: 7

        // Test Case 6: Empty matrix (will throw IllegalArgumentException)
        try {
            int[][] matrix6 = {};
            System.out.println("Median of matrix 6: " + solver.findMedian(matrix6));
        } catch (IllegalArgumentException e) {
            System.out.println("Error for empty matrix: " + e.getMessage());
        }

        // Test Case 7: Single row matrix
        int[][] matrix7 = {
            {1, 5, 9, 10, 11}
        };
        System.out.println("Median of matrix 7: " + solver.findMedian(matrix7)); // Expected: 9
    }
}
