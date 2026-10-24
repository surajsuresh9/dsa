package lld.data_structures.stack.impl;

import java.util.LinkedList;
import java.util.Queue;

// Using Two Queue - Push in O(1) and Pop() in O(n)
public class StackUsing2Queues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int data) {
        // Push data first in empty q2
        q2.add(data);

        // Push all the remaining
        // elements in q1 to q2.
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        // swap the names of two queues
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
    }

    public void pop() {
        // if no elements are there in q1
        if (q1.isEmpty()) {
            return;
        }
        q1.remove();
    }

    public int top() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.peek();
    }

    public int size() {
        return q1.size();
    }

    public static void main(String[] args) {
        StackUsing2Queues stck = new StackUsing2Queues();
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
