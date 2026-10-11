package lld.data_structures.string;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "forgeeksskeegfor";
        System.out.println(getLongestPalindromicSubstringBruteForce(s));
        System.out.println(getLongestPalindromicSubstringOptimized(s));
    }

    private static String getLongestPalindromicSubstringOptimized(String s) {
        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {

            // this runs two times for both odd and even
            // length palindromes.
            // j = 0 means odd and j = 1 means even length
            for (int j = 0; j <= 1; j++) {
                int low = i;
                int high = j + i;
                while (low >= 0 && high < s.length() - 1 && s.charAt(low) == s.charAt(high)) {
                    int currLen = high - low + 1;
                    if (currLen > maxLen) {
                        start = low;
                        maxLen = currLen;
                    }
                    low--;
                    high++;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    private static String getLongestPalindromicSubstringBruteForce(String s) {
        String maxSubstring = "";
        List<String> substrings = generateAllSubstrings(s);
        for (int i = 0; i < substrings.size(); i++) {
            if (isPalindrome(substrings.get(i))) {
                if (substrings.get(i).length() > maxSubstring.length()) {
                    maxSubstring = substrings.get(i);
                }
            }
        }
        return maxSubstring;
    }

    private static List<String> generateAllSubstrings(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                res.add(s.substring(i, j));
            }
        }
        return res;
    }

    private static boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
