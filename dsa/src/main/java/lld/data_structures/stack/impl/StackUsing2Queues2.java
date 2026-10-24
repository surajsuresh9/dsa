package lld.data_structures.stack.impl;

import java.util.LinkedList;
import java.util.Queue;

// Using Two Queue - Push in O(1) and Pop() in O(n)
public class StackUsing2Queues2 {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // insert element
    public void push(int data) {
        q1.add(data);
    }

    public void pop() {
        // if no elements are there in q1
        if (q1.isEmpty()) {
            return;
        }
        while (q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }
        q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }


    public int top() {
        if (q1.isEmpty()) {
            return -1;
        }
        while (q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }
        int temp = q1.peek();
        q1.remove();
        q2.add(temp);
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
        return temp;
    }
    
    public int size() {
        return q1.size();
    }

    public static void main(String[] args) {
        StackUsing2Queues2 stck = new StackUsing2Queues2();
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
