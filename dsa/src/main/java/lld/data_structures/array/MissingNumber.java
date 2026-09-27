package lld.data_structures.array;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 5, 3, 7, 1};

        //sum = n*(n+1)/2;
        int n = arr.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int i : arr) {
            actualSum += i;
        }
        System.out.println("Missing number: " + (expectedSum - actualSum));
    }
}
