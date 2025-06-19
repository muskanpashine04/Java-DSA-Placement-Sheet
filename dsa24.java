Q 24. Print all permutations of a string
import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public static List<String> permute(String str) {
        List<String> permutations = new ArrayList<>();
        permuteHelper(str.toCharArray(), 0, permutations);
        return permutations;
    }

    private static void permuteHelper(char[] arr, int l, List<String> permutations) {
        if (l == arr.length - 1) {
            permutations.add(new String(arr));
        } else {
            for (int i = l; i < arr.length; i++) {
                swap(arr, l, i);
                permuteHelper(arr, l + 1, permutations);
                swap(arr, l, i); // backtrack
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> allPermutations = permute(str);
        System.out.println("Permutations of \"" + str + "\":");
        for (String permutation : allPermutations) {
            System.out.println(permutation);
        }

        String str2 = "ab";
        List<String> allPermutations2 = permute(str2);
        System.out.println("\nPermutations of \"" + str2 + "\":");
        for (String permutation : allPermutations2) {
            System.out.println(permutation);
        }

        String str3 = "aab"; // Example with duplicate characters
        List<String> allPermutations3 = permute(str3);
        System.out.println("\nPermutations of \"" + str3 + "\":");
        for (String permutation : allPermutations3) {
            System.out.println(permutation);
        }
    }
}
----------------------------------------------------------------------------------------------------------------------------------------
  import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EasyStringPermutations {

    public static Set<String> permute(String str) {
        Set<String> permutations = new HashSet<>();
        if (str == null || str.isEmpty()) {
            permutations.add("");
            return permutations;
        }
        char first = str.charAt(0);
        String rest = str.substring(1);
        Set<String> subPermutations = permute(rest);
        for (String permutation : subPermutations) {
            for (int i = 0; i <= permutation.length(); i++) {
                String newPermutation = permutation.substring(0, i) + first + permutation.substring(i);
                permutations.add(newPermutation);
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        String str = "abc";
        Set<String> allPermutations = permute(str);
        System.out.println("Permutations of \"" + str + "\":");
        for (String permutation : allPermutations) {
            System.out.println(permutation);
        }

        String str2 = "ab";
        Set<String> allPermutations2 = permute(str2);
        System.out.println("\nPermutations of \"" + str2 + "\":");
        for (String permutation : allPermutations2) {
            System.out.println(permutation);
        }

        String str3 = "aab"; // Example with duplicate characters
        Set<String> allPermutations3 = permute(str3);
        System.out.println("\nPermutations of \"" + str3 + "\":");
        for (String permutation : allPermutations3) {
            System.out.println(permutation);
        }
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  public class StringPermutationsNoImport {

    public static void permute(String str) {
        permuteHelper(str.toCharArray(), 0);
    }

    private static void permuteHelper(char[] arr, int l) {
        if (l == arr.length - 1) {
            System.out.println(new String(arr));
        } else {
            for (int i = l; i < arr.length; i++) {
                swap(arr, l, i);
                permuteHelper(arr, l + 1);
                swap(arr, l, i); // backtrack
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println("Permutations of \"" + str + "\":");
        permute(str);

        String str2 = "ab";
        System.out.println("\nPermutations of \"" + str2 + "\":");
        permute(str2);

        String str3 = "aab"; // Example with duplicate characters (will print duplicates)
        System.out.println("\nPermutations of \"" + str3 + "\":");
        permute(str3);
    }
}
