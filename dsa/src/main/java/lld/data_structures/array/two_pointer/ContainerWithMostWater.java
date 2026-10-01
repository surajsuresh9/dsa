package lld.data_structures.array.two_pointer;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 4, 3};
        int res = getContainerWithMostWater(a);
        System.out.println("res: " + res);
    }

    private static int getContainerWithMostWater(int[] a) {
        int maxWater = Integer.MIN_VALUE;
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int capacity = (r - l) * Math.min(a[l], a[r]);
            maxWater = Math.max(maxWater, capacity);
            if (a[l] < a[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxWater;
    }
}
