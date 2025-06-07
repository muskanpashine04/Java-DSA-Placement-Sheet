import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Finds the length of the longest substring without repeating characters.
     * Uses a sliding window approach with a HashMap to store character last seen index.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> charIndexMap = new HashMap<>(); // Stores char -> last seen index
        int maxLength = 0;
        int windowStart = 0; // Left pointer of the sliding window

        // Iterate through the string with the 'windowEnd' (right) pointer
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);

            // If the character is already in the map and its last seen index
            // is within the current window (>= windowStart),
            // then we have a repeating character.
            // Move the windowStart past the last occurrence of this character.
            if (charIndexMap.containsKey(rightChar) && charIndexMap.get(rightChar) >= windowStart) {
                windowStart = charIndexMap.get(rightChar) + 1;
            }

            // Update the character's last seen index in the map.
            charIndexMap.put(rightChar, windowEnd);

            // Calculate the current window length and update maxLength if it's larger.
            // Current window length = windowEnd - windowStart + 1
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

        // Test Cases
        System.out.println("--- Longest Substring Without Repeating Characters Tests ---");

        // Test Case 1: "abcabcbb" -> 3 ("abc")
        String s1 = "abcabcbb";
        System.out.println("Input: \"" + s1 + "\" -> Longest Substring Length: " + solution.lengthOfLongestSubstring(s1));
        // Expected Output: 3

        // Test Case 2: "bbbbb" -> 1 ("b")
        String s2 = "bbbbb";
        System.out.println("Input: \"" + s2 + "\" -> Longest Substring Length: " + solution.lengthOfLongestSubstring(s2));
        // Expected Output: 1

        // Test Case 3: "pwwkew" -> 3 ("wke" or "kew")
        String s3 = "pwwkew";
        System.out.println("Input: \"" + s3 + "\" -> Longest Substring Length: " + solution.lengthOfLongestSubstring(s3));
        // Expected Output: 3

        // Test Case 4: "" (empty string) -> 0
        String s4 = "";
        System.out.println("Input: \"" + s4 + "\" -> Longest Substring Length: " + solution.lengthOfLongestSubstring(s4));
        // Expected Output: 0

        // Test Case 5: "a" (single character) -> 1
        String s5 = "a";
        System.out.println("Input: \"" + s5 + "\" -> Longest Substring Length: " + solution.lengthOfLongestSubstring(s5));
        // Expected Output: 1

        // Test Case 6: "au" -> 2
        String s6 = "au";
        System.out.println("Input: \"" + s6 + "\" -> Longest Substring Length: " + solution.lengthOfLongestSubstring(s6));
        // Expected Output: 2

        // Test Case 7: "dvdf" -> 3 ("vdf")
        String s7 = "dvdf";
        System.out.println("Input: \"" + s7 + "\" -> Longest Substring Length: " + solution.lengthOfLongestSubstring(s7));
        // Expected Output: 3

        // Test Case 8: "tmmzuxt" -> 5 ("mzuxt")
        String s8 = "tmmzuxt";
        System.out.println("Input: \"" + s8 + "\" -> Longest Substring Length: " + solution.lengthOfLongestSubstring(s8));
        // Expected Output: 5

        // Test Case 9: "ohvhjdml" -> 6 ("vhjdml")
        String s9 = "ohvhjdml";
        System.out.println("Input: \"" + s9 + "\" -> Longest Substring Length: " + solution.lengthOfLongestSubstring(s9));
        // Expected Output: 6
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  public class SimpleStringReverser {

    /**
     * Reverses a given string.
     * For example, "hello" becomes "olleh".
     *
     * @param str The input string to be reversed.
     * @return The reversed string.
     */
    public String reverseString(String str) {
        // Handle null or empty strings, or strings with just one character
        if (str == null || str.isEmpty() || str.length() == 1) {
            return str; // Nothing to reverse, return as is
        }

        // StringBuilder is efficient for modifying strings in Java
        StringBuilder reversed = new StringBuilder();

        // Loop through the string from the last character to the first
        for (int i = str.length() - 1; i >= 0; i--) {
            // Append each character to the StringBuilder
            reversed.append(str.charAt(i));
        }

        // Convert the StringBuilder content back to a String and return
        return reversed.toString();
    }

    public static void main(String[] args) {
        SimpleStringReverser reverser = new SimpleStringReverser();

        System.out.println("--- String Reversal Examples ---");

        // Test Case 1: Basic string
        String s1 = "hello";
        System.out.println("Original: \"" + s1 + "\" -> Reversed: \"" + reverser.reverseString(s1) + "\""); // Expected: olleh

        // Test Case 2: Palindrome (should be the same)
        String s2 = "madam";
        System.out.println("Original: \"" + s2 + "\" -> Reversed: \"" + reverser.reverseString(s2) + "\""); // Expected: madam

        // Test Case 3: String with spaces
        String s3 = "hello world";
        System.out.println("Original: \"" + s3 + "\" -> Reversed: \"" + reverser.reverseString(s3) + "\""); // Expected: dlrow olleh

        // Test Case 4: Empty string
        String s4 = "";
        System.out.println("Original: \"" + s4 + "\" -> Reversed: \"" + reverser.reverseString(s4) + "\""); // Expected: ""

        // Test Case 5: Single character string
        String s5 = "a";
        System.out.println("Original: \"" + s5 + "\" -> Reversed: \"" + reverser.reverseString(s5) + "\""); // Expected: a

        // Test Case 6: String with numbers and symbols
        String s6 = "123!@#abc";
        System.out.println("Original: \"" + s6 + "\" -> Reversed: \"" + reverser.reverseString(s6) + "\""); // Expected: cba#!321

        // Test Case 7: String with mixed case
        String s7 = "JavaCode";
        System.out.println("Original: \"" + s7 + "\" -> Reversed: \"" + reverser.reverseString(s7) + "\""); // Expected: edoCavaJ
    }
}
