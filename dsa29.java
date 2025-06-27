Q 29. Implement strstr() (substring search)
    
    public class StrStrImplementation {

    /**
     * Implements the strstr() function (substring search) using a brute-force approach.
     * Searches for the first occurrence of the 'needle' string within the 'haystack' string.
     *
     * @param haystack The string to be searched.
     * @param needle The string to search for.
     * @return The index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * Returns 0 if needle is an empty string.
     */
    public int strStr(String haystack, String needle) {
        // Handle edge cases
        if (needle == null || needle.isEmpty()) {
            return 0; // As per convention, return 0 if needle is empty
        }
        if (haystack == null || haystack.isEmpty()) {
            return -1; // If haystack is empty and needle is not, needle cannot be found
        }
        if (needle.length() > haystack.length()) {
            return -1; // Needle cannot be longer than haystack
        }

        int n = haystack.length();
        int m = needle.length();

        // Iterate through the haystack
        for (int i = 0; i <= n - m; i++) {
            // Assume a match for the current starting position
            boolean match = true;
            // Compare characters of needle with the current segment of haystack
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false; // Mismatch found, break inner loop
                    break;
                }
            }
            // If all characters matched, return the starting index
            if (match) {
                return i;
            }
        }

        // If no match was found after checking all possible starting positions
        return -1;
    }

    public static void main(String[] args) {
        StrStrImplementation solution = new StrStrImplementation();

        // Test cases
        System.out.println("Test Case 1:");
        String haystack1 = "hello";
        String needle1 = "ll";
        System.out.println("Haystack: \"" + haystack1 + "\", Needle: \"" + needle1 + "\" -> " + solution.strStr(haystack1, needle1)); // Expected: 2

        System.out.println("\nTest Case 2:");
        String haystack2 = "aaaaa";
        String needle2 = "bba";
        System.out.println("Haystack: \"" + haystack2 + "\", Needle: \"" + needle2 + "\" -> " + solution.strStr(haystack2, needle2)); // Expected: -1

        System.out.println("\nTest Case 3:");
        String haystack3 = "";
        String needle3 = "";
        System.out.println("Haystack: \"" + haystack3 + "\", Needle: \"" + needle3 + "\" -> " + solution.strStr(haystack3, needle3)); // Expected: 0

        System.out.println("\nTest Case 4:");
        String haystack4 = "abc";
        String needle4 = "";
        System.out.println("Haystack: \"" + haystack4 + "\", Needle: \"" + needle4 + "\" -> " + solution.strStr(haystack4, needle4)); // Expected: 0

        System.out.println("\nTest Case 5:");
        String haystack5 = "programming";
        String needle5 = "gram";
        System.out.println("Haystack: \"" + haystack5 + "\", Needle: \"" + needle5 + "\" -> " + solution.strStr(haystack5, needle5)); // Expected: 3

        System.out.println("\nTest Case 6:");
        String haystack6 = "apple";
        String needle6 = "app";
        System.out.println("Haystack: \"" + haystack6 + "\", Needle: \"" + needle6 + "\" -> " + solution.strStr(haystack6, needle6)); // Expected: 0

        System.out.println("\nTest Case 7:");
        String haystack7 = "abcdef";
        String needle7 = "defg";
        System.out.println("Haystack: \"" + haystack7 + "\", Needle: \"" + needle7 + "\" -> " + solution.strStr(haystack7, needle7)); // Expected: -1

        System.out.println("\nTest Case 8:");
        String haystack8 = "a";
        String needle8 = "a";
        System.out.println("Haystack: \"" + haystack8 + "\", Needle: \"" + needle8 + "\" -> " + solution.strStr(haystack8, needle8)); // Expected: 0

        System.out.println("\nTest Case 9:");
        String haystack9 = "mississippi";
        String needle9 = "issip";
        System.out.println("Haystack: \"" + haystack9 + "\", Needle: \"" + needle9 + "\" -> " + solution.strStr(haystack9, needle9)); // Expected: 4
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
public class SubstringSearch {

    /**
     * Finds the first occurrence of the 'needle' string within the 'haystack' string.
     * This is a simple, brute-force implementation of strstr().
     *
     * @param haystack The string to search within.
     * @param needle The string to search for.
     * @return The starting index of the first occurrence of needle in haystack,
     * or -1 if needle is not found.
     * Returns 0 if needle is an empty string.
     */
    public int findSubstring(String haystack, String needle) {
        // Handle cases where needle is empty or null
        if (needle == null || needle.isEmpty()) {
            return 0; // An empty string is considered found at index 0
        }

        // Handle cases where haystack is empty or null, but needle is not
        if (haystack == null || haystack.isEmpty()) {
            return -1; // If haystack is empty and needle isn't, needle can't be found
        }

        int n = haystack.length();
        int m = needle.length();

        // If needle is longer than haystack, it can't be a substring
        if (m > n) {
            return -1;
        }

        // Iterate through the haystack
        // The loop goes up to n - m because that's the last possible starting
        // position for needle in haystack.
        for (int i = 0; i <= n - m; i++) {
            boolean match = true; // Assume a match for the current starting position

            // Compare characters of needle with the current segment of haystack
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false; // Mismatch found, break inner loop
                    break;
                }
            }

            // If all characters matched, we found the substring
            if (match) {
                return i; // Return the starting index
            }
        }

        // If the loop finishes without finding a match, return -1
        return -1;
    }

    public static void main(String[] args) {
        SubstringSearch searcher = new SubstringSearch();

        // --- Test Cases ---

        // Example 1: Basic match
        System.out.println("Test 1 (Found): " + searcher.findSubstring("hello", "ll")); // Expected: 2

        // Example 2: No match
        System.out.println("Test 2 (Not Found): " + searcher.findSubstring("aaaaa", "bba")); // Expected: -1

        // Example 3: Empty needle
        System.out.println("Test 3 (Empty Needle): " + searcher.findSubstring("abc", "")); // Expected: 0

        // Example 4: Empty haystack and empty needle
        System.out.println("Test 4 (Both Empty): " + searcher.findSubstring("", "")); // Expected: 0

        // Example 5: Needle at the beginning
        System.out.println("Test 5 (Start Match): " + searcher.findSubstring("apple", "app")); // Expected: 0

        // Example 6: Needle at the end
        System.out.println("Test 6 (End Match): " + searcher.findSubstring("banana", "ana")); // Expected: 3

        // Example 7: Haystack shorter than needle
        System.out.println("Test 7 (Haystack Shorter): " + searcher.findSubstring("hi", "hello")); // Expected: -1

        // Example 8: Single character match
        System.out.println("Test 8 (Single Char Match): " + searcher.findSubstring("a", "a")); // Expected: 0

        // Example 9: No match, but partial matches
        System.out.println("Test 9 (Partial Match): " + searcher.findSubstring("mississippi", "issipi")); // Expected: -1
    }
}
