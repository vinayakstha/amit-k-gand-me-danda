package dsa;

public class DoublyLink {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        }
    }

    void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    void insertAtAnyPosition(int data, int index) {
        if (index == 0) {
            insertFirst(data);
            size++;
        } else if (index == size) {
            insertLast(data);
            size++;
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(data, temp, temp.next);
            temp.next.prev = newNode;
            temp.next = newNode;
            size++;

        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "--> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void displayRev() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + "--> ");
            temp = temp.prev;
        }
        System.out.print("null");
    }
}
