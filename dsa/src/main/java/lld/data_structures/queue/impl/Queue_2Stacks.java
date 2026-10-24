package lld.data_structures.queue.impl;

import java.util.Stack;

public class Queue_2Stacks {
    private int capacity;
    private int size;
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public Queue_2Stacks(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("invalid size");
        }
        this.capacity = capacity;
        inputStack = new Stack<>();
        outputStack = new Stack<>();
        size = 0;
    }

    void enqueue(int data) {
        if (size == capacity) {
            System.out.println("Queue full");
            return;
        }
        inputStack.push(data);
        size++;
    }

    int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("empty queue");
        }

        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        Integer popped = outputStack.pop();
        size--;
        return popped;
    }

    void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: [");

        Object[] out = outputStack.toArray();
        Object[] in = inputStack.toArray();

        for (int i = out.length - 1; i >= 0; i--) {
            sb.append(out[i]).append(", ");
        }

        for (Object item : in) {
            sb.append(item).append(", ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Queue_2Stacks q = new Queue_2Stacks(5);
        q.print();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.print();
        q.dequeue();
        q.print();
    }
}
