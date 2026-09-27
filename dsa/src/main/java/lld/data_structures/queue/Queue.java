package lld.data_structures.queue;

public class Queue {
    int front;
    int rear;
    int size;
    int capacity;
    int[] arr;

    public Queue(int capacity) {
        this.size = 0;
        this.front = 0;
        this.rear = -1;
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    // check if queue is full
    boolean isFull() {
        return size == capacity;
    }

    // check if queue is empty
    boolean isEmpty() {
        return size == 0;
    }

    // Add an element to the rear of the queue (enqueue)
    void enqueue(int el) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = rear + 1 % capacity;
        arr[rear] = el;
        size++;
    }

    // Move an element from the front (dequeue)
    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        front = (front + 1) % capacity;
        int el = arr[front];
        size--;
        return el;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        for (int i = 1; i <= q.capacity; i++) {
            q.enqueue(i * 10);
        }
        System.out.println("size: " + q.size);
        for (int i = 0; i < q.capacity; i++) {
            System.out.println("Removed :" + q.dequeue());
        }
        System.out.println("size: " + q.size);
    }
}
