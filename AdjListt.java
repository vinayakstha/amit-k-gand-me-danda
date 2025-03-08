import java.util.LinkedList;

public class AdjListt {
    int vertices;
    LinkedList<Integer>[] list;

    AdjListt(int vertices) {
        this.vertices = vertices;
        list = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            list[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dst) {
        list[src].add(dst);
        list[dst].add(src);
    }

    void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " is connected to ");
            for (Integer lists : list[i]) {
                System.out.print(lists + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        AdjListt a = new AdjListt(5);
        a.addEdge(0, 1);
        a.addEdge(0, 2);
        a.addEdge(0, 4);
        a.addEdge(2, 3);
        a.addEdge(1, 3);
        a.addEdge(3, 4);
        a.printGraph();
    }

}
