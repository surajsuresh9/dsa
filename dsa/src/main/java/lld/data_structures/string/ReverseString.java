package lld.data_structures.string;

public class ReverseString {
    public static void main(String[] args) {
        String s = "hello world";
        System.out.println("reverse: " + reverse(s));
        System.out.println("reverse: " + reverseTwoPtr(s));
    }

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    static String reverseTwoPtr(String s) {
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
