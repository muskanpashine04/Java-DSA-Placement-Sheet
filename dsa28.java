Q 28. Convert string to integer (like atoi)
    public class MyAtoi {

    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int i = 0;
        int n = s.length();

        // 1. Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Handle case where string is all spaces
        if (i == n) {
            return 0;
        }

        // 2. Check for sign
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // 3. Convert digits and handle overflow
        long result = 0; // Use long to detect overflow before casting to int
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;

            // Check for overflow
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (-result) < Integer.MIN_VALUE) { // Using -result to compare with MIN_VALUE
                return Integer.MIN_VALUE;
            }
            i++;
        }

        return (int) (sign * result);
    }

    public static void main(String[] args) {
        MyAtoi converter = new MyAtoi();

        // Test cases
        System.out.println("Input: \"42\" -> Output: " + converter.myAtoi("42")); // Expected: 42
        System.out.println("Input: \"   -42\" -> Output: " + converter.myAtoi("   -42")); // Expected: -42
        System.out.println("Input: \"4193 with words\" -> Output: " + converter.myAtoi("4193 with words")); // Expected: 4193
        System.out.println("Input: \"words and 987\" -> Output: " + converter.myAtoi("words and 987")); // Expected: 0
        System.out.println("Input: \"-91283472332\" -> Output: " + converter.myAtoi("-91283472332")); // Expected: -2147483648 (Integer.MIN_VALUE)
        System.out.println("Input: \"91283472332\" -> Output: " + converter.myAtoi("91283472332")); // Expected: 2147483647 (Integer.MAX_VALUE)
        System.out.println("Input: \"+1\" -> Output: " + converter.myAtoi("+1")); // Expected: 1
        System.out.println("Input: \"-0\" -> Output: " + converter.myAtoi("-0")); // Expected: 0
        System.out.println("Input: \"   \" -> Output: " + converter.myAtoi("   ")); // Expected: 0
        System.out.println("Input: \"\" -> Output: " + converter.myAtoi("")); // Expected: 0
        System.out.println("Input: \"  -0012a42\" -> Output: " + converter.myAtoi("  -0012a42")); // Expected: -12
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  public class SimpleStringToInt {

    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "-456";
        String str3 = "0";
        // String str4 = "abc"; // This would cause an error!

        try {
            int num1 = Integer.parseInt(str1);
            System.out.println("Converted '" + str1 + "' to integer: " + num1);

            int num2 = Integer.parseInt(str2);
            System.out.println("Converted '" + str2 + "' to integer: " + num2);

            int num3 = Integer.parseInt(str3);
            System.out.println("Converted '" + str3 + "' to integer: " + num3);

            // This line would throw a NumberFormatException because "abc" is not a valid integer.
            // int num4 = Integer.parseInt(str4);
            // System.out.println("Converted '" + str4 + "' to integer: " + num4);

        } catch (NumberFormatException e) {
            System.err.println("Error: Cannot convert string to integer. Invalid format.");
            System.err.println(e.getMessage());
        }
    }
}
