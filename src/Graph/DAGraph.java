package Graph;

import java.util.Arrays;
import java.util.Stack;

public class DAGraph {
    private final int[][] adjacencyMatrix;
    private final int numVertices;

    public DAGraph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i, int j) {
        if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
            adjacencyMatrix[i][j] = 1;
        }
    }

    public void removeEdge(int i, int j) {
        if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
            adjacencyMatrix[i][j] = 0;
        }
    }

    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
            return adjacencyMatrix[i][j] == 1;
        } else {
            return false;
        }
    }

    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;

        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i] == 1 && !visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        stack.push(v);
    }

    public void shortestPath(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        int[] distance = new int[numVertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startVertex] = 0;

        for (int i = 0; i < numVertices; i++) {
            int minVertex = findMinVertex(distance, visited);
            visited[minVertex] = true;

            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix[minVertex][j] != Integer.MAX_VALUE && !visited[j] && distance[minVertex] + adjacencyMatrix[minVertex][j] < distance[j]) {
                    distance[j] = distance[minVertex] + adjacencyMatrix[minVertex][j];
                }
            }
        }

        for (int i = 0; i < numVertices; i++) {
            System.out.println("Distance from vertex " + startVertex + " to vertex " + i + " is " + distance[i]);
        }
    }

    private int findMinVertex(int[] distance, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {
        // Create a new Graph with 6 vertices
        DAGraph graph = new DAGraph(6);

        // Add edges
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        //        5 --> 2 --> 3 --> 1
        //        |     ^     |
        //        v     |     v
        //        0 <-- 4     |

        // Perform a Topological Sort
        System.out.print("Topological Sort: ");
        graph.topologicalSort(); // Should print: 5 4 2 3 1 0
    }
}
