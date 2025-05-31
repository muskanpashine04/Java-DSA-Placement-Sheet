public class CountAndSay {

    public static String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = getNext(result);
        }
        return result;
    }

    private static String getNext(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char currentChar = s.charAt(i);
            int count = 0;
            while (i < s.length() && s.charAt(i) == currentChar) {
                count++;
                i++;
            }
            sb.append(count).append(currentChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("n = " + i + ", Count and Say sequence: " + countAndSay(i));
        }
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------

  public class EasyCountAndSay {

    public static String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder nextS = new StringBuilder();
            int count = 1;
            for (int j = 0; j < s.length(); j++) {
                if (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                } else {
                    nextS.append(count).append(s.charAt(j));
                    count = 1;
                }
            }
            s = nextS.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("n = " + i + ", Count and Say: " + countAndSay(i));
        }
    }
}
---------------------------------------------------------------------------------------------------------------------------------------
  Output:

n = 1, Count and Say sequence: 1
n = 2, Count and Say sequence: 11
n = 3, Count and Say sequence: 21
n = 4, Count and Say sequence: 1211
n = 5, Count and Say sequence: 111221
n = 6, Count and Say sequence: 312211
n = 7, Count and Say sequence: 13112221
n = 8, Count and Say sequence: 1113213211
n = 9, Count and Say sequence: 31131211131221
n = 10, Count and Say sequence: 13211311122113111221
