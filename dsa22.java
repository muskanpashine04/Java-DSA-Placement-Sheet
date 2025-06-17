Q 22. Check for palindrome


class EasyPalindromeChecker {
    public static boolean isPalindrome(String str) {
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }

    public static void main(String[] args) {
        String test1 = "madam";
        System.out.println("\"" + test1 + "\" is a palindrome: " + isPalindrome(test1));

        String test2 = "hello";
        System.out.println("\"" + test2 + "\" is a palindrome: " + isPalindrome(test2));
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

  class PalindromeCheckerNoBuiltin {
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "madam";
        System.out.println("\"" + test1 + "\" is a palindrome: " + isPalindrome(test1));

        String test2 = "hello";
        System.out.println("\"" + test2 + "\" is a palindrome: " + isPalindrome(test2));

        String test3 = "level";
        System.out.println("\"" + test3 + "\" is a palindrome: " + isPalindrome(test3));
    }
}
