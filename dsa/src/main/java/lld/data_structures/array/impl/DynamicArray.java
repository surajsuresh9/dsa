package lld.data_structures.array.impl;

public class DynamicArray {
    private int size;
    private int capacity;
    private int[] arr;

    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity can't be 0/ -ve");
        }
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;

    }

    public void add(int i) {
        ensureCapacity();
        arr[size++] = i;
    }

    public void insertAtidx(int idx, int el) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity();
        for (int i = size; i > idx; i--) {
            arr[i] = arr[i - 1];
        }
        arr[idx] = el;
        size++;
    }

    public int search(int key) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int el) {
        int idx = search(el);
        if (idx == -1) {
            System.out.println("Element not found");
            return;
        }
        deleteAtIdx(idx);
    }

    public void deleteAtIdx(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }
        // shifting elements
        for (int i = idx; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = 0;
    }

    public void printArray() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array: [");
        if (size == 0) {
            sb.append("]");
            System.out.println(sb);
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

    private void resize() {
        capacity *= 2;
        int[] newArr = new int[capacity];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    private void ensureCapacity() {
        if (isFull()) {
            resize();
        }
    }

    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(10);
        for (int i = 1; i <= 10; i++) {
            arr.add(i * 10);
        }
        arr.add(110);
        arr.printArray();

        arr.delete(20);
        arr.printArray();

        arr.insertAtidx(2, 20);
        arr.printArray();

        System.out.println("capacity: " + arr.capacity);
        System.out.println("size: " + arr.size);
    }
}
