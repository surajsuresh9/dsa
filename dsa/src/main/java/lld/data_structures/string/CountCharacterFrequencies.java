package lld.data_structures.string;

import java.util.HashMap;
import java.util.Map;

public class CountCharacterFrequencies {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        String s = "racecar";
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        System.out.println(map);
    }

}
