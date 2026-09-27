package lld.data_structures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UnionArrays {
    public static void main(String[] args) {
        // unsorted arrays
        int[] a = {89, 24, 75, 11, 23};
        int[] b = {89, 2, 4};
        Arrays.sort(a);
        Arrays.sort(b);
        List<Integer> res = new ArrayList<>();

        int first = 0;
        int second = 0;

//        List<Integer> res = new ArrayList<>();
        while (first < a.length && second < b.length) {
            if (a[first] < b[second]) {
                res.add(a[first++]);
            } else if (b[second] < a[first]) {
                res.add(b[second++]);
            } else {
                res.add(b[second++]);
                first++;
            }
        }


        while (first < a.length && res.get(res.size() - 1) != a[first]) {
            res.add(a[first++]);
        }

        while (second < b.length && res.get(res.size() - 1) != b[second]) {
            res.add(b[second++]);
        }

        System.out.println("Union array: " + res);
    }
}
