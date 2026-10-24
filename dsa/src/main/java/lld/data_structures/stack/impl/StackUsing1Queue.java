package lld.data_structures.stack.impl;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing1Queue {
    Queue<Integer> q = new LinkedList<>();

    // push element on top
    public void push(int data) {
        q.add(data);

        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.add(q.peek());
            q.remove();
        }
    }

    // remove top element
    public void pop() {
        if (!q.isEmpty()) {
            q.poll();
        }
    }

    // return top element
    public int top() {
        if (q.isEmpty())
            return -1;
        return q.peek();
    }

    public int size() {
        return q.size();
    }

    public static void main(String[] args) {
        StackUsing1Queue stck = new StackUsing1Queue();
        stck.push(10);
        stck.push(20);
        stck.push(30);
        System.out.println(stck.top());
        stck.pop();
        System.out.println(stck.top());
        stck.pop();
        System.out.println(stck.size());
    }
}
