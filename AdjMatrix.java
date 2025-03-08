import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AdjMatrix {
    // edge list
    public static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    int vertices;
    int matrix[][];

    // edges array to fill all edge list
    Edge edges[]; // mst

    AdjMatrix(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
        edges = new Edge[vertices * (vertices - 1) / 2]; // mst
    }

    int edgeindx = -1; // mst

    void addEdge(int src, int des, int weight) {
        matrix[src][des] = weight;
        matrix[des][src] = weight;

        edges[++edgeindx] = new Edge(src, des, weight); // mst
    }

    void krushkal() {
        int[] parent = new int[vertices];
        int[] size = new int[vertices];
        int[][] mst = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }

        Arrays.sort(edges);
        int edgeTaken = 0;
        int edgeCounter = -1;

        while (edgeTaken < vertices) {
            Edge e = edges[++edgeCounter];
            int uabsroot = find(e.u, parent);
            int vabsroot = find(e.v, parent);
            if (uabsroot == vabsroot) {
                continue;
            }
            mst[e.u][e.v] = e.w;
            mst[e.v][e.u] = e.w;
            edgeTaken++;
        }
    }

    void union(int uabsroot, int vabsroot, int size[], int parent[]) {
        if (size[uabsroot] > size[vabsroot]) {
            parent[vabsroot] = uabsroot;
        } else if (size[uabsroot] < size[vabsroot]) {
            parent[uabsroot] = vabsroot;
        } else {
            parent[vabsroot] = uabsroot;
            size[uabsroot]++;
        }
    }

    int find(int u, int parent[]) {
        if (parent[u] == -1) {
            return u;
        }
        return parent[u] = find(parent[u], parent);
    }

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

    void BFS(int source) {
        Queues q = new Queues(vertices);
        boolean[] visited = new boolean[vertices];
        q.enqueue(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int x = q.dequeue();
            System.out.println(x);
            for (int j = 0; j < vertices; j++) {
                if (matrix[x][j] != 0) {
                    if (!visited[j]) {
                        q.enqueue(j);
                        visited[j] = true;
                    }
                }
            }
        }
    }

    void shortestPathUnweightedGraph(int source) {
        int dist[] = new int[vertices];
        int prevpath[] = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            prevpath[i] = 1;
        }
        dist[source] = 0;
        Queues q = new Queues(vertices);
        boolean[] visited = new boolean[vertices];
        q.enqueue(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int x = q.dequeue();
            System.out.println(x);
            for (int j = 0; j < vertices; j++) {
                if (matrix[x][j] != 0) {
                    if (!visited[j]) {
                        if (dist[x] + 1 < dist[j]) {
                            dist[j] = dist[x] + 1;
                        }
                        q.enqueue(j);
                        visited[j] = true;
                    }
                }
            }
        }
    }

    int dijkstra(int source, int destination) {
        int[] dist = new int[vertices];
        int[] prevpath = new int[vertices];
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            prevpath[i] = -1;
        }

        dist[source] = 0;
        for (int i = 0; i < vertices; i++) {
            int minVertex = findMinVertex(dist, visited);
            visited[minVertex] = true;
            for (int j = 0; j < vertices; j++) {
                if (matrix[minVertex][j] != 0) {
                    if (!visited[j] && dist[minVertex] + matrix[minVertex][j] < dist[j]) {
                        dist[j] = dist[minVertex] + matrix[minVertex][j];
                        prevpath[j] = minVertex;
                    }
                }
            }
        }
        return dist[destination];
        // print path
        Stack<Integer> stk = new Stack<>();
        int x = destination;
        stk.push(x);
        while (prevpath[x] != -1) {
            x = prevpath[x];
            stk.push(x);
        }
        // printing actual path from s to d using stack
        while (!stk.isEmpty()) {
            System.out.println(stk.pop());
        }
    }

    int findMinVertex(int[] dist, boolean visited[]) {
        int min = -1;
        for (int i = 0; i < dist.length; i++) {
            if (min == -1 && !visited[i] || dist[i] < dist[min] && !visited[i]) {
                min = i;
            }
        }
        return min;
    }

    // write to print matrix
    public static void main(String[] args) {
        AdjMatrix a = new AdjMatrix(5);
        a.addEdge(0, 1, 10);
        a.addEdge(0, 2, 5);
        a.addEdge(0, 5, 100);
        a.addEdge(1, 2, 2);
        a.addEdge(1, 3, 5);
        a.addEdge(2, 3, 3);
        a.addEdge(2, 4, 20);
        a.addEdge(3, 5, 2);
        a.addEdge(4, 5, 5);
        a.printGraph();
        System.out.println(a.getAdjNodes(0));
    }
}
