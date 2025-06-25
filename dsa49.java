Q 49. Maximum size rectangle of all 1s in binary matrix
    import java.util.Stack;

public class MaxRectangleInBinaryMatrix {

    /**
     * Finds the maximum area of a rectangle containing only '1's in a binary matrix.
     *
     * @param matrix The binary matrix represented as a 2D char array ('1' for land, '0' for water).
     * @return The maximum area of the rectangle of all '1's.
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;

        // heights array will store the height of consecutive '1's ending at the current row for each column.
        int[] heights = new int[cols];

        for (int i = 0; i < rows; i++) {
            // Update heights for the current row
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++; // Increment height if it's a '1'
                } else {
                    heights[j] = 0; // Reset height to 0 if it's a '0'
                }
            }

            // Calculate the largest rectangle in the current histogram (heights array)
            maxArea = Math.max(maxArea, largestRectangleInHistogram(heights));
        }

        return maxArea;
    }

    /**
     * Calculates the largest rectangle area in a histogram given by the heights array.
     * This uses a monotonic stack approach.
     *
     * @param heights An array representing the heights of bars in a histogram.
     * @return The maximum area of a rectangle that can be formed in the histogram.
     */
    private int largestRectangleInHistogram(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Iterate through all bars, including a virtual bar of height 0 at the end
        // to pop all remaining bars from the stack.
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i]; // Use 0 for the virtual bar

            // While stack is not empty and current height is less than the height of the bar at stack's top
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int h = heights[stack.pop()]; // Height of the popped bar
                int w = stack.isEmpty() ? i : i - stack.peek() - 1; // Width of the rectangle

                // If stack is empty, it means the popped bar extends to the beginning (index 0)
                // Its width is 'i' (current index).
                // If stack is not empty, the width is from the element at stack.peek() + 1 to i - 1.
                // The element at stack.peek() is the first element to the left that is smaller than h.
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i); // Push current index onto the stack
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxRectangleInBinaryMatrix solver = new MaxRectangleInBinaryMatrix();

        // Test Case 1: Example from LeetCode
        char[][] matrix1 = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println("Maximal rectangle area for Matrix 1: " + solver.maximalRectangle(matrix1)); // Expected: 6

        // Test Case 2: All ones
        char[][] matrix2 = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        System.out.println("Maximal rectangle area for Matrix 2: " + solver.maximalRectangle(matrix2)); // Expected: 9

        // Test Case 3: All zeros
        char[][] matrix3 = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        System.out.println("Maximal rectangle area for Matrix 3: " + solver.maximalRectangle(matrix3)); // Expected: 0

        // Test Case 4: Single row, mixed
        char[][] matrix4 = {
            {'1', '0', '1', '1', '0', '1'}
        };
        System.out.println("Maximal rectangle area for Matrix 4: " + solver.maximalRectangle(matrix4)); // Expected: 2

        // Test Case 5: Single column, mixed
        char[][] matrix5 = {
            {'1'},
            {'0'},
            {'1'},
            {'1'}
        };
        System.out.println("Maximal rectangle area for Matrix 5: " + solver.maximalRectangle(matrix5)); // Expected: 2

        // Test Case 6: Empty matrix
        char[][] matrix6 = {};
        System.out.println("Maximal rectangle area for Matrix 6: " + solver.maximalRectangle(matrix6)); // Expected: 0

        // Test Case 7: Matrix with a single element
        char[][] matrix7 = {{'1'}};
        System.out.println("Maximal rectangle area for Matrix 7: " + solver.maximalRectangle(matrix7)); // Expected: 1
    }
}
