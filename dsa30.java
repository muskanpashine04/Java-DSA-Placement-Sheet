public class ValidPalindromeII {

    /**
     * Checks if a string can be a palindrome after deleting at most one character.
     *
     * @param s The input string.
     * @return true if it can be a palindrome, false otherwise.
     */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // Mismatch found. We have two options:
                // 1. Remove the character at 'left' and check if the rest is a palindrome.
                // 2. Remove the character at 'right' and check if the rest is a palindrome.
                // If either of these forms a palindrome, then the original string is valid.
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        // If the loop completes, it means the string is already a palindrome (or empty/single char),
        // so no removals were needed, and it's valid.
        return true;
    }

    /**
     * Helper function to check if a substring is a palindrome.
     *
     * @param s The original string.
     * @param left The starting index of the substring.
     * @param right The ending index of the substring.
     * @return true if the substring from 'left' to 'right' (inclusive) is a palindrome, false otherwise.
     */
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // Mismatch found, not a palindrome
            }
            left++;
            right--;
        }
        return true; // All characters matched, it's a palindrome
    }

    public static void main(String[] args) {
        ValidPalindromeII solver = new ValidPalindromeII();

        // Test cases
        System.out.println("Test Case 1: \"aba\" -> " + solver.validPalindrome("aba")); // Expected: true
        System.out.println("Test Case 2: \"abca\" -> " + solver.validPalindrome("abca")); // Expected: true (remove 'b' or 'c')
        System.out.println("Test Case 3: \"abc\" -> " + solver.validPalindrome("abc")); // Expected: false
        System.out.println("Test Case 4: \"\" -> " + solver.validPalindrome("")); // Expected: true (empty string is a palindrome)
        System.out.println("Test Case 5: \"a\" -> " + solver.validPalindrome("a")); // Expected: true (single character is a palindrome)
        System.out.println("Test Case 6: \"ab\" -> " + solver.validPalindrome("ab")); // Expected: true (remove 'a' or 'b')
        System.out.println("Test Case 7: \"racecar\" -> " + solver.validPalindrome("racecar")); // Expected: true
        System.out.println("Test Case 8: \"cbbcc\" -> " + solver.validPalindrome("cbbcc")); // Expected: true (already a palindrome)
        System.out.println("Test Case 9: \"eedadcaeaadedeccbc\" -> " + solver.validPalindrome("eedadcaeaadedeccbc")); // Expected: false
        System.out.println("Test Case 10: \"eeccccbebaeeabebccceea\" -> " + solver.validPalindrome("eeccccbebaeeabebccceea")); // Expected: false
        System.out.println("Test Case 11: \"cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu\" -> " + solver.validPalindrome("cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu")); // Expected: true
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
public class SimpleSubstringSearch {

    /**
     * Finds the first occurrence of 'needle' within 'haystack'.
     *
     * @param haystack The string to search inside.
     * @param needle The string to search for.
     * @return The starting index of 'needle' in 'haystack', or -1 if not found.
     * Returns 0 if 'needle' is an empty string.
     */
    public int findString(String haystack, String needle) {
        // Handle edge cases first for simplicity
        if (needle == null || needle.isEmpty()) {
            return 0; // An empty string is always found at the beginning (index 0).
        }
        if (haystack == null || haystack.isEmpty()) {
            return -1; // If haystack is empty, and needle isn't, needle can't be found.
        }
        if (needle.length() > haystack.length()) {
            return -1; // If needle is longer than haystack, it can't be found.
        }

        // Loop through the haystack, checking each possible starting position
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean foundMatch = true; // Assume we've found a match at this 'i' position

            // Now, compare the characters of needle with the current part of haystack
            for (int j = 0; j < needle.length(); j++) {
                // If characters don't match, this isn't the right starting position
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    foundMatch = false; // It's not a match
                    break;             // Stop checking this 'i' position
                }
            }

            // If foundMatch is still true, it means all characters aligned!
            if (foundMatch) {
                return i; // Return the starting index where we found it
            }
        }

        // If we finish the outer loop and haven't returned, needle was not found
        return -1;
    }

    public static void main(String[] args) {
        SimpleSubstringSearch searcher = new SimpleSubstringSearch();

        // Let's test it out with some examples!

        System.out.println("--- Test Cases ---");

        // Example 1: Found in the middle
        String s1 = "hello";
        String p1 = "ll";
        System.out.println("Finding \"" + p1 + "\" in \"" + s1 + "\": " + searcher.findString(s1, p1)); // Expected: 2

        // Example 2: Not found
        String s2 = "aaaaa";
        String p2 = "bba";
        System.out.println("Finding \"" + p2 + "\" in \"" + s2 + "\": " + searcher.findString(s2, p2)); // Expected: -1

        // Example 3: Needle is empty
        String s3 = "abc";
        String p3 = "";
        System.out.println("Finding \"" + p3 + "\" in \"" + s3 + "\": " + searcher.findString(s3, p3)); // Expected: 0

        // Example 4: Needle at the beginning
        String s4 = "apple";
        String p4 = "app";
        System.out.println("Finding \"" + p4 + "\" in \"" + s4 + "\": " + searcher.findString(s4, p4)); // Expected: 0

        // Example 5: Needle at the end
        String s5 = "banana";
        String p5 = "ana";
        System.out.println("Finding \"" + p5 + "\" in \"" + s5 + "\": " + searcher.findString(s5, p5)); // Expected: 3

        // Example 6: Haystack shorter than needle
        String s6 = "hi";
        String p6 = "hello";
        System.out.println("Finding \"" + p6 + "\" in \"" + s6 + "\": " + searcher.findString(s6, p6)); // Expected: -1

        // Example 7: Single character match
        String s7 = "a";
        String p7 = "a";
        System.out.println("Finding \"" + p7 + "\" in \"" + s7 + "\": " + searcher.findString(s7, p7)); // Expected: 0
    }
}
