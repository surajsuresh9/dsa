package lld.data_structures.queue;

import java.util.Arrays;

public class BinaryRepresentation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getBinaryRepresentations(6)));
    }

    private static String[] getBinaryRepresentations(int num) {
        if (num < 0) {
            throw new NegativeArraySizeException("num has to be positive");
        }
        int[] a = new int[num];
        String[] res = new String[num];

        // populate numbers
        for (int i = 1; i <= num; i++) {
            a[i - 1] = i;
        }
        // getBinaryString
        for (int i = 0; i < a.length; i++) {
            res[i] = getBinaryString(a[i]);
        }
        return res;
    }

    private static String getBinaryString(int i) {
        if (i == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (i != 0) {
            int rem = i % 2;
            sb.append(rem);
            i /= 2;
        }
        return sb.reverse().toString();
    }
}
