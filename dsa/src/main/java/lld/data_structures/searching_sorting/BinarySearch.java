package lld.data_structures.searching_sorting;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {3, 5, 7, 8, 10, 12, 15};
        int k = 7;
        System.out.println(binarySearch(a, k));
        System.out.println(binarySearchRecursion(a, 0, a.length - 1, k));
    }

    static int binarySearch(int[] a, int target) {
        Arrays.sort(a);
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    static int binarySearchRecursion(int[] a, int l, int r, int t) {
        while (r >= l) {
            int m = l + (r - l) / 2;
            if (a[m] == t) {
                return m;
            }
            if (a[m] > t) {
                return binarySearchRecursion(a, l, m - 1, t);
            } else {
                return binarySearchRecursion(a, m + 1, r, t);
            }
        }
        return -1;
    }

}
