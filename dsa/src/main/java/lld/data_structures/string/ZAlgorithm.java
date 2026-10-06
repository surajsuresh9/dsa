package lld.data_structures.string;

import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {
    public static void main(String[] args) {
        String pattern = "aab";
        String text = "aabxaabxaa";
        List<Integer> idx = new ArrayList<>();
        List<Integer> z = zFunction(text, pattern);

        // check for z[] where z[i] == pat length
        for (int i = 0; i < z.size(); i++) {
            if (z.get(i) == pattern.length()) {
                idx.add(i - pattern.length() - 1);
            }
        }
        System.out.println(idx);
    }

    static List<Integer> zFunction(String txt, String pat) {
        List<Integer> z = new ArrayList<>();
        String s = pat + "$" + txt;

        for (int i = 0; i < s.length(); i++) {
            z.add(0);
        }

        int l = 0, r = 0;
        for (int i = 1; i < s.length(); i++) {
            if (i <= r) {
                int k = i - l;

                // Case 2: reuse the previously computed value
                z.set(i, Math.min(r - i + 1, z.get(k)));
            }

            // Try to extend the Z-box beyond r
            while (i + z.get(i) < s.length() &&
                    s.charAt(z.get(i)) == s.charAt(i + z.get(i))) {
                z.set(i, z.get(i) + 1);
            }

            // Update the [l, r] window if extended
            if (i + z.get(i) - 1 > r) {
                l = i;
                r = i + z.get(i) - 1;
            }
        }
        return z;
    }

    static int[] zFunction_1(String txt, String pat) {
        String s = pat + "$" + txt;
        int[] z = new int[s.length()];
        z[0] = 0;
        // aab$aabxaabxaa
        for (int i = 1; i < s.length(); i++) {
            int j = 0;
            while (i < s.length() && j < s.length() && s.charAt(i) == s.charAt(j) && j < i) {
                j++;
                i++;
            }
            z[i - j] = j;
            i = i - j;
        }
        return z;
    }
}
