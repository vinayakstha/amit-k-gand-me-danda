import java.util.ArrayList;
import java.util.List;

public class AdjList {
    int vertices;
    SinglyLinkedList adjlist[];

    AdjList(int vertices) {
        this.vertices = vertices;
        adjlist = new SinglyLinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjlist[i] = new SinglyLinkedList();
        }
    }

    void addEdge(int u, int v) {
        adjlist[u].addNode(v);
        adjlist[v].addNode(u);
    }

    void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " in connected to ");
            SinglyLinkedList.Node current = adjlist[i].head;
            while (current != null) {
                System.out.print(current.data + ", ");
                current = current.next;
            }
            System.out.println();
        }
    }

    List<Integer> getAdjNodes(int i) {
        List<Integer> adjNodes = new ArrayList<>();
        SinglyLinkedList.Node current = adjlist[i].head;
        while (current != null) {
            adjNodes.add(current.data);
            current = current.next;
        }

        return adjNodes;
    }

    void depthFirstSearch(int source) {
        boolean[] visited = new boolean[vertices];
        dfs(source, visited);
    }

    void dfs(int rootNode, boolean[] visited) {
        System.out.println(rootNode);
        visited[rootNode] = true;
        SinglyLinkedList.Node current = adjlist[rootNode].head;
        while (current != null) {
            if (!visited[current.data]) {
                dfs(current.data, visited);
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        AdjList a = new AdjList(5);
        a.addEdge(0, 1);
        a.addEdge(0, 2);
        a.addEdge(0, 4);
        a.addEdge(2, 3);
        a.addEdge(1, 3);
        a.addEdge(3, 4);
        a.printGraph();
        System.out.println(a.getAdjNodes(0));
    }
}
