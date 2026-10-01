package lld.data_structures.array.impl;

// FixedSizeArray aka Stack
public class FixedSizeArray {

    int capacity;
    int size;
    int idx;
    int[] arr;

    public FixedSizeArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.idx = 0;
        this.arr = new int[capacity];
    }

    void add(int el) {
        if (size == capacity) {
            System.out.println("Array is full");
            return;
        }
        arr[idx++] = el;
        size++;
    }

    int remove() {
        if (size == 0) {
            System.out.println("Array is empty");
            return -1;
        }
        return arr[idx--];
    }

    void printArray() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array: [");
        if (size == 0) {
            sb.append("]");
            return;
        }
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        FixedSizeArray arr = new FixedSizeArray(5);
        for (int i = 1; i <= arr.capacity; i++) {
            arr.add(i * 10);
        }
        arr.printArray();
    }
}
