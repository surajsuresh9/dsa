package lld.data_structures.stack.impl;

import java.util.NoSuchElementException;

public class MinStack_Array {
    private int[] stck;
    private int[] auxStck;
    private int capacity;
    private int size;
    private int ptr;

    public MinStack_Array(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("invalid capacity");
        }
        this.capacity = capacity;
        this.stck = new int[capacity];
        this.auxStck = new int[capacity];
        this.size = 0;
        this.ptr = -1;
    }

    public void push(int data) {
        if (size >= capacity) {
            System.out.println("Stack overflow");
            return;
        }
        stck[++ptr] = data;

        if (size == 0) {
            auxStck[size] = data;
        } else {
            auxStck[size] = Math.min(data, auxStck[size - 1]);
        }
        size++;
    }

    public int pop() {
        if (size == 0) {
            System.out.println("Stack underflow");
            throw new NoSuchElementException("Stack underflow");
        }

        int popped = stck[ptr--];
        size--;
        return popped;
    }

    public int getMin() {
        if (size == 0) {
            throw new IllegalStateException("stack is empty");
        }
        return auxStck[size - 1];
    }

    public void print(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(name + ": [");
        if (size == 0) {
            sb.append("]");
            System.out.println(sb);
            return;
        }
        for (int i = size - 1; i >= 0; i--) {
            if (name.equals("stck")) {
                sb.append(stck[i]).append(", ");
            } else {
                sb.append(auxStck[i]).append(", ");
            }
        }
        System.out.println(sb.substring(0, sb.length() - 2) + "]");
    }

    public static void main(String[] args) {
        MinStack_Array stck = new MinStack_Array(5);
        stck.push(10);
        stck.push(5);
        stck.push(20);
        stck.print("stck");
        stck.print("auxStck");
        System.out.println("min: " + stck.getMin());
        System.out.println();

        System.out.println("popped: " + stck.pop());
        stck.print("stck");
        stck.print("auxStck");
        System.out.println("min: " + stck.getMin());
        System.out.println();

        System.out.println("popped: " + stck.pop());
        stck.print("stck");
        stck.print("auxStck");

        System.out.println("min: " + stck.getMin());
    }
}
