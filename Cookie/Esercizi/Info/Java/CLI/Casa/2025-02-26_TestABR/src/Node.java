public class Node<T extends Comparable<T> & FileCSV>{
    private T value;
    private Node<T> left, right;
    private boolean exists;

    /// GETTER - SETTER
    public T getValue(){
        return this.value;
    }
    public void setValue(T value){
        if(value != null)
            this.value = value;
        else
            throw new NullPointerException("Null pointer non valido");
    }

    public Node<T> getLeft() {
        return this.left;
    }
    public void setLeft(Node<T> left){
        this.left = left;
    }

    public Node<T> getRight() {
        return this.right;
    }
    public void setRight(Node<T> right){
        this.right = right;
    }

    public boolean doesExist() {
        return exists;
    }
    public void changeExists(){
        this.exists = !this.exists;
    }

    /// COSTRUTTORI
    public Node(T value){
        setValue(value);
        left = right = null;
        exists = true;
    }
    public Node(T value, Node<T> right, Node<T> left){
        setValue(value);
        this.left = left;
        this.right = right;
        exists = true;
    }

}