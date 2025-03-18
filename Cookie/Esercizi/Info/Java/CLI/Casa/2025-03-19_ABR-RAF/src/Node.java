public class Node<T extends Comparable<T> & FileCSV>{
    private T key;
    private Node<T> left, right;
    private boolean exists;
    private long pos;

    /// GETTER - SETTER
    public T getKey(){
        return this.key;
    }
    public void setKey(T key){
        if(key != null)
            this.key = key;
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

    public long getPos(){
        return this.pos;
    }
    //setPoslong pos()

    /// COSTRUTTORI
    public Node(T key){
        setKey(key);
        left = right = null;
        exists = true;
    }
    public Node(T key, Node<T> right, Node<T> left, long pos){
        setKey(key);
        this.left = left;
        this.right = right;
        exists = true;

    }

}