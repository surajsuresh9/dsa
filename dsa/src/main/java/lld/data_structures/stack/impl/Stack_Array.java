package lld.data_structures.stack.impl;

public class Stack_Array {
    int[] arr;
    int size;
    int ptr;
    int capacity;

    public Stack_Array(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
        ptr = -1;
    }

    void push(int data) {
        if (size >= capacity) {
            System.out.println("Stack overflow");
            return;
        }
        arr[++ptr] = data;
        size++;
    }

    int pop() {
        if (size <= 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        size--;
        return arr[ptr--];
    }

    void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: [");
        if (size == 0) {
            sb.append("]");
            System.out.println(sb);
            return;
        }
        for (int i = size - 1; i >= 0; i--) {
            sb.append(arr[i]).append(", ");
        }
        System.out.println(sb.substring(0, sb.length() - 2) + "]");
    }

    public static void main(String[] args) {
        Stack_Array stck = new Stack_Array(5);
        stck.push(10);
        stck.push(20);
        stck.push(30);
        stck.push(40);
        stck.push(50);
        stck.print();
        for (int i = stck.size; i >= 0; i--) {
            System.out.print(stck.pop() + " ");
        }
    }
}
