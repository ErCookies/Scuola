public class BinarySearchTree {

    Node root;

    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        
        int data = node.getData();

        if(root == null) {
            root = node;
            return root;
        }

        else if(data < root.getData()) {
            root.setLeft(insertHelper(root.getLeft(), node));
        }else{
            root.setRight(insertHelper(root.getRight(), node));
        }
        
        return root;
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(Node root) {
        if(root != null) {
            displayHelper(root.getLeft());
            System.out.println(root.getData());
            displayHelper(root.getRight());
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int data) {
        
        if(root == null) {
            return false;
        }else if(root.getData() == data) {
            return true;
        }else if(root.getData() > data) {
            return searchHelper(root.getLeft(), data);
        }else {
            return searchHelper(root.getRight(), data);
        }
    }

    public void remove(int data) {
        
        if(search(data)) {
            removeHelper(root, data);
        }else {
            System.out.println(data + " could not be found");
        }
    }   

    private Node removeHelper(Node root, int data) {

        if(root == null) {
            return root;
        }

        else if(data < root.getData()) {
            root.setLeft(removeHelper(root.getLeft(), data));
        }

        else if(data > root.getData()) {
            root.setRight(removeHelper(root.getRight(), data));
        }else { // node found
            if(root.getLeft() == null && root.getRight() == null) {
                root = null;
            }

            else if(root.getRight() != null) { //find a successor to replace this node
                root.setData(successor(root));
                root.setRight(removeHelper(root.getRight(), root.getData()));
            }else { //find a predecessor to replace this node
                root.setData(predecessor(root));
                root.setLeft(removeHelper(root.getLeft(), root.getData()));
            }
        }
        return root;

    }

    private int successor(Node root) { //find the least value below the right child of this root node

        root = root.getRight();
        while(root.getLeft() != null){
            root = root.getLeft();
        }
        return root.getData();
    }

    private int predecessor(Node root) {//find the greatest value below the left child of this root node
        
        root = root.getLeft();
        while(root.getRight() != null){
            root = root.getRight();
        }
        return root.getData();
    }

}
