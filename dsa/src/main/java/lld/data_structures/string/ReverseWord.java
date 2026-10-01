package lld.data_structures.string;

public class ReverseWord {
    public static void main(String[] args) {
        String word = "java";
        System.out.println("reversedWord: " + reverseWord(word));
    }

    static String reverseWord(String s) {
        char[] ch = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char t = ch[l];
            ch[l] = ch[r];
            ch[r] = t;
            l++;
            r--;
        }
        return new String(ch);
    }
}
