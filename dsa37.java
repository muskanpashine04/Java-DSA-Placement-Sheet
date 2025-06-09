import java.util.Arrays;

public class MatrixRotation {

    public static void rotateMatrixClockwise(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return; // Handle empty or invalid matrices
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Transpose the matrix
        // This handles both square and rectangular matrices correctly
        // For non-square matrices, a new matrix is needed for transposition
        int[][] transposedMatrix;
        if (rows == cols) {
            transposedMatrix = new int[rows][cols]; // For square matrix, can reuse dimensions
            for (int i = 0; i < rows; i++) {
                for (int j = i; j < cols; j++) { // Iterate from j = i to avoid double-swapping
                    transposedMatrix[j][i] = matrix[i][j];
                    transposedMatrix[i][j] = matrix[j][i]; // This line is actually unnecessary if transposing to a new matrix
                }
            }
            // Corrected transposition for square matrix in-place (or to a new matrix correctly)
            for (int i = 0; i < rows; i++) {
                for (int j = i; j < cols; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            // After in-place transpose, the original matrix is now transposed.
        } else {
            // For rectangular matrices, a new matrix with swapped dimensions is required
            transposedMatrix = new int[cols][rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    transposedMatrix[j][i] = matrix[i][j];
                }
            }
            // Update the original matrix reference to the transposed one
            // This is a bit tricky for an "in-place" rotation of rectangular matrices.
            // For true in-place, the problem is usually defined for square matrices.
            // For rectangular, it's more about returning a new rotated matrix.
            // Let's stick to the common interpretation for square matrices for in-place.
            // If the input is rectangular, the problem typically asks for a *new* rotated matrix.
            // For this example, we'll assume a square matrix for in-place modification.
            // If the input is rectangular, you'd typically return 'transposedMatrix' after row reversal.
            // For simplicity and common interview scenarios, we'll demonstrate in-place for square matrices.
            // If rectangular matrix rotation *in-place* is required, it's a more complex problem
            // involving potentially different data structures or a different approach.
            System.out.println("Note: In-place rotation by 90 degrees clockwise is typically for square matrices.");
            System.out.println("For rectangular matrices, a new matrix is usually returned.");
            // We'll proceed with the assumption that the input is a square matrix for in-place.
            // If it's rectangular, the user would need to handle the 'transposedMatrix' result.
            return; // Exit if not square for this in-place example
        }


        // Step 2: Reverse each row
        for (int i = 0; i < rows; i++) { // For square matrix, 'rows' is now the new number of rows
            int left = 0;
            int right = cols - 1; // For square matrix, 'cols' is now the new number of columns
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void rotateMatrixClockwiseOptimal(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int n = matrix.length; // Assuming square matrix (n x n)

        // Step 1: Transpose the matrix
        // Iterate only over the upper triangle to avoid double-swapping
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
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
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix 1:");
        printMatrix(matrix1);
        rotateMatrixClockwiseOptimal(matrix1);
        System.out.println("Rotated Matrix 1 (90 degrees clockwise):");
        printMatrix(matrix1);
        // Expected Output:
        // [7, 4, 1]
        // [8, 5, 2]
        // [9, 6, 3]

        System.out.println("--------------------");

        // Example 2: 2x2 matrix
        int[][] matrix2 = {
                {10, 20},
                {30, 40}
        };

        System.out.println("Original Matrix 2:");
        printMatrix(matrix2);
        rotateMatrixClockwiseOptimal(matrix2);
        System.out.println("Rotated Matrix 2 (90 degrees clockwise):");
        printMatrix(matrix2);
        // Expected Output:
        // [30, 10]
        // [40, 20]

        System.out.println("--------------------");

        // Example 3: 4x4 matrix
        int[][] matrix3 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println("Original Matrix 3:");
        printMatrix(matrix3);
        rotateMatrixClockwiseOptimal(matrix3);
        System.out.println("Rotated Matrix 3 (90 degrees clockwise):");
        printMatrix(matrix3);
        // Expected Output:
        // [13, 9, 5, 1]
        // [14, 10, 6, 2]
        // [15, 11, 7, 3]
        // [16, 12, 8, 4]

        System.out.println("--------------------");

        // Example 4: Edge case - 1x1 matrix
        int[][] matrix4 = {{5}};
        System.out.println("Original Matrix 4:");
        printMatrix(matrix4);
        rotateMatrixClockwiseOptimal(matrix4);
        System.out.println("Rotated Matrix 4 (90 degrees clockwise):");
        printMatrix(matrix4);
        // Expected Output:
        // [5]

        System.out.println("--------------------");

        // Example 5: Rectangular matrix (will print a note as optimal method assumes square)
        int[][] matrix5 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println("Original Matrix 5 (Rectangular):");
        printMatrix(matrix5);
        System.out.println("Attempting rotation with the general method (will note limitation for non-square in-place):");
        rotateMatrixClockwise(matrix5); // This will print a note and not modify in-place
        System.out.println("Matrix 5 after attempted rotation (should be unchanged for rectangular in this example):");
        printMatrix(matrix5);

    }
}
