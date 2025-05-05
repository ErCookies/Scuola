public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add nodes
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        // Add edges
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 10);
        graph.addEdge("B", "C", 8);

        // Print adjacency list
        System.out.println("Adjacency List:");
        System.out.println(graph.adjacencyListToString());
    }
}