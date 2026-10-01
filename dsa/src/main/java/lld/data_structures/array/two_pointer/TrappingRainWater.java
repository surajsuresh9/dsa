package lld.data_structures.array.two_pointer;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] a = {2, 1, 5, 3, 1, 0, 4};
        System.out.println("res: "+trap(a));
    }

    private static int trap(int[] a) {
        int l = 0;
        int r = a.length - 1;

        int lMax = 0;
        int rMax = 0;
        int res = 0;

        while (l < r) {
            if (a[l] <= a[r]) {
                lMax = Math.max(lMax, a[l]);
                res += lMax - a[l];
                l++;
            } else {
                rMax = Math.max(rMax, a[r]);
                res += rMax - a[r];
                r--;
            }
        }

        return res;
    }

}
