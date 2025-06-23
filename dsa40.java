Q 40. Matrix multiplication
    public class MatrixMultiplication {

    /**
     * Multiplies two matrices and returns the result matrix.
     *
     * @param A The first matrix.
     * @param B The second matrix.
     * @return The product matrix C, or null if multiplication is not possible.
     */
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        // Get dimensions of matrix A
        int rowsA = A.length;
        int colsA = A[0].length;

        // Get dimensions of matrix B
        int rowsB = B.length;
        int colsB = B[0].length;

        // Check if multiplication is possible
        // Number of columns in A must be equal to the number of rows in B
        if (colsA != rowsB) {
            System.out.println("Error: Matrices cannot be multiplied!");
            System.out.println("Number of columns in first matrix (" + colsA + ")");
            System.out.println("must equal number of rows in second matrix (" + rowsB + ").");
            return null; // Return null if multiplication is not valid
        }

        // Initialize the result matrix C with dimensions rowsA x colsB
        int[][] C = new int[rowsA][colsB];

        // Perform matrix multiplication
        // The core of matrix multiplication involves three nested loops:
        // Outer loop for rows of A (i)
        // Middle loop for columns of B (j)
        // Inner loop for elements of the common dimension (k)
        for (int i = 0; i < rowsA; i++) {       // Iterate over rows of matrix A
            for (int j = 0; j < colsB; j++) {   // Iterate over columns of matrix B
                for (int k = 0; k < colsA; k++) { // Iterate over common dimension (colsA or rowsB)
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C; // Return the resulting product matrix
    }

    /**
     * Helper method to print a matrix.
     *
     * @param matrix The matrix to be printed.
     * @param name The name of the matrix (e.g., "Matrix A").
     */
    public static void printMatrix(int[][] matrix, String name) {
        if (matrix == null) {
            System.out.println(name + ": (null)");
            return;
        }
        System.out.println("\n" + name + ":");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println(); // Move to the next line after printing a row
        }
    }

    public static void main(String[] args) {
        // --- Test Case 1: Valid Multiplication ---
        int[][] matrixA1 = {
            {1, 2, 3},
            {4, 5, 6}
        }; // 2x3 matrix

        int[][] matrixB1 = {
            {7, 8},
            {9, 1},
            {2, 3}
        }; // 3x2 matrix

        System.out.println("--- Test Case 1: Valid Multiplication (2x3 * 3x2) ---");
        printMatrix(matrixA1, "Matrix A1");
        printMatrix(matrixB1, "Matrix B1");

        int[][] resultC1 = multiplyMatrices(matrixA1, matrixB1);
        printMatrix(resultC1, "Result Matrix C1 (A1 * B1)");

        // Expected Result C1:
        // (1*7 + 2*9 + 3*2) = (7 + 18 + 6) = 31
        // (1*8 + 2*1 + 3*3) = (8 + 2 + 9) = 19
        // (4*7 + 5*9 + 6*2) = (28 + 45 + 12) = 85
        // (4*8 + 5*1 + 6*3) = (32 + 5 + 18) = 55
        // So, C1 should be:
        // 31 19
        // 85 55

        System.out.println("\n----------------------------------------------------");

        // --- Test Case 2: Invalid Multiplication ---
        int[][] matrixA2 = {
            {1, 2},
            {3, 4}
        }; // 2x2 matrix

        int[][] matrixB2 = {
            {5, 6, 7},
            {8, 9, 0},
            {1, 2, 3}
        }; // 3x3 matrix

        System.out.println("--- Test Case 2: Invalid Multiplication (2x2 * 3x3) ---");
        printMatrix(matrixA2, "Matrix A2");
        printMatrix(matrixB2, "Matrix B2");

        int[][] resultC2 = multiplyMatrices(matrixA2, matrixB2);
        // This should print an error message and resultC2 will be null
        printMatrix(resultC2, "Result Matrix C2 (A2 * B2)");

        System.out.println("\n----------------------------------------------------");

        // --- Test Case 3: Another Valid Multiplication ---
        int[][] matrixA3 = {
            {1, 0},
            {0, 1}
        }; // 2x2 Identity matrix

        int[][] matrixB3 = {
            {5, 6},
            {7, 8}
        }; // 2x2 matrix

        System.out.println("--- Test Case 3: Valid Multiplication (2x2 * 2x2 - Identity) ---");
        printMatrix(matrixA3, "Matrix A3");
        printMatrix(matrixB3, "Matrix B3");

        int[][] resultC3 = multiplyMatrices(matrixA3, matrixB3);
        printMatrix(resultC3, "Result Matrix C3 (A3 * B3)");
        // Expected Result C3:
        // 5 6
        // 7 8
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
