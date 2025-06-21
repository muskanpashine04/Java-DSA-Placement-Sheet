Q 31. Compress the string (like Leetcode 443)
    import java.util.Arrays;

public class StringCompression {

    /**
     * Compresses a character array in-place. The compressed length is returned.
     * For example, if chars = ["a","a","b","b","c","c","c"], the function should modify
     * chars to ["a","2","b","2","c","3"] and return 6.
     *
     * @param chars The character array to be compressed.
     * @return The new length of the compressed array.
     */
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int writeIndex = 0; // Pointer for where to write the compressed characters
        int readIndex = 0;  // Pointer for reading through the original array

        while (readIndex < chars.length) {
            char currentChar = chars[readIndex];
            int count = 0;

            // Count consecutive occurrences of the current character
            while (readIndex < chars.length && chars[readIndex] == currentChar) {
                readIndex++;
                count++;
            }

            // Write the character itself
            chars[writeIndex++] = currentChar;

            // If count is greater than 1, append the count
            if (count > 1) {
                // Convert count to string and then to character array
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[writeIndex++] = c;
                }
            }
        }

        return writeIndex; // writeIndex now represents the new length
    }

    public static void main(String[] args) {
        StringCompression compressor = new StringCompression();

        // Test Cases

        System.out.println("--- String Compression Tests ---");

        // Test Case 1: Basic compression
        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int newLength1 = compressor.compress(chars1);
        System.out.println("Original: " + Arrays.toString(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println("Compressed: " + Arrays.toString(Arrays.copyOfRange(chars1, 0, newLength1)) + ", New Length: " + newLength1);
        // Expected: ["a","2","b","2","c","3"], 6

        System.out.println();

        // Test Case 2: No compression needed (all unique characters)
        char[] chars2 = {'a', 'b', 'c'};
        int newLength2 = compressor.compress(chars2);
        System.out.println("Original: " + Arrays.toString(new char[]{'a', 'b', 'c'}));
        System.out.println("Compressed: " + Arrays.toString(Arrays.copyOfRange(chars2, 0, newLength2)) + ", New Length: " + newLength2);
        // Expected: ["a","b","c"], 3

        System.out.println();

        // Test Case 3: All same characters
        char[] chars3 = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'}; // 12 'a's
        int newLength3 = compressor.compress(chars3);
        System.out.println("Original: " + Arrays.toString(new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'}));
        System.out.println("Compressed: " + Arrays.toString(Arrays.copyOfRange(chars3, 0, newLength3)) + ", New Length: " + newLength3);
        // Expected: ["a","1","2"], 3 (12 is "1" then "2")

        System.out.println();

        // Test Case 4: Single character
        char[] chars4 = {'s'};
        int newLength4 = compressor.compress(chars4);
        System.out.println("Original: " + Arrays.toString(new char[]{'s'}));
        System.out.println("Compressed: " + Arrays.toString(Arrays.copyOfRange(chars4, 0, newLength4)) + ", New Length: " + newLength4);
        // Expected: ["s"], 1

        System.out.println();

        // Test Case 5: Empty array
        char[] chars5 = {};
        int newLength5 = compressor.compress(chars5);
        System.out.println("Original: " + Arrays.toString(new char[]{}));
        System.out.println("Compressed: " + Arrays.toString(Arrays.copyOfRange(chars5, 0, newLength5)) + ", New Length: " + newLength5);
        // Expected: [], 0

        System.out.println();

        // Test Case 6: Mixed characters and counts
        char[] chars6 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c'}; // a, 12 'b's, 2 'c's
        int newLength6 = compressor.compress(chars6);
        System.out.println("Original: " + Arrays.toString(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c'}));
        System.out.println("Compressed: " + Arrays.toString(Arrays.copyOfRange(chars6, 0, newLength6)) + ", New Length: " + newLength6);
        // Expected: ["a","b","1","2","c","2"], 6

        System.out.println();

        // Test Case 7: Longer string with varied counts
        char[] chars7 = {'o','o','o','o','o','o','o','o','o','o','o','o','p','p','p','p','p','p','p','p','p','p','p','p','p','p','r','r','r','r','r','r','r','r','r','r','r','r','r','r','r','r','s','s','s','s','s','s','s','s','s','s','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','v','v','v','v','v','v','v','v','v','v','v','v','v','v','v','v','v','v','v','v','v','v','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z','z'};
        int newLength7 = compressor.compress(chars7);
        System.out.println("Original: (long string)");
        System.out.println("Compressed: " + Arrays.toString(Arrays.copyOfRange(chars7, 0, newLength7)) + ", New Length: " + newLength7);
        // Expected: ["o","1","2","p","1","4","r","1","6","s","1","0","t","1","8","v","2","2","w","3","2","x","3","5","y","5","6","z","6","6"], 26
    }
}
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  public class SimpleSubstringSearch {

    /**
     * Finds the first occurrence of 'needle' within 'haystack'.
     * This method works by checking every possible starting position in 'haystack'.
     *
     * @param haystack The string you want to search inside.
     * @param needle The string you are looking for.
     * @return The starting index where 'needle' is found in 'haystack'.
     * Returns -1 if 'needle' is not found.
     * Returns 0 if 'needle' is an empty string (as per convention).
     */
    public int findString(String haystack, String needle) {
        // --- Handle special situations first ---

        // If the needle is empty, it's considered found at the very beginning (index 0).
        if (needle == null || needle.isEmpty()) {
            return 0;
        }

        // If the haystack is empty, and the needle isn't, the needle can't be found.
        if (haystack == null || haystack.isEmpty()) {
            return -1;
        }

        // If the needle is longer than the haystack, it's impossible to find.
        if (needle.length() > haystack.length()) {
            return -1;
        }

        // --- Now, let's do the actual search ---

        // This loop goes through each possible starting point in the 'haystack'.
        // 'i' represents the current starting index in 'haystack' where 'needle' might begin.
        // We stop at 'haystack.length() - needle.length()' because if 'i' goes past that,
        // there won't be enough characters left in 'haystack' to form the 'needle'.
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            // We assume a match for the current starting position 'i' until proven otherwise.
            boolean foundMatch = true;

            // This inner loop compares characters of the 'needle' with the part of 'haystack'
            // that starts at 'i'.
            // 'j' goes through each character of the 'needle'.
            for (int j = 0; j < needle.length(); j++) {
                // If the character in 'haystack' at position (i + j)
                // doesn't match the character in 'needle' at position 'j',
                // then this is not a match for this starting point 'i'.
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    foundMatch = false; // Mark that no match was found for this 'i'.
                    break;             // Stop checking this 'i' and move to the next.
                }
            }

            // If 'foundMatch' is still true here, it means all characters of 'needle'
            // matched perfectly with 'haystack' starting at index 'i'.
            if (foundMatch) {
                return i; // We found it! Return the starting index.
            }
        }

        // If the outer loop finishes without finding any match,
        // it means the 'needle' is not present in the 'haystack'.
        return -1;
    }

    public static void main(String[] args) {
        SimpleSubstringSearch searcher = new SimpleSubstringSearch();

        System.out.println("--- Substring Search Examples ---");

        // Example 1: Basic case, needle found in the middle
        String h1 = "hello";
        String n1 = "ll";
        System.out.println("Finding \"" + n1 + "\" in \"" + h1 + "\": " + searcher.findString(h1, n1)); // Expected: 2

        // Example 2: Needle not found
        String h2 = "aaaaa";
        String n2 = "bba";
        System.out.println("Finding \"" + n2 + "\" in \"" + h2 + "\": " + searcher.findString(h2, n2)); // Expected: -1

        // Example 3: Empty needle (convention says it's found at index 0)
        String h3 = "abc";
        String n3 = "";
        System.out.println("Finding \"" + n3 + "\" in \"" + h3 + "\": " + searcher.findString(h3, n3)); // Expected: 0

        // Example 4: Needle found at the beginning
        String h4 = "apple";
        String n4 = "app";
        System.out.println("Finding \"" + n4 + "\" in \"" + h4 + "\": " + searcher.findString(h4, n4)); // Expected: 0

        // Example 5: Needle found at the end
        String h5 = "banana";
        String n5 = "ana";
        System.out.println("Finding \"" + n5 + "\" in \"" + h5 + "\": " + searcher.findString(h5, n5)); // Expected: 3

        // Example 6: Haystack is shorter than needle (impossible to find)
        String h6 = "hi";
        String n6 = "hello";
        System.out.println("Finding \"" + n6 + "\" in \"" + h6 + "\": " + searcher.findString(h6, n6)); // Expected: -1

        // Example 7: Single character match
        String h7 = "a";
        String n7 = "a";
        System.out.println("Finding \"" + n7 + "\" in \"" + h7 + "\": " + searcher.findString(h7, n7)); // Expected: 0
    }
}
