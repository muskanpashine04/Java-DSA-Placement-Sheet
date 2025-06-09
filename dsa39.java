import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class SpiralMatrixTraversal {

    /**
     * Performs a spiral traversal of a given matrix.
     *
     * @param matrix The 2D array representing the matrix.
     * @return A List of Integers containing the elements in spiral order.
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result; // Return empty list for empty or invalid matrix
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1. Traverse from left to right along the top row
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++; // Move top boundary down

            // 2. Traverse from top to bottom along the rightmost column
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--; // Move right boundary left

            // Check if there are still rows to traverse from bottom-right to bottom-left
            // This condition is important for non-square matrices or matrices with a single row/column
            if (top <= bottom) {
                // 3. Traverse from right to left along the bottom row
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--; // Move bottom boundary up
            }

            // Check if there are still columns to traverse from bottom-left to top-left
            // This condition is important for non-square matrices or matrices with a single row/column
            if (left <= right) {
                // 4. Traverse from bottom to top along the leftmost column
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++; // Move left boundary right
            }
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("[]");
            return;
        }
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(); // Add a newline for better separation
    }

    public static void main(String[] args) {
        // Example 1: 3x3 matrix
        int[][] matrix1 = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        System.out.println("Matrix 1:");
        printMatrix(matrix1);
        System.out.println("Spiral Traversal: " + spiralOrder(matrix1));
        // Expected: [1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println("--------------------");

        // Example 2: 4x4 matrix
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };
        System.out.println("Matrix 2:");
        printMatrix(matrix2);
        System.out.println("Spiral Traversal: " + spiralOrder(matrix2));
        // Expected: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
        System.out.println("--------------------");

        // Example 3: Rectangular matrix (3x5)
        int[][] matrix3 = {
                {1, 2, 3, 4, 5},
                {14, 15, 16, 17, 6},
                {13, 12, 11, 10, 7},
                {12,13,14,15,8} // Add another row to make it 4x5
        };
        System.out.println("Matrix 3:");
        printMatrix(matrix3);
        System.out.println("Spiral Traversal: " + spiralOrder(matrix3));
        // Expected: [1, 2, 3, 4, 5, 6, 7, 8, 15, 14, 13, 12, 12, 14, 13, 11, 10, 17, 16, 15]
        System.out.println("--------------------");


        // Example 4: Single row matrix
        int[][] matrix4 = {{1, 2, 3, 4, 5}};
        System.out.println("Matrix 4 (Single Row):");
        printMatrix(matrix4);
        System.out.println("Spiral Traversal: " + spiralOrder(matrix4));
        // Expected: [1, 2, 3, 4, 5]
        System.out.println("--------------------");

        // Example 5: Single column matrix
        int[][] matrix5 = {{1}, {2}, {3}, {4}, {5}};
        System.out.println("Matrix 5 (Single Column):");
        printMatrix(matrix5);
        System.out.println("Spiral Traversal: " + spiralOrder(matrix5));
        // Expected: [1, 2, 3, 4, 5]
        System.out.println("--------------------");

        // Example 6: 1x1 matrix
        int[][] matrix6 = {{99}};
        System.out.println("Matrix 6 (1x1):");
        printMatrix(matrix6);
        System.out.println("Spiral Traversal: " + spiralOrder(matrix6));
        // Expected: [99]
        System.out.println("--------------------");

        // Example 7: Empty matrix
        int[][] emptyMatrix = {};
        System.out.println("Matrix 7 (Empty):");
        printMatrix(emptyMatrix);
        System.out.println("Spiral Traversal: " + spiralOrder(emptyMatrix));
        // Expected: []
        System.out.println("--------------------");

        // Example 8: Matrix with empty rows (but matrix is not null)
        int[][] matrixWithEmptyRow = {{}};
        System.out.println("Matrix 8 (Empty rows):");
        printMatrix(matrixWithEmptyRow);
        System.out.println("Spiral Traversal: " + spiralOrder(matrixWithEmptyRow));
        // Expected: []
        System.out.println("--------------------");
    }
}
