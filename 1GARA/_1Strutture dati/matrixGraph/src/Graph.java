import java.util.ArrayList;

public class Graph {

    private ArrayList<Node> nodes; //ArrayList contenente tutti i nodi [A,B,C,D,E]
    private int[][] matrix;

    Graph(int size){  //Creo il grafo
        nodes = new ArrayList<>(); //nuovo nodo
        matrix = new int[size][size]; //nuova matrice di dimensione nNodi
    }



    public void addNode(Node node) {
        nodes.add(node);// creo un nuovo oggetto nodo e lo aggiungo all'arraylist
    }

    public void addEdge(int src, int dst) {
        matrix[src][dst] = 1; //Aggiungo collegamento tra due nodi
    }

    public boolean checkEdge(int src, int dst) {
        boolean result = false;

        if(matrix[src][dst] == 1) {
            result = true;
        }
        return result;
    }


    public void print() {

        System.out.print("  ");

        for(Node node : nodes) {
            System.out.print(node.getData() + " ");
        }

        System.out.println();

        for(int i = 0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).getData() + " ");
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}
