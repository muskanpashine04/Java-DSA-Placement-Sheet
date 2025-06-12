import java.util.ArrayList;
import java.util.List;

public class MatrixBoundaryTraversal {

    public static List<Integer> boundaryTraversal(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result; // Handle empty or invalid matrix
        }

        int m = matrix.length;    // Number of rows
        int n = matrix[0].length; // Number of columns

        // Case 1: Single row matrix or single column matrix (or both)
        if (m == 1) { // Single row
            for (int j = 0; j < n; j++) {
                result.add(matrix[0][j]);
            }
            return result;
        }

        if (n == 1) { // Single column
            for (int i = 0; i < m; i++) {
                result.add(matrix[i][0]);
            }
            return result;
        }

        // Case 2: General matrix (more than one row and one column)

        // Traverse top row
        for (int j = 0; j < n; j++) {
            result.add(matrix[0][j]);
        }

        // Traverse rightmost column (excluding top and bottom corners)
        for (int i = 1; i < m - 1; i++) {
            result.add(matrix[i][n - 1]);
        }

        // Traverse bottom row (if not the same as top row, i.e., m > 1)
        // Traverse from right to left
        for (int j = n - 1; j >= 0; j--) {
            result.add(matrix[m - 1][j]);
        }

        // Traverse leftmost column (excluding top and bottom corners)
        // Traverse from bottom to top
        for (int i = m - 2; i >= 1; i--) {
            result.add(matrix[i][0]);
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Cases

        System.out.println("Test Case 1: Standard 3x3 matrix");
        int[][] matrix1 = {
            {1, 2, 3},
            {8, 9, 4},
            {7, 6, 5}
        };
        List<Integer> boundary1 = boundaryTraversal(matrix1);
        System.out.println("Boundary: " + boundary1); // Expected: [1, 2, 3, 4, 5, 6, 7, 8]
        System.out.println();

        System.out.println("Test Case 2: 4x4 matrix");
        int[][] matrix2 = {
            {10, 20, 30, 40},
            {11, 21, 31, 41},
            {12, 22, 32, 42},
            {13, 23, 33, 43}
        };
        List<Integer> boundary2 = boundaryTraversal(matrix2);
        System.out.println("Boundary: " + boundary2); // Expected: [10, 20, 30, 40, 41, 42, 43, 33, 23, 13, 12, 11]
        System.out.println();

        System.out.println("Test Case 3: Single row matrix");
        int[][] matrix3 = {{1, 2, 3, 4, 5}};
        List<Integer> boundary3 = boundaryTraversal(matrix3);
        System.out.println("Boundary: " + boundary3); // Expected: [1, 2, 3, 4, 5]
        System.out.println();

        System.out.println("Test Case 4: Single column matrix");
        int[][] matrix4 = {{10}, {20}, {30}};
        List<Integer> boundary4 = boundaryTraversal(matrix4);
        System.out.println("Boundary: " + boundary4); // Expected: [10, 20, 30]
        System.out.println();

        System.out.println("Test Case 5: 1x1 matrix");
        int[][] matrix5 = {{99}};
        List<Integer> boundary5 = boundaryTraversal(matrix5);
        System.out.println("Boundary: " + boundary5); // Expected: [99]
        System.out.println();

        System.out.println("Test Case 6: Empty matrix");
        int[][] matrix6 = {};
        List<Integer> boundary6 = boundaryTraversal(matrix6);
        System.out.println("Boundary: " + boundary6); // Expected: []
        System.out.println();

        System.out.println("Test Case 7: Matrix with empty rows (invalid, but good to handle)");
        int[][] matrix7 = {{}, {}};
        List<Integer> boundary7 = boundaryTraversal(matrix7);
        System.out.println("Boundary: " + boundary7); // Expected: []
        System.out.println();
    }
}
