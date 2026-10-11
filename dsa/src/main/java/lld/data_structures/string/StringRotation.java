package lld.data_structures.string;

public class StringRotation {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdab";
        String s3 = "aaaab";
        String s4 = "aaab";
        System.out.println(s1 + ", " + s2 + ": " + checkIfRotated(s1, s2));
        System.out.println(s3 + ", " + s4 + ": " + containsPattern(s3, s4));
    }

    static boolean checkIfRotated(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        return checkRotation(s1, s2);
    }

    private static boolean checkRotation(String s1, String s2) {
        char[] ch = s1.toCharArray();
        int k = s1.length() - 1;
        for (int c = 0; c < k; c++) {
            char first = ch[0];
            for (int i = 0; i < ch.length - 1; i++) {
                ch[i] = ch[i + 1];
            }
            ch[ch.length - 1] = first;
            if (s2.equals(new String(ch))) {
                return true;
            }
        }
        return false;
    }

    static boolean containsPattern(String s1, String pat) {
        char[] c1 = s1.toCharArray();
        char[] c2 = pat.toCharArray();
        int i = 0;
        int j = 0;
        int iStart = i;
        while (i < c1.length && j < c2.length) {
            if (c1[i] == c2[j]) {
                i++;
                j++;
            } else {
                i = iStart++;
                if (j > 0) {
                    j = 0;
                }
            }
        }
        return j == c2.length;
    }

}
