public class MatrixZeroer {

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return; // Handle empty or invalid matrix
        }

        int m = matrix.length;    // Number of rows
        int n = matrix[0].length; // Number of columns

        // Use two boolean arrays to mark rows and columns that need to be zeroed
        boolean[] zeroRows = new boolean[m];
        boolean[] zeroCols = new boolean[n];

        // First pass: Identify which rows and columns contain a zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        // Second pass: Set elements to zero based on the marked rows and columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Helper function to print the matrix (for testing purposes)
    public static void printMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix is null.");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[][] matrix1 = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        System.out.println("Original Matrix 1:");
        printMatrix(matrix1);
        setZeroes(matrix1);
        System.out.println("Modified Matrix 1:");
        printMatrix(matrix1);
        System.out.println("--------------------");

        // Test Case 2
        int[][] matrix2 = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };
        System.out.println("Original Matrix 2:");
        printMatrix(matrix2);
        setZeroes(matrix2);
        System.out.println("Modified Matrix 2:");
        printMatrix(matrix2);
        System.out.println("--------------------");

        // Test Case 3 (No zeroes)
        int[][] matrix3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Original Matrix 3:");
        printMatrix(matrix3);
        setZeroes(matrix3);
        System.out.println("Modified Matrix 3:");
        printMatrix(matrix3);
        System.out.println("--------------------");

         // Test Case 4 (All zeroes)
        int[][] matrix4 = {
            {0, 0},
            {0, 0}
        };
        System.out.println("Original Matrix 4:");
        printMatrix(matrix4);
        setZeroes(matrix4);
        System.out.println("Modified Matrix 4:");
        printMatrix(matrix4);
        System.out.println("--------------------");
    }
}
