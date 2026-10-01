package lld.data_structures.array.two_pointer;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] a = {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1};
        System.out.println("a: " + Arrays.toString(a));
        int[] res = moveZeros(a);
        System.out.println("res: " + Arrays.toString(res));
    }

    private static int[] moveZeros(int[] a) {
//        int z = 0;
//        int nz = 0;
//        while (nz < a.length) {
//            if (a[nz] != 0) {
//                swap(a[z], a[nz]);
//                nz++;
//                z++;
//            } else {
//                nz++;
//            }
//        }

        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                swap(a, i, j);
                j++;
            }
        }
        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
