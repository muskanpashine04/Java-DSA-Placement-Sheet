Q23. Remove duplicates from a string

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateChars {

    public static String removeDuplicates(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "programming";
        String result1 = removeDuplicates(str1);
        System.out.println("Original String: " + str1);
        System.out.println("After removing duplicates: " + result1); // Output: progamin

        String str2 = "aabbccddeeff";
        String result2 = removeDuplicates(str2);
        System.out.println("Original String: " + str2);
        System.out.println("After removing duplicates: " + result2); // Output: abcdef

        String str3 = "java";
        String result3 = removeDuplicates(str3);
        System.out.println("Original String: " + str3);
        System.out.println("After removing duplicates: " + result3); // Output: java
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------
  import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateCharsOrdered {

    public static String removeDuplicates(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Use LinkedHashSet to maintain the order of characters
        Set<Character> seen = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (seen.add(c)) { // add() returns true if the element was not already in the set
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "programming";
        String result1 = removeDuplicates(str1);
        System.out.println("Original String: " + str1);
        System.out.println("After removing duplicates (order preserved): " + result1); // Output: progamin

        String str2 = "aabbccddeeff";
        String result2 = removeDuplicates(str2);
        System.out.println("Original String: " + str2);
        System.out.println("After removing duplicates (order preserved): " + result2); // Output: abcdef

        String str3 = "java";
        String result3 = removeDuplicates(str3);
        System.out.println("Original String: " + str3);
        System.out.println("After removing duplicates (order preserved): " + result3); // Output: java
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
  public class RemoveDuplicatesSimple {

    public static String removeDuplicates(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            boolean seen = false;
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == currentChar) {
                    seen = true;
                    break;
                }
            }
            if (!seen) {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str1 = "programming";
        String result1 = removeDuplicates(str1);
        System.out.println("Original String: " + str1);
        System.out.println("After removing duplicates: " + result1); // Output: progamin

        String str2 = "aabbccddeeff";
        String result2 = removeDuplicates(str2);
        System.out.println("Original String: " + str2);
        System.out.println("After removing duplicates: " + result2); // Output: abcdef

        String str3 = "java";
        String result3 = removeDuplicates(str3);
        System.out.println("Original String: " + str3);
        System.out.println("After removing duplicates: " + result3); // Output: java
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
  public class RemoveDuplicatesNoStringBuilder {

    public static String removeDuplicates(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        char[] inputArray = input.toCharArray();
        int resultIndex = 0;

        for (int i = 0; i < inputArray.length; i++) {
            char currentChar = inputArray[i];
            boolean seen = false;
            for (int j = 0; j < resultIndex; j++) {
                if (inputArray[j] == currentChar) {
                    seen = true;
                    break;
                }
            }
            if (!seen) {
                inputArray[resultIndex++] = currentChar;
            }
        }
        return new String(inputArray, 0, resultIndex);
    }

    public static void main(String[] args) {
        String str1 = "programming";
        String result1 = removeDuplicates(str1);
        System.out.println("Original String: " + str1);
        System.out.println("After removing duplicates: " + result1); // Output: progamin

        String str2 = "aabbccddeeff";
        String result2 = removeDuplicates(str2);
        System.out.println("Original String: " + str2);
        System.out.println("After removing duplicates: " + result2); // Output: abcdef

        String str3 = "java";
        String result3 = removeDuplicates(str3);
        System.out.println("Original String: " + str3);
        System.out.println("After removing duplicates: " + result3); // Output: java
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------

  public class RemoveDuplicatesEasy {

    public static String removeDuplicates(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (result.indexOf(currentChar) == -1) {
                result += currentChar;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "programming";
        String uniqueStr = removeDuplicates(str);
        System.out.println("Original: " + str);
        System.out.println("Unique:   " + uniqueStr); // Output: progamin
    }
}
