package lld.data_structures.string;

public class Anagram {
    public static void main(String[] args) {
        System.out.println("isAnagram('silent','listen'): " + isAnagram("silent", "listen"));
        System.out.println("isAnagram('race','care'): " + isAnagram("race", "care"));
        System.out.println("isAnagram('races','care'): " + isAnagram("races", "care"));
    }

    private static boolean isAnagram(String s1, String s2) {
        int[] chars = new int[26];
        for (char ch : s1.toCharArray()) {
            chars[ch - 'a']++;
        }
        for (char ch : s2.toCharArray()) {
            chars[ch - 'a']--;
        }
        for (int i : chars) {
            if (i != 0) {
                return false;
            }
        }
        return true;

    }


}
