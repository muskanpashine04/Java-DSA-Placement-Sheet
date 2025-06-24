 Q46. Search a 2D matrix (Leetcode 74)
     public class SearchA2DMatrix {

    /**
     * Searches for a target value in an m x n integer matrix with the following properties:
     * - Each row is sorted in non-decreasing order.
     * - The first integer of each row is greater than the last integer of the previous row.
     *
     * @param matrix The m x n integer matrix.
     * @param target The integer to search for.
     * @return True if the target is in the matrix, false otherwise.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // Handle empty or invalid matrix
        }

        int m = matrix.length;    // Number of rows
        int n = matrix[0].length; // Number of columns

        // Treat the 2D matrix as a sorted 1D array of size m*n
        int low = 0;
        int high = (m * n) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate mid-point to prevent overflow

            // Convert 1D index (mid) back to 2D coordinates (row, col)
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true; // Target found
            } else if (matrix[row][col] < target) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        SearchA2DMatrix solution = new SearchA2DMatrix();

        // Test Case 1: Target found
        int[][] matrix1 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target1 = 3;
        System.out.println("Matrix 1, Target 3: " + solution.searchMatrix(matrix1, target1)); // Expected: true

        // Test Case 2: Target not found
        int[][] matrix2 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target2 = 13;
        System.out.println("Matrix 2, Target 13: " + solution.searchMatrix(matrix2, target2)); // Expected: false

        // Test Case 3: Target in the first row
        int[][] matrix3 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int target3 = 2;
        System.out.println("Matrix 3, Target 2: " + solution.searchMatrix(matrix3, target3)); // Expected: true

        // Test Case 4: Target in the last row
        int[][] matrix4 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int target4 = 6;
        System.out.println("Matrix 4, Target 6: " + solution.searchMatrix(matrix4, target4)); // Expected: true

        // Test Case 5: Single element matrix, target found
        int[][] matrix5 = {{5}};
        int target5 = 5;
        System.out.println("Matrix 5, Target 5: " + solution.searchMatrix(matrix5, target5)); // Expected: true

        // Test Case 6: Single element matrix, target not found
        int[][] matrix6 = {{5}};
        int target6 = 0;
        System.out.println("Matrix 6, Target 0: " + solution.searchMatrix(matrix6, target6)); // Expected: false

        // Test Case 7: Empty matrix
        int[][] matrix7 = {};
        int target7 = 1;
        System.out.println("Matrix 7, Target 1: " + solution.searchMatrix(matrix7, target7)); // Expected: false

        // Test Case 8: Matrix with empty rows
        int[][] matrix8 = {{}, {}};
        int target8 = 1;
        System.out.println("Matrix 8, Target 1: " + solution.searchMatrix(matrix8, target8)); // Expected: false
    }
}
