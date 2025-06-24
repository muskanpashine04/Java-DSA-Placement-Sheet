Q 45. Pascal's Triangle
    import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    /**
     * Generates the first numRows of Pascal's Triangle.
     *
     * @param numRows The number of rows to generate.
     * @return A list of lists of integers representing Pascal's Triangle.
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) {
            return triangle; // Return an empty list for invalid input
        }

        // First row
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            // The first element of each row is always 1
            currentRow.add(1);

            // Calculate the middle elements
            // Each element is the sum of the two elements directly above it
            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last element of each row is always 1
            currentRow.add(1);

            triangle.add(currentRow);
        }

        return triangle;
    }

    /**
     * Helper method to print Pascal's Triangle in a formatted way.
     *
     * @param triangle The Pascal's Triangle to print.
     */
    public static void printPascalTriangle(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            System.out.println("Empty Pascal's Triangle.");
            return;
        }

        // Determine the maximum width of a number for formatting
        int maxWidth = 0;
        for (List<Integer> row : triangle) {
            for (int num : row) {
                maxWidth = Math.max(maxWidth, String.valueOf(num).length());
            }
        }

        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);

            // Add leading spaces for alignment
            int leadingSpaces = (triangle.size() - 1 - i) * (maxWidth + 1) / 2; // Adjust spacing based on width
            for (int k = 0; k < leadingSpaces; k++) {
                System.out.print(" ");
            }

            // Print numbers in the row
            for (int j = 0; j < row.size(); j++) {
                System.out.printf("%" + maxWidth + "d", row.get(j));
                if (j < row.size() - 1) {
                    System.out.print(" "); // Space between numbers
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Pascal's Triangle with 1 row:");
        List<List<Integer>> triangle1 = generate(1);
        printPascalTriangle(triangle1);
        System.out.println("\n--------------------\n");

        System.out.println("Pascal's Triangle with 5 rows:");
        List<List<Integer>> triangle5 = generate(5);
        printPascalTriangle(triangle5);
        System.out.println("\n--------------------\n");

        System.out.println("Pascal's Triangle with 10 rows:");
        List<List<Integer>> triangle10 = generate(10);
        printPascalTriangle(triangle10);
        System.out.println("\n--------------------\n");

        System.out.println("Pascal's Triangle with 0 rows:");
        List<List<Integer>> triangle0 = generate(0);
        printPascalTriangle(triangle0);
        System.out.println("\n--------------------\n");

        System.out.println("Pascal's Triangle with -3 rows:");
        List<List<Integer>> triangleNeg3 = generate(-3);
        printPascalTriangle(triangleNeg3);
        System.out.println("\n--------------------\n");
    }
}
