Q36. Transpose of a matrix
    public class MatrixTranspose {

    /**
     * Computes the transpose of a given matrix.
     *
     * @param matrix The original matrix (2D array).
     * Assumes a rectangular matrix (all rows have the same number of columns).
     * @return The transposed matrix. Returns null if the input matrix is null or empty.
     */
    public int[][] transpose(int[][] matrix) {
        // Handle null or empty matrix cases
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null; // Or throw an IllegalArgumentException, depending on desired behavior
        }

        int rows = matrix.length;        // Number of rows in the original matrix
        int cols = matrix[0].length;     // Number of columns in the original matrix

        // The transposed matrix will have dimensions (cols x rows)
        int[][] transposedMatrix = new int[cols][rows];

        // Iterate through the original matrix
        for (int i = 0; i < rows; i++) { // 'i' represents the row index of the original matrix
            for (int j = 0; j < cols; j++) { // 'j' represents the column index of the original matrix
                // The element at matrix[i][j] in the original matrix
                // goes to transposedMatrix[j][i] in the new matrix.
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    /**
     * Helper method to print a matrix for easy visualization.
     *
     * @param matrix The matrix to print.
     */
    public void printMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix is null.");
            return;
        }
        if (matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Matrix is empty.");
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t"); // Use \t for tab separation
            }
            System.out.println(); // New line after each row
        }
    }

    public static void main(String[] args) {
        MatrixTranspose transcoder = new MatrixTranspose();

        // Test Case 1: Standard 3x2 matrix
        int[][] matrix1 = {
            {1, 2},
            {3, 4},
            {5, 6}
        };
        System.out.println("Original Matrix 1 (3x2):");
        transcoder.printMatrix(matrix1);
        int[][] transposed1 = transcoder.transpose(matrix1);
        System.out.println("\nTransposed Matrix 1 (2x3):");
        transcoder.printMatrix(transposed1);
        // Expected:
        // 1 3 5
        // 2 4 6

        System.out.println("\n---------------------------\n");

        // Test Case 2: Square 3x3 matrix
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Original Matrix 2 (3x3):");
        transcoder.printMatrix(matrix2);
        int[][] transposed2 = transcoder.transpose(matrix2);
        System.out.println("\nTransposed Matrix 2 (3x3):");
        transcoder.printMatrix(transposed2);
        // Expected:
        // 1 4 7
        // 2 5 8
        // 3 6 9

        System.out.println("\n---------------------------\n");

        // Test Case 3: 1x4 (row) matrix
        int[][] matrix3 = {
            {10, 20, 30, 40}
        };
        System.out.println("Original Matrix 3 (1x4):");
        transcoder.printMatrix(matrix3);
        int[][] transposed3 = transcoder.transpose(matrix3);
        System.out.println("\nTransposed Matrix 3 (4x1):");
        transcoder.printMatrix(transposed3);
        // Expected:
        // 10
        // 20
        // 30
        // 40

        System.out.println("\n---------------------------\n");

        // Test Case 4: Empty matrix
        int[][] matrix4 = {};
        System.out.println("Original Matrix 4 (Empty):");
        transcoder.printMatrix(matrix4);
        int[][] transposed4 = transcoder.transpose(matrix4);
        System.out.println("\nTransposed Matrix 4:");
        transcoder.printMatrix(transposed4); // Expected: Matrix is null.

        System.out.println("\n---------------------------\n");

        // Test Case 5: Matrix with empty rows (or a single row with no columns)
        int[][] matrix5 = {{}};
        System.out.println("Original Matrix 5 (Empty Row):");
        transcoder.printMatrix(matrix5);
        int[][] transposed5 = transcoder.transpose(matrix5);
        System.out.println("\nTransposed Matrix 5:");
        transcoder.printMatrix(transposed5); // Expected: Matrix is null.

        System.out.println("\n---------------------------\n");

        // Test Case 6: Null matrix
        int[][] matrix6 = null;
        System.out.println("Original Matrix 6 (Null):");
        transcoder.printMatrix(matrix6);
        int[][] transposed6 = transcoder.transpose(matrix6);
        System.out.println("\nTransposed Matrix 6:");
        transcoder.printMatrix(transposed6); // Expected: Matrix is null.
    }
}
