Q 38. Search in a row-wise and column-wise sorted matrix
    import java.util.Arrays;

public class SortedMatrixSearch {

    /**
     * Searches for a target value in a row-wise and column-wise sorted matrix.
     *
     * @param matrix The 2D array representing the matrix.
     * @param target The integer value to search for.
     * @return An array of two integers [row, col] if the target is found,
     * or [-1, -1] if the target is not found.
     */
    public static int[] searchMatrix(int[][] matrix, int target) {
        // Handle empty or invalid matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1, -1};
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from the top-right corner
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                // Target found
                return new int[]{row, col};
            } else if (matrix[row][col] > target) {
                // Current element is greater than target,
                // so target must be to the left (smaller values)
                col--;
            } else { // matrix[row][col] < target
                // Current element is less than target,
                // so target must be below (larger values)
                row++;
            }
        }

        // Target not found
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        System.out.println("Matrix 1:");
        for (int[] row : matrix1) {
            System.out.println(Arrays.toString(row));
        }

        // Test cases for Matrix 1
        int target1 = 5;
        int[] result1 = searchMatrix(matrix1, target1);
        System.out.println("Searching for " + target1 + ": " + Arrays.toString(result1)); // Expected: [1, 1]

        int target2 = 20;
        int[] result2 = searchMatrix(matrix1, target2);
        System.out.println("Searching for " + target2 + ": " + Arrays.toString(result2)); // Expected: [-1, -1]

        int target3 = 1;
        int[] result3 = searchMatrix(matrix1, target3);
        System.out.println("Searching for " + target3 + ": " + Arrays.toString(result3)); // Expected: [0, 0]

        int target4 = 30;
        int[] result4 = searchMatrix(matrix1, target4);
        System.out.println("Searching for " + target4 + ": " + Arrays.toString(result4)); // Expected: [4, 4]

        int target5 = 17;
        int[] result5 = searchMatrix(matrix1, target5);
        System.out.println("Searching for " + target5 + ": " + Arrays.toString(result5)); // Expected: [3, 3]

        System.out.println("\n---------------------\n");

        int[][] matrix2 = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };

        System.out.println("Matrix 2:");
        for (int[] row : matrix2) {
            System.out.println(Arrays.toString(row));
        }

        // Test cases for Matrix 2
        int target6 = 29;
        int[] result6 = searchMatrix(matrix2, target6);
        System.out.println("Searching for " + target6 + ": " + Arrays.toString(result6)); // Expected: [2, 1]

        int target7 = 31;
        int[] result7 = searchMatrix(matrix2, target7);
        System.out.println("Searching for " + target7 + ": " + Arrays.toString(result7)); // Expected: [-1, -1]

        int target8 = 32;
        int[] result8 = searchMatrix(matrix2, target8);
        System.out.println("Searching for " + target8 + ": " + Arrays.toString(result8)); // Expected: [3, 0]

        System.out.println("\n---------------------\n");

        int[][] emptyMatrix = {};
        int[] emptyResult = searchMatrix(emptyMatrix, 10);
        System.out.println("Searching in empty matrix: " + Arrays.toString(emptyResult)); // Expected: [-1, -1]

        int[][] singleRowMatrix = {{1, 2, 3, 4}};
        int[] singleRowResult = searchMatrix(singleRowMatrix, 3);
        System.out.println("Searching in single row matrix for 3: " + Arrays.toString(singleRowResult)); // Expected: [0, 2]
        int[] singleRowResult2 = searchMatrix(singleRowMatrix, 5);
        System.out.println("Searching in single row matrix for 5: " + Arrays.toString(singleRowResult2)); // Expected: [-1, -1]
    }
}
