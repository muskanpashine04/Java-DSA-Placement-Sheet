public class SubsequenceChecker {

    /**
     * Checks if string s1 is a subsequence of string s2.
     *
     * @param s1 The potential subsequence string.
     * @param s2 The main string to check against.
     * @return true if s1 is a subsequence of s2, false otherwise.
     */
    public boolean isSubsequence(String s1, String s2) {
        // Handle null strings:
        // If s1 is null, it can only be a subsequence of s2 if s2 is also null.
        // If s2 is null but s1 is not, s1 cannot be a subsequence of s2.
        if (s1 == null || s2 == null) {
            return s1 == null && s2 == null;
        }

        // Handle empty strings:
        // An empty string is always a subsequence of any string (including another empty string).
        if (s1.isEmpty()) {
            return true;
        }

        // Use two pointers: one for s1 (i) and one for s2 (j)
        int i = 0; // Pointer for s1
        int j = 0; // Pointer for s2

        // Iterate through s2 (main string)
        while (i < s1.length() && j < s2.length()) {
            // If characters match, move the s1 pointer forward
            if (s1.charAt(i) == s2.charAt(j)) {
                i++; // Found a character from s1
            }
            // Always move the s2 pointer forward
            j++;
        }

        // If we have successfully iterated through all characters of s1 (i.e., i reaches s1.length()),
        // it means s1 is a subsequence of s2.
        return i == s1.length();
    }

    public static void main(String[] args) {
        SubsequenceChecker checker = new SubsequenceChecker();

        // Test Cases

        System.out.println("Test Case 1: Positive - Basic");
        String s1_1 = "ace";
        String s2_1 = "abcde";
        System.out.println("Is \"" + s1_1 + "\" a subsequence of \"" + s2_1 + "\"? " +
                           checker.isSubsequence(s1_1, s2_1)); // Expected: true

        System.out.println("\nTest Case 2: Positive - Contiguous");
        String s1_2 = "abc";
        String s2_2 = "abcde";
        System.out.println("Is \"" + s1_2 + "\" a subsequence of \"" + s2_2 + "\"? " +
                           checker.isSubsequence(s1_2, s2_2)); // Expected: true

        System.out.println("\nTest Case 3: Negative - Wrong Order");
        String s1_3 = "aec";
        String s2_3 = "abcde";
        System.out.println("Is \"" + s1_3 + "\" a subsequence of \"" + s2_3 + "\"? " +
                           checker.isSubsequence(s1_3, s2_3)); // Expected: false

        System.out.println("\nTest Case 4: Negative - Missing Character");
        String s1_4 = "axc";
        String s2_4 = "ahbgdc";
        System.out.println("Is \"" + s1_4 + "\" a subsequence of \"" + s2_4 + "\"? " +
                           checker.isSubsequence(s1_4, s2_4)); // Expected: false

        System.out.println("\nTest Case 5: Positive - Characters Spread Out");
        String s1_5 = "abc";
        String s2_5 = "axbyc";
        System.out.println("Is \"" + s1_5 + "\" a subsequence of \"" + s2_5 + "\"? " +
                           checker.isSubsequence(s1_5, s2_5)); // Expected: true

        System.out.println("\nTest Case 6: Empty s1 (Positive)");
        String s1_6 = "";
        String s2_6 = "abcde";
        System.out.println("Is \"" + s1_6 + "\" a subsequence of \"" + s2_6 + "\"? " +
                           checker.isSubsequence(s1_6, s2_6)); // Expected: true

        System.out.println("\nTest Case 7: Empty s2 (Negative if s1 not empty)");
        String s1_7 = "a";
        String s2_7 = "";
        System.out.println("Is \"" + s1_7 + "\" a subsequence of \"" + s2_7 + "\"? " +
                           checker.isSubsequence(s1_7, s2_7)); // Expected: false

        System.out.println("\nTest Case 8: Both Empty (Positive)");
        String s1_8 = "";
        String s2_8 = "";
        System.out.println("Is \"" + s1_8 + "\" a subsequence of \"" + s2_8 + "\"? " +
                           checker.isSubsequence(s1_8, s2_8)); // Expected: true

        System.out.println("\nTest Case 9: Null s1 (Negative if s2 not null)");
        String s1_9 = null;
        String s2_9 = "abc";
        System.out.println("Is \"" + s1_9 + "\" a subsequence of \"" + s2_9 + "\"? " +
                           checker.isSubsequence(s1_9, s2_9)); // Expected: false

        System.out.println("\nTest Case 10: Null s2 (Negative if s1 not null)");
        String s1_10 = "abc";
        String s2_10 = null;
        System.out.println("Is \"" + s1_10 + "\" a subsequence of \"" + s2_10 + "\"? " +
                           checker.isSubsequence(s1_10, s2_10)); // Expected: false

        System.out.println("\nTest Case 11: Both Null (Positive)");
        String s1_11 = null;
        String s2_11 = null;
        System.out.println("Is \"" + s1_11 + "\" a subsequence of \"" + s2_11 + "\"? " +
                           checker.isSubsequence(s1_11, s2_11)); // Expected: true
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
