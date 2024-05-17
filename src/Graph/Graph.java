package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private final int[][] adjacencyMatrix;
    private final int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i, int j) {
        if (i >= 0 && i < numVertices && j > 0 && j < numVertices) {
            adjacencyMatrix[i][j] = 1;
            adjacencyMatrix[j][i] = 1;
        }
    }

    public void removeEdge(int i, int j) {
        if (i >= 0 && i < numVertices && j > 0 && j < numVertices) {
            adjacencyMatrix[i][j] = 0;
            adjacencyMatrix[j][i] = 0;
        }
    }

    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < numVertices && j > 0 && j < numVertices) {
            return adjacencyMatrix[i][j] == 1;
        } else {
            return false;
        }
    }

    public void dfs(int startVertex) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numVertices];

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            if (!visited[currentVertex]) {
                System.out.print(currentVertex + " ");
                visited[currentVertex] = true;
            }

            for (int i = 0; i < numVertices; i++) {
                if (isEdge(currentVertex, i) && !visited[i]) {
                    stack.push(i);
                }
            }
        }
    }

    public void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numVertices];

        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            if (!visited[currentVertex]) {
                System.out.print(currentVertex + " ");
                visited[currentVertex] = true;
            }

            for (int i = 0; i < numVertices; i++) {
                if (isEdge(currentVertex, i) && !visited[i]) {
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create a new Graph with 5 vertices
        Graph graph = new Graph(5);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        //        0 --> 1 --> 2
        //              |     |
        //              v     v
        //              4 <-- 3



        // Print whether there is an edge between different vertices
        System.out.println("Is there an edge between 0 and 1: " + graph.isEdge(0, 1)); // Should print: true
        System.out.println("Is there an edge between 1 and 4: " + graph.isEdge(1, 4)); // Should print: true
        System.out.println("Is there an edge between 2 and 4: " + graph.isEdge(2, 4)); // Should print: false

        // Remove an edge
        graph.removeEdge(1, 4);

        // Check again if there is an edge between 1 and 4
        System.out.println("Is there an edge between 1 and 4: " + graph.isEdge(1, 4)); // Should print: false

        // Perform a Depth-First Search starting from vertex 0
        System.out.print("Depth-First Search starting from vertex 0: ");
        graph.dfs(0); // Should print: 0 4 3 2 1

        System.out.println();

        // Perform a Breadth-First Search starting from vertex 0
        System.out.print("Breadth-First Search starting from vertex 0: ");
        graph.bfs(0); // Should print: 0 1 4 2 3
    }
}
