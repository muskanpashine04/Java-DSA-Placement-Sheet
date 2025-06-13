public class NumberOfIslands {

    /**
     * Counts the number of islands in a 2D binary grid using DFS.
     *
     * @param grid The 2D character array representing the grid. '1' is land, '0' is water.
     * @return The total number of islands.
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        int numIslands = 0;

        // Iterate through each cell in the grid
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                // If we find a '1', it means we've found part of an island
                if (grid[r][c] == '1') {
                    numIslands++; // Increment island count
                    // Start DFS to mark all connected land cells as visited
                    dfs(grid, r, c);
                }
            }
        }

        return numIslands;
    }

    /**
     * Performs a Depth First Search (DFS) starting from a given cell (r, c).
     * It marks all connected '1's (land) as '0' (water) to avoid recounting.
     *
     * @param grid The 2D character array representing the grid.
     * @param r    The current row.
     * @param c    The current column.
     */
    private void dfs(char[][] grid, int r, int c) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        // Base cases for DFS:
        // 1. Out of bounds
        // 2. Current cell is water ('0')
        // 3. Current cell has already been visited (marked as '0' by a previous DFS)
        if (r < 0 || r >= numRows || c < 0 || c >= numCols || grid[r][c] == '0') {
            return;
        }

        // Mark the current cell as visited (change '1' to '0')
        grid[r][c] = '0';

        // Recursively call DFS for all 4 adjacent neighbors (up, down, left, right)
        dfs(grid, r + 1, c); // Down
        dfs(grid, r - 1, c); // Up
        dfs(grid, r, c + 1); // Right
        dfs(grid, r, c - 1); // Left
    }

    public static void main(String[] args) {
        NumberOfIslands solver = new NumberOfIslands();

        // Test Case 1
        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println("Number of islands in Grid 1: " + solver.numIslands(grid1)); // Expected: 1

        // Test Case 2
        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands in Grid 2: " + solver.numIslands(grid2)); // Expected: 3

        // Test Case 3 (Empty grid)
        char[][] grid3 = {};
        System.out.println("Number of islands in Grid 3: " + solver.numIslands(grid3)); // Expected: 0

        // Test Case 4 (Grid with only water)
        char[][] grid4 = {
            {'0', '0'},
            {'0', '0'}
        };
        System.out.println("Number of islands in Grid 4: " + solver.numIslands(grid4)); // Expected: 0

        // Test Case 5 (Single island)
        char[][] grid5 = {
            {'1'}
        };
        System.out.println("Number of islands in Grid 5: " + solver.numIslands(grid5)); // Expected: 1
    }
}
