import java.util.HashMap;

public class LRUCaching {
    public static class Node {
        int k;
        int v;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.k = key;
            this.v = value;
            this.prev = this.next = null;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;

    LRUCaching(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    void put(int key, int value) {
        if (map.containsKey(key)) {
            // remove node
            removeNode(map.get(key));
        } else if (map.size() == capacity) {
            // remove tail
            removeNode(dummytail.prev);
        }
        Node newnode = new Node(key, value);
        insert(newnode);
    }

    Node dummyhead = new Node(0, 0);
    Node dummytail = new Node(0, 0);

    void insert(Node newnode) {
        map.put(newnode.k, newnode);
        if (dummyhead.next == null) {
            dummyhead.next = newnode;
            dummytail.prev = newnode;
            newnode.prev = dummyhead;
            newnode.next = dummytail;
        } else {
            newnode.prev = dummyhead;
            newnode.next = dummyhead.next;
            dummyhead.next.prev = newnode;
            dummyhead.next = newnode;
        }
    }

    int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            // remove node
            removeNode(node);
            // reinsert that node
            insert(node);
            return node.v;
        }
        return -1;
    }

    void removeNode(Node node) {
        map.remove(node.k);
        node.prev.next = node.next;
        node.next = node.prev = null;
    }
}
