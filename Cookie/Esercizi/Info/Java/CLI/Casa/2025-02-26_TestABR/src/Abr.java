/*
    Classe ABR su tipo generico T vincolato all'interfaccia Comparable e FileCsv: metodi costruttore,
    get e set del dato, add, importa ed esporta di file csv (e classe Nodo con get/set, fromCsv e toCsv)
    ed un main di esempio.
*/

import java.util.StringTokenizer;

public class Abr<T extends Comparable<T> & FileCSV> {
    private Node<T> root;

    /// COSTRUTTORE
    public Abr(){
        root = null;
    }

    /// METODI
    public void add(T value){
        Node<T> nodo = new Node<>(value);
        if(this.root == null){
            this.root = nodo;
            this.root.setLeft(null);
            this.root.setRight(null);
        }
        else{
            addRec(this.root, nodo);
        }
    }
    private void addRec(Node<T> subRoot, Node<T> nodo){
        if(nodo.getValue().compareTo(subRoot.getValue()) > 0){
            if(subRoot.getRight() == null)
                subRoot.setRight(nodo);
            else
                addRec(subRoot.getRight(), nodo);
        }
        else {
            if(subRoot.getLeft() == null)
                subRoot.setLeft(nodo);
            else
                addRec(subRoot.getLeft(), nodo);
        }
    }

    public String esporta(){
        return this.concatRsd(root);
    }
    private String concatRsd(Node<T> n){
        String s = "";
        if(n != null){
            s = s.concat(n.toCSV());
            s = s.concat(concatRsd(n.getLeft()));
            s = s.concat(concatRsd(n.getRight()));
        }
        return s;
    }

    public void importa(String s, T aus){
        StringTokenizer toks = new StringTokenizer(s, ";");
        //?????????????
    }
}
