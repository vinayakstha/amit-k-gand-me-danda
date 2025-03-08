public class Queues {
    int queue[];
    int front = -1;
    int rear = -1;
    int size;

    Queues(int size) {
        this.size = size;
        queue = new int[size];
    }

    void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
            queue[++rear] = data;
        }
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        } else {
            if (front == rear) {
                int temp = front;
                front = -1;
                rear = -1;
                return queue[temp];
            }
            return queue[front++];
        }
    }

    boolean isFull() {
        return rear == size - 1;
    }

    boolean isEmpty() {
        return rear == -1 && front == -1;
    }
}
