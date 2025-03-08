import java.util.ArrayList;
import java.util.List;

public class AdjMatrixx {
    int vertices;
    int matrix[][];

    AdjMatrixx(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    void addEdge(int src, int des) {
        matrix[src][des] = 1;
        matrix[des][src] = 1;
    }

    void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " is connected to ");
            for (int j = 0; j < vertices; j++) {
                if (matrix[i][j] != 0) {
                    System.out.print(j + ",");
                }
            }
            System.out.println();
        }
    }

    List<Integer> getAdjNodes(int i) {
        List<Integer> adjlist = new ArrayList<>();
        for (int j = 0; j < vertices; j++) {
            if (matrix[i][j] != 0) {
                adjlist.add(j);
            }
        }

        return adjlist;
    }

    void depthFirstSearch(int src) {
        boolean[] visited = new boolean[vertices];
        dfs(src, visited);
    }

    void dfs(int src, boolean[] visited) {
        if (visited[src]) {
            return;
        } else {
            visited[src] = true;
        }
        for (int i = 0; i < matrix[src].length; i++) {
            if (matrix[src][i] == 1) {
                dfs(i, visited);
            }
        }
        return;
    }
}
