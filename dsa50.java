public class BooleanMatrix {

    /**
     * Modifies the given binary matrix in-place. If any element is 1,
     * its entire row and entire column are set to 1.
     *
     * @param matrix The binary matrix (0s and 1s) represented as a 2D integer array.
     */
    public void booleanMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return; // Handle empty or null matrix
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowHasOne = false;
        boolean firstColHasOne = false;

        // Step 1: Check if the first row needs to be set to 1
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 1) {
                firstRowHasOne = true;
                break;
            }
        }

        // Step 1: Check if the first column needs to be set to 1
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 1) {
                firstColHasOne = true;
                break;
            }
        }

        // Step 2: Use first row and first column as markers
        // Iterate from (1,1) to avoid overwriting original markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][0] = 1; // Mark row i
                    matrix[0][j] = 1; // Mark column j
                }
            }
        }

        // Step 3: Set rows to 1 based on markers in the first column
        // Iterate from (1,0) to avoid processing firstRowHasOne/firstColHasOne too early
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 1) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = 1;
                }
            }
        }

        // Step 3: Set columns to 1 based on markers in the first row
        // Iterate from (0,1) to avoid processing firstRowHasOne/firstColHasOne too early
        for (int j = 1; j < cols; j++) {
            if (matrix[0][j] == 1) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][j] = 1;
                }
            }
        }

        // Step 4: Handle the first row based on `firstRowHasOne` flag
        if (firstRowHasOne) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 1;
            }
        }

        // Step 4: Handle the first column based on `firstColHasOne` flag
        if (firstColHasOne) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 1;
            }
        }
    }

    // Helper function to print the matrix for testing
    public void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("[]");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BooleanMatrix solver = new BooleanMatrix();

        // Test Case 1
        int[][] matrix1 = {
            {1, 0, 0, 1},
            {0, 0, 1, 0},
            {0, 0, 0, 0}
        };
        System.out.println("Original Matrix 1:");
        solver.printMatrix(matrix1);
        solver.booleanMatrix(matrix1);
        System.out.println("Modified Matrix 1:");
        solver.printMatrix(matrix1);
        /* Expected Output 1:
        1 1 1 1
        1 1 1 1
        1 0 1 1
        */
        // Let's manually trace for expected output:
        // (0,0) is 1 -> first row and first col become 1
        // (0,3) is 1 -> first row and third col become 1
        // (1,2) is 1 -> second row and second col become 1
        //
        // Final Matrix 1 (Expected):
        // 1 1 1 1
        // 1 1 1 1
        // 1 1 1 1

        System.out.println("---");

        // Test Case 2: No ones
        int[][] matrix2 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        System.out.println("Original Matrix 2:");
        solver.printMatrix(matrix2);
        solver.booleanMatrix(matrix2);
        System.out.println("Modified Matrix 2:");
        solver.printMatrix(matrix2);
        /* Expected Output 2:
        0 0 0
        0 0 0
        0 0 0
        */

        System.out.println("---");

        // Test Case 3: All ones
        int[][] matrix3 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        System.out.println("Original Matrix 3:");
        solver.printMatrix(matrix3);
        solver.booleanMatrix(matrix3);
        System.out.println("Modified Matrix 3:");
        solver.printMatrix(matrix3);
        /* Expected Output 3:
        1 1 1
        1 1 1
        1 1 1
        */

        System.out.println("---");

        // Test Case 4: Single element matrix with 1
        int[][] matrix4 = {{1}};
        System.out.println("Original Matrix 4:");
        solver.printMatrix(matrix4);
        solver.booleanMatrix(matrix4);
        System.out.println("Modified Matrix 4:");
        solver.printMatrix(matrix4);
        /* Expected Output 4:
        1
        */

        System.out.println("---");

        // Test Case 5: Single element matrix with 0
        int[][] matrix5 = {{0}};
        System.out.println("Original Matrix 5:");
        solver.printMatrix(matrix5);
        solver.booleanMatrix(matrix5);
        System.out.println("Modified Matrix 5:");
        solver.printMatrix(matrix5);
        /* Expected Output 5:
        0
        */

        System.out.println("---");

        // Test Case 6: First row has 1, no other ones
        int[][] matrix6 = {
            {0, 0, 1},
            {0, 0, 0},
            {0, 0, 0}
        };
        System.out.println("Original Matrix 6:");
        solver.printMatrix(matrix6);
        solver.booleanMatrix(matrix6);
        System.out.println("Modified Matrix 6:");
        solver.printMatrix(matrix6);
        /* Expected Output 6:
        1 1 1
        0 0 1
        0 0 1
        */
        // Let's manually trace for expected output:
        // firstRowHasOne = true (due to matrix[0][2])
        // (0,2) is 1. matrix[0][0] stays 0, matrix[0][2] stays 1.
        // After processing inner cells:
        // Then, set rows from 1.. based on first col. Nothing.
        // Then, set cols from 1.. based on first row.
        // matrix[0][2] is 1, so column 2 becomes 1.
        // Finally, firstRowHasOne is true, so first row becomes 1.
        // Result:
        // 1 1 1
        // 0 0 1
        // 0 0 1

        System.out.println("---");

        // Test Case 7: First column has 1, no other ones
        int[][] matrix7 = {
            {0, 0, 0},
            {1, 0, 0},
            {0, 0, 0}
        };
        System.out.println("Original Matrix 7:");
        solver.printMatrix(matrix7);
        solver.booleanMatrix(matrix7);
        System.out.println("Modified Matrix 7:");
        solver.printMatrix(matrix7);
        /* Expected Output 7:
        1 0 0
        1 1 1
        1 0 0
        */
        // Let's manually trace for expected output:
        // firstColHasOne = true (due to matrix[1][0])
        // (1,0) is 1. matrix[1][0] stays 1.
        // After processing inner cells:
        // Then, set rows from 1.. based on first col.
        // matrix[1][0] is 1, so row 1 becomes 1.
        // Then, set cols from 1.. based on first row. Nothing.
        // Finally, firstRowHasOne is false.
        // firstColHasOne is true, so first col becomes 1.
        // Result:
        // 1 0 0
        // 1 1 1
        // 1 0 0
    }
}
