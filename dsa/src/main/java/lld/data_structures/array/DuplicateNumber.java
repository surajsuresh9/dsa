package lld.data_structures.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateNumber {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8, 9};
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : a) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        System.out.println("Duplicates: " + duplicates);
    }
}
