public class Graph {
    static class Node {
        char data;

        Node(char data) {
            this.data = data;
        }
    }

    int[][] matrix;

    Graph(int size) {
        matrix = new int[size][size];
    }

    public void addNode(Node node) {

    }

    public void addEdge(int src, int dst) {
        matrix[src][dst] = 1;
    }

    public boolean checkEdge(int src, int dst) {
        if (matrix[src][dst] == 1) {
            return true;
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));

        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);

        graph.print();
    }
}
