package dsa;

public class Main {
    public static void main(String[] args) {
        // Link l = new Link();
        // l.insertFirst(10);
        // l.insertFirst(20);
        // l.insertFirst(30);
        // l.insertFirst(40);
        // l.insertFirst(50);
        // l.insertLast(0);
        // l.insertAtAnyPosition(45, 1);
        // l.display();
        // l.deleteAtAnyPosition(3);
        // l.display();

        DoublyLink dl = new DoublyLink();
        dl.insertFirst(1);
        dl.insertFirst(2);
        dl.insertFirst(3);
        dl.insertLast(0);
        dl.insertAtAnyPosition(100, 4);
        dl.display();
        dl.displayRev();
    }

}
