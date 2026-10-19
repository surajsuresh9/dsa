package lld.data_structures.stack;

import java.util.ArrayList;
import java.util.List;

public class AllSubArrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        System.out.println(getAllSubArrays(a));
    }

    private static List<List<Integer>> getAllSubArrays(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                List<Integer> subArrays = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subArrays.add(a[k]);
                }
                res.add(subArrays);
            }
        }
        return res;
    }
}
