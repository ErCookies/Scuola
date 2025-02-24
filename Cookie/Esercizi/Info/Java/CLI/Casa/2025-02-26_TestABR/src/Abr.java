/*
    Classe ABR su tipo generico T vincolato all'interfaccia Comparable e FileCsv: metodi costruttore,
    get e set del dato, add, importa ed esporta di file csv (e classe Nodo con get/set, fromCsv e toCsv)
    ed un main di esempio.
*/

public class Abr<T extends Comparable<T> & FileCSV> {
    private Node<T> root;

    /// COSTRUTTORE
    public Abr(){
        root = null;
    }

    /// METODI
    public void add(T value){
        //
    }
}
