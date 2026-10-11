package lld.data_structures.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMP {
    public static void main(String[] args) {
        String s = "aabaacaadaabaaba";
        String pat = "aaba";
        System.out.println(search(s, pat));
    }

    static List<Integer> search(String s, String pattern) {
        List<Integer> res = new ArrayList<>();
        // Pointers i and j, for traversing
        // the text and pattern
        // Pointers i and j, for traversing
        // the text and pattern
        int i = 0;
        int j = 0;
        int[] lps = getLPS(pattern);

        while (i < s.length()) {
            // If characters match, move both pointers forward
            if (s.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                // If the entire pattern is matched
                // store the start index in result
                if (j == pattern.length()) {
                    res.add(i - j);

                    // Use LPS of previous index to
                    // skip unnecessary comparisons
                    j = lps[j - 1];
                }
            }

            // If there is a mismatch
            else {

                // Use lps value of previous index
                // to avoid redundant comparisons
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return res;
    }

    private static int[] getLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int j = 0;
        lps[0] = 0;
        char[] pat = pattern.toCharArray();
        for (int i = 1; i < pat.length; i++) {
            // If characters match, increment the size of lps
            if (pat[j] == pat[i]) {
                j++;
                lps[i] = j;
                i++;
                // If there is a mismatch
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    // j=0;i=1
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
