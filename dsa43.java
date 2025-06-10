public class SnakePattern {

    public static void printSnakePattern(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("Matrix is empty or null.");
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            // If the row number is even, print elements from left to right
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            // If the row number is odd, print elements from right to left
            else {
                for (int j = cols - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println(); // Move to the next line after printing a row
        }
    }

    public static void main(String[] args) {
        // Example Usage:
        int[][] myMatrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        System.out.println("Snake Pattern for myMatrix:");
        printSnakePattern(myMatrix);

        System.out.println("\nAnother example:");
        int[][] anotherMatrix = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };
        printSnakePattern(anotherMatrix);
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  public class SnakePattern {

    /**
     * Prints the elements of a 2D matrix in a snake-like pattern.
     * Even-indexed rows (0, 2, 4...) are printed from left to right.
     * Odd-indexed rows (1, 3, 5...) are printed from right to left.
     *
     * @param matrix The 2D integer array (matrix) to print.
     */
    public static void printSnakePattern(int[][] matrix) {
        // --- Input Validation ---
        if (matrix == null || matrix.length == 0) {
            System.out.println("Error: The matrix is null or empty. Cannot print snake pattern.");
            return; // Exit the method if input is invalid
        }

        // Get the number of rows in the matrix
        int rows = matrix.length;
        // Get the number of columns in the first row (assuming a rectangular matrix)
        int cols = matrix[0].length;

        System.out.println("Printing Snake Pattern:");

        // --- Core Logic: Iterate through each row ---
        for (int i = 0; i < rows; i++) {
            // Check if the current row index 'i' is even or odd
            if (i % 2 == 0) {
                // --- Even Row: Print elements from left to right ---
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j] + "\t"); // Print element followed by a tab for spacing
                }
            } else {
                // --- Odd Row: Print elements from right to left ---
                for (int j = cols - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j] + "\t"); // Print element followed by a tab for spacing
                }
            }
            // After printing all elements in a row (either left-to-right or right-to-left),
            // move to the next line for the subsequent row.
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // --- Example 1: A 4x4 matrix ---
        int[][] matrix1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        System.out.println("--- Example 1 ---");
        printSnakePattern(matrix1);
        System.out.println("\n"); // Add some space for clarity

        // --- Example 2: A 3x5 matrix (rectangular) ---
        int[][] matrix2 = {
            {10, 20, 30, 40, 50},
            {60, 70, 80, 90, 100},
            {110, 120, 130, 140, 150}
        };
        System.out.println("--- Example 2 ---");
        printSnakePattern(matrix2);
        System.out.println("\n");

        // --- Example 3: A single-row matrix ---
        int[][] matrix3 = {
            {1, 2, 3}
        };
        System.out.println("--- Example 3 (Single Row) ---");
        printSnakePattern(matrix3);
        System.out.println("\n");

        // --- Example 4: A single-column matrix ---
        int[][] matrix4 = {
            {100},
            {200},
            {300}
        };
        System.out.println("--- Example 4 (Single Column) ---");
        printSnakePattern(matrix4);
        System.out.println("\n");

        // --- Example 5: An empty matrix (test for validation) ---
        int[][] emptyMatrix = {};
        System.out.println("--- Example 5 (Empty Matrix) ---");
        printSnakePattern(emptyMatrix);
        System.out.println("\n");

        // --- Example 6: A null matrix (test for validation) ---
        int[][] nullMatrix = null;
        System.out.println("--- Example 6 (Null Matrix) ---");
        printSnakePattern(nullMatrix);
        System.out.println("\n");
    }
}


--- Example 1 ---
Printing Snake Pattern:
1	2	3	4	
8	7	6	5	
9	10	11	12	
16	15	14	13	


--- Example 2 ---
Printing Snake Pattern:
10	20	30	40	50	
100	90	80	70	60	
110	120	130	140	150	


--- Example 3 (Single Row) ---
Printing Snake Pattern:
1	2	3	


--- Example 4 (Single Column) ---
Printing Snake Pattern:
100	
200	
300	


--- Example 5 (Empty Matrix) ---
Error: The matrix is null or empty. Cannot print snake pattern.


--- Example 6 (Null Matrix) ---
Error: The matrix is null or empty. Cannot print snake pattern.
