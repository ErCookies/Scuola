import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    public Map<String, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addNode(String node) {
        adjacencyList.put(node, new ArrayList<>());
    }

    public void addEdge(String source, String destination, int weight) {
        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight)); // Assuming undirected graph
    }

    public List<Edge> getNeighbors(String node) {
        return adjacencyList.get(node);
    }

    public String adjacencyListToString() {
        StringBuilder sb = new StringBuilder();
        for (String node : adjacencyList.keySet()) {
            sb.append(node).append(": ");
            for (Edge edge : adjacencyList.get(node)) {
                sb.append("(").append(edge.getDestination()).append(", ").append(edge.getWeight()).append(") ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}