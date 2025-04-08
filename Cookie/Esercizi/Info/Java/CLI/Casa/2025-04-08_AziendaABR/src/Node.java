public class Node {
    private final int key;
    private final long pos;
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

    public long getPos() {
        return pos;
    }

    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
}
