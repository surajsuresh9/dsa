package lld.data_structures.stack.impl;

public class DynamicStack_Array {
    int[] stck;
    int capacity;
    int size;
    int ptr;
    int min;

    public DynamicStack_Array(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.stck = new int[capacity];
        this.size = 0;
        this.ptr = -1;
        this.min = Integer.MAX_VALUE;
    }

    public void push(int data) {
        if (size == capacity) {
            ensureCapacity();
        }
        stck[++ptr] = data;
        size++;
        updateMin(data);
    }

    private void updateMin(int data) {
        min = Math.min(data, min);
    }

    public int pop() {
        if (size == 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        size--;
        return stck[ptr--];
    }

    private void ensureCapacity() {
        System.out.println("resizing to 2x capacity: " + (2 * capacity));
        int[] temp = new int[capacity * 2];
        for (int i = 0; i < stck.length; i++) {
            temp[i] = stck[i];
        }
        stck = temp;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: [");
        if (size == 0) {
            sb.append("]");
            System.out.println(sb);
            return;
        }
        for (int i = size - 1; i >= 0; i--) {
            sb.append(stck[i]).append(", ");
        }
        System.out.println(sb.substring(0, sb.length() - 2) + "]");
    }

    public static void main(String[] args) {
        DynamicStack_Array stck = new DynamicStack_Array(3);
        stck.print();
        stck.push(10);
        stck.push(20);
        stck.push(30);
        stck.push(40);
        stck.push(50);
        stck.print();
        System.out.println(stck.pop());
        System.out.println(stck.pop());
        System.out.println(stck.pop());
        System.out.println(stck.pop());
        System.out.println(stck.pop());
        stck.print();
    }
}
