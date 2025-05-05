public class Main {

    public static void main(String[] args) {

        // Adjacency Matrix = An array to store 1's/0's to represent edges
        //				       # of rows =    # of unique nodes
        //				       # of columns = # of unique nodes

        //					  runtime complexity to check an Edge: O(1)
        //					  space complexity: O(v^2)

        Graph graph = new Graph(5); //CREO GRAFO DI DIMENSIONE 5x5

        graph.addNode(new Node('A')); //CREO NODI (nodo 0)
        graph.addNode(new Node('B')); //CREO NODI (nodo 1)
        graph.addNode(new Node('C')); //CREO NODI (nodo 2)
        graph.addNode(new Node('D')); //CREO NODI (nodo 3)
        graph.addNode(new Node('E')); //CREO NODI (nodo 4)

        graph.addEdge(0, 1); //CREO I COLLEGAMENTI DEI NODI(nodo 0 -> nodo 1)
        graph.addEdge(1, 2); //CREO I COLLEGAMENTI DEI NODI(nodo 1 -> nodo 2)
        graph.addEdge(1, 4); //CREO I COLLEGAMENTI DEI NODI(nodo 1 -> nodo 4)
        graph.addEdge(2, 3); //CREO I COLLEGAMENTI DEI NODI(nodo 2 -> nodo 3)
        graph.addEdge(2, 4); //CREO I COLLEGAMENTI DEI NODI(nodo 2 -> nodo 4)
        graph.addEdge(4, 0); //CREO I COLLEGAMENTI DEI NODI(nodo 4 -> nodo 0)
        graph.addEdge(4, 2); //CREO I COLLEGAMENTI DEI NODI(nodo 4 -> nodo 2)

        graph.print();

        //System.out.println(graph.checkEdge(0, 1));

    }

}

