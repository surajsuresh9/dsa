package lld.data_structures.string;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("isPalindrome('racecar'): " + isPalindrome("racecar"));
        System.out.println("isPalindrome('hello'): " + isPalindrome("hello"));
    }

    static boolean isPalindrome(String s) {
        return s.equals(reverse((s)));
    }

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
