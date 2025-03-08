package dsa;

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

    public void addEdge(int src, int des) {
        matrix[src][des] = 1;
    }

    public boolean checkEdge(int src, int des) {
        if (matrix[src][des] == 1) {
            return true;
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addNode(new Node('a'));
        graph.addNode(new Node('b'));
        graph.addNode(new Node('c'));
        graph.addNode(new Node('d'));
        graph.addNode(new Node('e'));

        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);

        graph.print();

    }

}