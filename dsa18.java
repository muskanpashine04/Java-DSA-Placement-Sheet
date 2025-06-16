Q18. Trapping Rain Water

public class TrappingRainWater {

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int waterTrapped = 0;

        // Calculate the maximum height to the left for each element
        leftMax[0] = 0;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        // Calculate the maximum height to the right for each element
        rightMax[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        // Calculate the trapped water at each position
        for (int i = 0; i < n; i++) {
            int boundary = Math.min(leftMax[i], rightMax[i]);
            if (boundary > height[i]) {
                waterTrapped += boundary - height[i];
            }
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped water for height1: " + trap(height1)); // Output: 6

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println("Trapped water for height2: " + trap(height2)); // Output: 9

        int[] height3 = {2, 0, 2};
        System.out.println("Trapped water for height3: " + trap(height3));   // Output: 2

        int[] height4 = {3, 0, 1, 0, 3};
        System.out.println("Trapped water for height4: " + trap(height4));   // Output: 8

        int[] height5 = {5, 4, 3, 2, 1};
        System.out.println("Trapped water for height5: " + trap(height5));   // Output: 0
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  public class TrappingRainWaterEasy {

    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int trappedWater = 0;

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            if (waterLevel > height[i]) {
                trappedWater += waterLevel - height[i];
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped water for height1: " + trap(height1));

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println("Trapped water for height2: " + trap(height2));
    }
}
