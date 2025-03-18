import java.io.Serializable;

public class Node /*implements Serializable*/ {
    private String key;
    private Node left, right;
    private boolean exists;
    private long pos;

    /// GETTER - SETTER
    public String getKey(){
        return this.key;
    }
    public void setKey(String key){
        if(key != null)
            this.key = key;
        else
            throw new NullPointerException("Null pointer non valido");
    }

    public Node getLeft() {
        return this.left;
    }
    public void setLeft(Node left){
        this.left = left;
    }

    public Node getRight() {
        return this.right;
    }
    public void setRight(Node right){
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
    public void setPos(long pos){
        if(pos >= 0)
            this.pos = pos;
        else
            throw new IllegalArgumentException("Posizione non valida");
    }

    /// COSTRUTTORI
    public Node(String key)
            throws NullPointerException
    {
        setKey(key);
        left = right = null;
        exists = true;
    }

    public Node(String key, long pos)
            throws NullPointerException, IllegalArgumentException
    {
        setKey(key);
        left = right = null;
        exists = true;
        setPos(pos);
    }

    public Node(String key, Node right, Node left, long pos)
            throws NullPointerException, IllegalArgumentException
    {
        setKey(key);
        this.left = left;
        this.right = right;
        exists = true;
        setPos(pos);
    }

}