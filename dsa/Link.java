package dsa;

public class Link {
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    // insert at the first
    void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
        } else {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    // insert at the last
    void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    // insert at any index
    void insertAtAnyPosition(int data, int index) {
        if (index == 0) {
            insertFirst(data);
            size++;
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(data, temp.next);
            temp.next = newNode;
            size++;
        }
    }

    // delete the first node
    void deleteFirst() {
        head = head.next;
        if (head == null) {
            tail = null;
            size--;
        }
    }

    // delete the last node
    void deleteLast() {
        if (head == null) {
            System.out.println("list is empty");
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
            size--;
        }
    }

    void deleteAtAnyPosition(int index) {
        if (index == 0) {
            head = head.next;
            size--;
        } else if (index == size - 1) {
            deleteLast();
            size--;
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "--> ");
            temp = temp.next;
        }
        System.out.println("NULL");
        System.out.println(size);
    }

}