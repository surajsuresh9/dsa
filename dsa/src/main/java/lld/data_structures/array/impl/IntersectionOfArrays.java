package lld.data_structures.array.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        int[] b = {3, 2, 2, 3, 3, 2};

        Set<Integer> hs = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for (int i : a) {
            hs.add(i);
        }

        for (int i : b) {
            if (hs.contains(i)) {
                res.add(i);
                hs.remove(i);
            }
        }

        System.out.println("intersection: " + res);

    }
}
