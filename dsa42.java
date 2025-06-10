public class MatrixDiagonals {

    public static void printDiagonals(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Matrix is empty or null.");
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println("Main Diagonals (top-left to bottom-right):");
        // Print main diagonals (including those starting from first row and first column)
        for (int k = 0; k < rows + cols - 1; k++) {
            System.out.print("Diagonal " + (k + 1) + ": ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i + j == k) {
                        System.out.print(matrix[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }

        System.out.println("\nAnti-Diagonals (top-right to bottom-left):");
        // Print anti-diagonals
        for (int k = 0; k < rows + cols - 1; k++) {
            System.out.print("Anti-Diagonal " + (k + 1) + ": ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i - j == k - (cols - 1)) { // Adjusted for correct anti-diagonal condition
                        System.out.print(matrix[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example 1: Square matrix
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("--- Matrix 1 ---");
        printDiagonals(matrix1);

        System.out.println("\n----------------\n");

        // Example 2: Rectangular matrix
        int[][] matrix2 = {
            {10, 11, 12, 13},
            {14, 15, 16, 17},
            {18, 19, 20, 21}
        };
        System.out.println("--- Matrix 2 ---");
        printDiagonals(matrix2);

        System.out.println("\n----------------\n");

        // Example 3: Single row matrix
        int[][] matrix3 = {
            {1, 2, 3, 4}
        };
        System.out.println("--- Matrix 3 (Single Row) ---");
        printDiagonals(matrix3);

        System.out.println("\n----------------\n");

        // Example 4: Single column matrix
        int[][] matrix4 = {
            {1},
            {2},
            {3}
        };
        System.out.println("--- Matrix 4 (Single Column) ---");
        printDiagonals(matrix4);

        System.out.println("\n----------------\n");

        // Example 5: Empty matrix
        int[][] matrix5 = {};
        System.out.println("--- Matrix 5 (Empty) ---");
        printDiagonals(matrix5);

        System.out.println("\n----------------\n");

        // Example 6: Null matrix
        int[][] matrix6 = null;
        System.out.println("--- Matrix 6 (Null) ---");
        printDiagonals(matrix6);
    }
}
