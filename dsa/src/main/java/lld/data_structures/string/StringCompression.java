package lld.data_structures.string;

public class StringCompression {
    public static void main(String[] args) {
        String s = "aabcccccaaad";
        StringBuilder compressedStr = new StringBuilder();
        char[] ch = s.toCharArray();
        int count = 1;
        for (int i = 1; i < ch.length; i++) {
            if (ch[i - 1] == ch[i]) {
                count++;
            } else {
                compressedStr.append(count).append(ch[i - 1]);
                count = 1;
            }
        }
        compressedStr.append(count).append(ch[ch.length - 1]);
        System.out.println(compressedStr);
    }
}
