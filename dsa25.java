Q 25. Check if two strings are anagrams
import java.util.Arrays;

class AnagramChecker {

    public static boolean areAnagrams(String str1, String str2) {
        // If the lengths are different, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to char arrays
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // Sort the char arrays
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // If the sorted arrays are equal, the strings are anagrams
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        if (areAnagrams(str1, str2)) {
            System.out.println("\"" + str1 + "\" and \"" + str2 + "\" are anagrams.");
        } else {
            System.out.println("\"" + str1 + "\" and \"" + str2 + "\" are not anagrams.");
        }

        String str3 = "hello";
        String str4 = "world";
        if (areAnagrams(str3, str4)) {
            System.out.println("\"" + str3 + "\" and \"" + str4 + "\" are anagrams.");
        } else {
            System.out.println("\"" + str3 + "\" and \"" + str4 + "\" are not anagrams.");
        }
    }
}
---------------------------------------------------------------------------------------------------------------------------------------------------
  import java.util.Arrays;

class EasyAnagramChecker {

    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        String s1 = "racecar";
        String s2 = "carrace";
        System.out.println("\"" + s1 + "\" and \"" + s2 + "\" are anagrams: " + areAnagrams(s1, s2));

        String s3 = "apple";
        String s4 = "aplee";
        System.out.println("\"" + s3 + "\" and \"" + s4 + "\" are anagrams: " + areAnagrams(s3, s4));
    }
}
