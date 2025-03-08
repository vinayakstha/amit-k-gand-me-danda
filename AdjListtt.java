import java.util.LinkedList;

public class AdjListtt {
    int vertices;
    LinkedList<Integer> adjList[];

    AdjListtt(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dst) {
        adjList[src].add(dst);
        adjList[dst].add(src);
    }

    void printList() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " is connected to ");
            for (Integer list : adjList[i]) {
                System.out.print(list + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjListtt a = new AdjListtt(5);
        a.addEdge(0, 1);
        a.addEdge(0, 2);
        a.addEdge(1, 3);
        a.addEdge(2, 4);
        a.addEdge(3, 2);
        a.addEdge(3, 4);
        a.printList();
    }
}
