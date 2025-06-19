Q 27. Longest common prefix
    class Solution {
    /**
     * Finds the longest common prefix of an array of strings.
     *
     * @param strs The input array of strings.
     * @return The longest common prefix, or an empty string if there is none.
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Assume the first string is the initial prefix
        String prefix = strs[0];

        // Iterate through the rest of the strings
        for (int i = 1; i < strs.length; i++) {
            // While the current string doesn't start with the current prefix,
            // shorten the prefix by one character from the end.
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                // If the prefix becomes empty, there's no common prefix.
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Longest common prefix of " + java.util.Arrays.toString(strs1) + ": " + solution.longestCommonPrefix(strs1)); // Output: fl

        // Test case 2
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Longest common prefix of " + java.util.Arrays.toString(strs2) + ": " + solution.longestCommonPrefix(strs2)); // Output:

        // Test case 3
        String[] strs3 = {"apple", "apricot", "april"};
        System.out.println("Longest common prefix of " + java.util.Arrays.toString(strs3) + ": " + solution.longestCommonPrefix(strs3)); // Output: ap

        // Test case 4
        String[] strs4 = {"a"};
        System.out.println("Longest common prefix of " + java.util.Arrays.toString(strs4) + ": " + solution.longestCommonPrefix(strs4)); // Output: a

        // Test case 5
        String[] strs5 = {"", "b"};
        System.out.println("Longest common prefix of " + java.util.Arrays.toString(strs5) + ": " + solution.longestCommonPrefix(strs5)); // Output:
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest common prefix: " + solution.longestCommonPrefix(strs)); // Output: fl
    }
}
