import javax.management.openmbean.KeyAlreadyExistsException;

public class ABR {
    private Node root;

    public ABR()
    {
        root = null;
    }

    public void add(int key, long pos)
    {
        if(root == null)
            root = new Node(key, 0);
        else {
            if(search(key) != -1)
                throw new KeyAlreadyExistsException("Chiave gia' presente");
            else
                addRec(root, key, pos);
        }
    }

    private void addRec(Node root, int key, long pos)
    {
        if(key < root.getKey()) {
            if(root.getLeft() == null) {
                root.setLeft(new Node(key,pos));
            }
            else {
                addRec(root.getLeft(), key, pos);
            }
        }
        else if(key > root.getKey()) {
            if(root.getRight() == null) {
                root.setRight(new Node(key,pos));
            }
            else {
                addRec(root.getRight(), key, pos);
            }
        }
    }

    public long search(int key)
    {
        long pos;
        if(root == null)
            throw new IllegalStateException("Albero vuoto");
        else if(root.getKey() == key)
            pos = root.getPos();
        else
            pos = searchRec(root, key);

        return pos;
    }

    private long searchRec(Node root, int key)
    {
        long pos;
        if(root == null)
            pos = -1;
        else if(root.getKey() == key)
            pos = root.getPos();
        else if(key < root.getKey())
            pos = searchRec(root.getLeft(), key);
        else
            pos = searchRec(root.getRight(), key);
        return pos;
    }
}
