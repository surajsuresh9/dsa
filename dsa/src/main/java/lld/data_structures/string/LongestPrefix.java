package lld.data_structures.string;

public class LongestPrefix {
    public static void main(String[] args) {
        String[] words = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println(getLongestPrefix(words));
    }

    private static String getLongestPrefix(String[] words) {
        String prefix = words[0];
        for (int i = 1; i < words.length; i++) {
            prefix = getPrefix(words[i], prefix);
            if (prefix.isEmpty()) {
                return "";
            }
        }
        return prefix;
    }

    static String getPrefix(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && i < s2.length()
                && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }

    private static String[] sort(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() > words[j].length()) {
                    String t = words[i];
                    words[i] = words[j];
                    words[j] = t;
                }
            }
        }
        return words;
    }
}
