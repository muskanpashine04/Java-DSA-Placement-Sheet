Q 21. Reverse a string

class ReverseString {
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        String reversedString = reverseString(input);
        System.out.println("Original string: " + input);
        System.out.println("Reversed string: " + reversedString); // Output: olleh

        input = "Java";
        reversedString = reverseString(input);
        System.out.println("Original string: " + input);
        System.out.println("Reversed string: " + reversedString); // Output: avaJ
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  class ReverseStringWithoutBuiltin {
    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            // Swap characters at left and right indices
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Move indices towards the center
            left++;
            right--;
        }

        // Convert the reversed char array back to a String
        return new String(charArray);
    }

    public static void main(String[] args) {
        String input = "world";
        String reversedString = reverseString(input);
        System.out.println("Original string: " + input);
        System.out.println("Reversed string: " + reversedString); // Output: dlrow

        input = "racecar";
        reversedString = reverseString(input);
        System.out.println("Original string: " + input);
        System.out.println("Reversed string: " + reversedString); // Output: racecar
    }
}
