package lld.data_structures.array.sliding_window;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        int maxLen = bruteForce(s);
        System.out.println("maxLen: " + maxLen);
        maxLen = twoPointerApproach(s);
        System.out.println("maxLen: " + maxLen);
        maxLen = twoPointerApproach2(s);
        System.out.println("maxLen: " + maxLen);
        maxLen = maxSubstringOfNonRepeatingChars(s);
        System.out.println("maxLen: " + maxLen);
        maxLen = maxSubstringOfNonRepeatingCharacters(s);
        System.out.println("maxLen: " + maxLen);
    }

    private static int bruteForce(String s) {
        // substring from each position
        Set<Character> hs = new HashSet<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j <= s.length(); j++) {
////                System.out.println("substring-(" + i + "," + (j - 1) + "): " + s.substring(i, j));
//                String subString = s.substring(i, j);
//                for (char ch : subString.toCharArray()) {
//                    hs.add(ch);
//                }
//                maxLength = Math.max(maxLength, hs.size());
//                hs.clear();
//            }
            hs.clear();
            for (int j = i; j < s.length(); j++) {
                if (!hs.add(s.charAt(j))) {
                    break;
                }
                maxLength = Math.max(maxLength, hs.size());
            }
        }
        return maxLength;
    }

    static int twoPointerApproach2(String s) {
        int res = 0;
        if (s.isEmpty() || s.length() == 1) {
            return s.length();
        }

        boolean[] vis = new boolean[26];

        int left = 0;
        int right = 0;

        while (right < s.length()) {

            while (vis[s.charAt(right) - 'a']) {
                vis[s.charAt(left) - 'a'] = false;
                left++;
            }

            vis[s.charAt(right) - 'a'] = true;
            res = Math.max(res, (right - left + 1));
            right++;
        }
        return res;
    }

    static int twoPointerApproach(String s) {
        Set<Character> hs = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (hs.contains(s.charAt(right))) {
                hs.remove(s.charAt(left));
                left++;
            }

            hs.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    static int maxSubstringOfNonRepeatingChars(String s) {
        int i = 0;
        int res = 0;
        HashSet<Character> hs = new HashSet<>();
        for (int j = 0; j < s.length(); j++) {
            while (hs.contains(s.charAt(j))) {
                hs.remove(s.charAt(i));
                i++;
            }
            hs.add(s.charAt(j));
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    static int maxSubstringOfNonRepeatingCharacters(String s) {
        boolean[] vis = new boolean[26];
        int i = 0;
        int j = 0;
        int res = 0;

        while (j < s.length()) {
            while (vis[s.charAt(j) - 'a']) {
                vis[s.charAt(i) - 'a'] = false;
                i++;
            }

            vis[s.charAt(j) - 'a'] = true;
            res = Math.max(res, (j - i + 1));
            j++;
        }
        return res;
    }

}
