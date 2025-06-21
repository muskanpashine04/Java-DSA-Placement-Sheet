Q 34. Check if a string is a rotation of another string
    public class StringRotationChecker {

    /**
     * Checks if one string is a rotation of another.
     *
     * @param s1 The first string.
     * @param s2 The second string.
     * @return true if s2 is a rotation of s1, false otherwise.
     */
    public boolean areRotations(String s1, String s2) {
        // 1. Check for null or empty strings:
        // If both are null, consider them rotations (or handle as per specific requirements).
        // If one is null and the other isn't, they can't be rotations.
        if (s1 == null || s2 == null) {
            return s1 == null && s2 == null;
        }

        // 2. Check if lengths are equal:
        // Rotations must have the same length.
        if (s1.length() != s2.length()) {
            return false;
        }

        // 3. Handle empty strings explicitly:
        // If both are empty, they are rotations of each other.
        if (s1.isEmpty()) { // Since lengths are equal, s2 will also be empty
            return true;
        }

        // 4. The core logic: Concatenate s1 with itself and check if s2 is a substring.
        // Example: s1 = "abcde", s2 = "cdeab"
        // s1s1 = "abcdeabcde"
        // "cdeab" is a substring of "abcdeabcde"
        String s1s1 = s1 + s1;

        return s1s1.contains(s2); // Java's String.contains() checks for substring presence.
    }

    public static void main(String[] args) {
        StringRotationChecker checker = new StringRotationChecker();

        // Test Cases
        System.out.println("Test Case 1: Positive (Standard Rotation)");
        String str1_1 = "abcde";
        String str1_2 = "cdeab";
        System.out.println("Are \"" + str1_1 + "\" and \"" + str1_2 + "\" rotations? " +
                           checker.areRotations(str1_1, str1_2)); // Expected: true

        System.out.println("\nTest Case 2: Positive (Another Rotation)");
        String str2_1 = "java";
        String str2_2 = "vaj"; // This is actually "vajava" in logic, not "java"
        System.out.println("Are \"" + str2_1 + "\" and \"" + str2_2 + "\" rotations? " +
                           checker.areRotations(str2_1, str2_2)); // Expected: false (incorrect rotation)

        System.out.println("\nTest Case 3: Positive (Self Rotation)");
        String str3_1 = "hello";
        String str3_2 = "hello";
        System.out.println("Are \"" + str3_1 + "\" and \"" + str3_2 + "\" rotations? " +
                           checker.areRotations(str3_1, str3_2)); // Expected: true

        System.out.println("\nTest Case 4: Negative (Different Lengths)");
        String str4_1 = "apple";
        String str4_2 = "ple";
        System.out.println("Are \"" + str4_1 + "\" and \"" + str4_2 + "\" rotations? " +
                           checker.areRotations(str4_1, str4_2)); // Expected: false

        System.out.println("\nTest Case 5: Negative (Not a Rotation)");
        String str5_1 = "waterbottle";
        String str5_2 = "erbottlewat"; // This is "erbottlewat"
        System.out.println("Are \"" + str5_1 + "\" and \"" + str5_2 + "\" rotations? " +
                           checker.areRotations(str5_1, str5_2)); // Expected: true (Correct rotation)

        System.out.println("\nTest Case 6: Negative (Similar but not rotation)");
        String str6_1 = "abc";
        String str6_2 = "acb";
        System.out.println("Are \"" + str6_1 + "\" and \"" + str6_2 + "\" rotations? " +
                           checker.areRotations(str6_1, str6_2)); // Expected: false

        System.out.println("\nTest Case 7: Empty Strings");
        String str7_1 = "";
        String str7_2 = "";
        System.out.println("Are \"" + str7_1 + "\" and \"" + str7_2 + "\" rotations? " +
                           checker.areRotations(str7_1, str7_2)); // Expected: true

        System.out.println("\nTest Case 8: One Empty, One Not");
        String str8_1 = "abc";
        String str8_2 = "";
        System.out.println("Are \"" + str8_1 + "\" and \"" + str8_2 + "\" rotations? " +
                           checker.areRotations(str8_1, str8_2)); // Expected: false

        System.out.println("\nTest Case 9: Null Strings");
        String str9_1 = null;
        String str9_2 = null;
        System.out.println("Are \"" + str9_1 + "\" and \"" + str9_2 + "\" rotations? " +
                           checker.areRotations(str9_1, str9_2)); // Expected: true (both null)

        System.out.println("\nTest Case 10: One Null, One Not");
        String str10_1 = "test";
        String str10_2 = null;
        System.out.println("Are \"" + str10_1 + "\" and \"" + str10_2 + "\" rotations? " +
                           checker.areRotations(str10_1, str10_2)); // Expected: false
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------

  
