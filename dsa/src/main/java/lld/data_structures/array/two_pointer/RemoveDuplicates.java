package lld.data_structures.array.two_pointer;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 4, 5, 6};
        int i = removeDuplicates(a);
        System.out.println(i);
    }

    private static int removeDuplicates(int[] a) {
        int slow = 0;
        for (int fast = 1; fast < a.length; fast++) {
            if (a[fast] != a[slow]) {
                slow++;
                a[slow] = a[fast];
            }
        }
        return slow + 1;
    }
}
