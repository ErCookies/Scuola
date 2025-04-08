public class Node {
    private int key;
    private long pos;
    private Node left, right;

    public Node(int key, long pos)
            throws IllegalArgumentException
    {
        this.key = key;
        this.pos = pos;
        left = right = null;
    }

    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }

    public long getPos() {
        return pos;
    }
    public void setPos(long pos) {
        if(pos < 0)
            throw new IllegalArgumentException("Posizione non valida");
        else
            this.pos = pos;
    }
}
