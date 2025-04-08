public class ABR {
    private Node root;

    public void add(int key)
    {
        //
    }

    public long search(Node root, int key){
        long pos;
        if(root == null)
            pos = -1;
        else if(root.getKey() == key)
            pos = root.getPos();
        else if(key < root.getKey())
            pos = search(root.getLeft(), key);
        else
            pos = search(root.getRight(), key);
        return pos;
    }
}
