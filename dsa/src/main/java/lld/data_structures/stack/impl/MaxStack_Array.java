package lld.data_structures.stack.impl;

public class MaxStack_Array {
    private int[] stck;
    private int[] auxStck;
    private int size;
    private int capacity;

    public MaxStack_Array(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("invalid capacity");
        }
        this.capacity = capacity;
        this.stck = new int[capacity];
        this.auxStck = new int[capacity];
        this.size = 0;
    }

    public void push(int data) {
        if (size == capacity) {
            throw new IllegalStateException("stack full");
        }
        if (size == 0) {
            auxStck[size] = data;
        } else {
            auxStck[size] = Math.max(auxStck[size - 1], data);
        }
        stck[size++] = data;
    }

    public int pop() {
        if (size == 0) {
            throw new IllegalStateException("stack is empty");
        }
        return stck[--size];
    }

    public int getMax() {
        if (size == 0) {
            throw new IllegalStateException("stack is empty");
        }
        return auxStck[size - 1];
    }

    public void printStack() {
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(stck[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxStack_Array stack = new MaxStack_Array(5);
        stack.push(30);
        stack.push(10);
        stack.push(20);
        stack.push(50);
        stack.printStack();
        System.out.println("max: " + stack.getMax());

        System.out.println();
        System.out.println("popped: " + stack.pop());
        stack.printStack();
        System.out.println("max: " + stack.getMax());

        System.out.println();
        System.out.println("popped: " + stack.pop());
        stack.printStack();
        System.out.println("max: " + stack.getMax());
    }
}
