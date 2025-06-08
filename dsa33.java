import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGrouper {

    /**
     * Groups a list of strings into lists of anagrams.
     *
     * @param strs An array of strings to be grouped.
     * @return A list of lists, where each inner list contains anagrams.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Using a HashMap to store sorted string as key and a list of its anagrams as value
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            // Convert the string to a char array, sort it, and convert back to a string.
            // This sorted string will be our canonical key for anagrams.
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // If the sorted string (key) is not yet in the map, add it with a new list.
            anagramMap.putIfAbsent(sortedStr, new ArrayList<>());

            // Add the original string to the list associated with its sorted key.
            anagramMap.get(sortedStr).add(str);
        }

        // Return all the values (lists of anagrams) from the map.
        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        AnagramGrouper grouper = new AnagramGrouper();

        // Test cases
        String[] words1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Input: " + Arrays.toString(words1));
        List<List<String>> result1 = grouper.groupAnagrams(words1);
        System.out.println("Output: " + result1);
        // Expected Output (order of inner lists and elements within them may vary):
        // [[bat], [nat, tan], [ate, eat, tea]] or similar

        System.out.println("---");

        String[] words2 = {"", ""};
        System.out.println("Input: " + Arrays.toString(words2));
        List<List<String>> result2 = grouper.groupAnagrams(words2);
        System.out.println("Output: " + result2);
        // Expected Output: [["", ""]]

        System.out.println("---");

        String[] words3 = {"a"};
        System.out.println("Input: " + Arrays.toString(words3));
        List<List<String>> result3 = grouper.groupAnagrams(words3);
        System.out.println("Output: " + result3);
        // Expected Output: [["a"]]

        System.out.println("---");

        String[] words4 = {}; // Empty array
        System.out.println("Input: " + Arrays.toString(words4));
        List<List<String>> result4 = grouper.groupAnagrams(words4);
        System.out.println("Output: " + result4);
        // Expected Output: []
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EasyAnagramGrouper {

    /**
     * Groups a list of strings into lists of anagrams.
     * This version emphasizes clarity for easy understanding.
     *
     * @param strs An array of strings to be grouped.
     * @return A list of lists, where each inner list contains anagrams.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // Handle edge cases: if the input array is empty or null, return an empty list.
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // We'll use a HashMap to store our anagram groups.
        // The 'key' will be the sorted version of a word (e.g., "aet" for "eat", "tea", "ate").
        // The 'value' will be a list of all the original words that produce that sorted key.
        Map<String, List<String>> anagramGroups = new HashMap<>();

        // Loop through each word in the input array.
        for (String currentWord : strs) {
            // Step 1: Create a "canonical" (standard) form of the word.
            // This is done by converting the word to a character array, sorting it,
            // and then converting it back to a string.
            char[] charArray = currentWord.toCharArray(); // Convert to character array
            Arrays.sort(charArray);                       // Sort the characters alphabetically
            String sortedWord = new String(charArray);    // Convert back to a string (this is our key)

            // Step 2: Check if this sorted word (our key) already exists in our map.
            List<String> listOfAnagrams;
            if (anagramGroups.containsKey(sortedWord)) {
                // If the key exists, it means we've already encountered anagrams for this sorted word.
                // Get the existing list of anagrams.
                listOfAnagrams = anagramGroups.get(sortedWord);
            } else {
                // If the key does not exist, it's the first time we've seen an anagram for this sorted word.
                // Create a brand new list to store its anagrams.
                listOfAnagrams = new ArrayList<>();
                // Put this new list into the map, associated with our sorted word key.
                anagramGroups.put(sortedWord, listOfAnagrams);
            }

            // Step 3: Add the original word to its corresponding list of anagrams.
            listOfAnagrams.add(currentWord);
        }

        // After processing all words, the map contains all our anagram groups.
        // We just need to collect all the lists (the values from the map) and return them.
        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {
        EasyAnagramGrouper grouper = new EasyAnagramGrouper();

        // Test with some example words
        String[] words1 = {"listen", "silent", "enlist", "hello", "world", "olleh"};
        System.out.println("Input words: " + Arrays.toString(words1));
        List<List<String>> result1 = grouper.groupAnagrams(words1);
        System.out.println("Grouped Anagrams: " + result1);
        // Expected: [[listen, silent, enlist], [world], [olleh, hello]] (order might vary)

        System.out.println("\n--- Another Test Case ---");
        String[] words2 = {"top", "pot", "opt", "cat", "act", "tac"};
        System.out.println("Input words: " + Arrays.toString(words2));
        List<List<String>> result2 = grouper.groupAnagrams(words2);
        System.out.println("Grouped Anagrams: " + result2);
        // Expected: [[top, pot, opt], [cat, act, tac]] (order might vary)
    }
}
