package dsa;

public class LL {
    public static class Node {
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

    public void insertAtFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insertAtAnyPosition(int data, int index) {
        if (index == 0) {
            insertAtFirst(data);
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(data, temp.next);
            temp.next = newNode;
        }
    }

    public void deleteFirst() {
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "--> ");
            temp = temp.next;
        }
        System.out.print("NULL");
    }
}