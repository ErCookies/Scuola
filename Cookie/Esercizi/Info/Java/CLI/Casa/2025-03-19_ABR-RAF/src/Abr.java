import javax.management.openmbean.KeyAlreadyExistsException;
import java.io.*;

public class Abr {
    private Node root;

    /// COSTRUTTORE
    public Abr()
    {
        root = null;
    }

    /// METODI
    public void add(String value)
    {
        Node nodo;
        if(this.search(value) == -1){
            nodo = new Node(value);
            if(this.root == null){
                this.root = nodo;
                this.root.setLeft(null);
                this.root.setRight(null);
            }
            else{
                addRec(this.root, nodo);
            }
        }
        else
            throw new KeyAlreadyExistsException("Chiave gia' registrata");
    }
    public void add(String value, long pos)
    {
        Node nodo = new Node(value, pos);
        if(this.root == null){
            this.root = nodo;
            this.root.setLeft(null);
            this.root.setRight(null);
        }
        else{
            addRec(this.root, nodo);
        }
    }
    private void addRec(Node subRoot, Node nodo)
    {
        if(nodo.getKey().compareTo(subRoot.getKey()) > 0){
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

    public void esporta(String filename)
            throws IOException
    {
        PrintWriter fout = new PrintWriter(new FileWriter(filename));
        fout.print(this.concatRsd(root));
        fout.close();
    }
    private String concatRsd(Node n)
    {
        String s = "";
        if(n != null){
            s = s.concat(n.getKey() + '\n');
            s = s.concat(concatRsd(n.getLeft()));
            s = s.concat(concatRsd(n.getRight()));
        }
        return s;
    }

    public void importa(String filename)
            throws IOException
    {
        BufferedReader fin = new BufferedReader(new FileReader(filename));
        String row = fin.readLine();
        while(row != null){
            this.add(row);
            row = fin.readLine();
        }
        fin.close();
    }
    public void importa(RandomAccessFile raf)
            throws IOException
    {
        this.root = null;
        raf.seek(0);
        long curPos;
        for(int k = 0; raf.getFilePointer() <= raf.length(); k++){
            curPos = raf.getFilePointer();
            this.add(Input.readString(raf, Macchina.LENSTR), curPos);
            raf.seek(((long)Macchina.LENREC * (k + 1)));
        }
    }

    public long search(String key)
    {
        if(!key.isEmpty())
            return searchRec(this.root, key);
        else
            throw new IllegalArgumentException("Stringa vuota");
    }
    private long searchRec(Node subRoot, String key)
    {
        long tro;
        if(subRoot == null)
            tro = -1;
        else {
            if(key.compareTo(subRoot.getKey()) == 0)
                tro = subRoot.getPos();
            else if(key.compareTo(subRoot.getKey()) > 0)
                tro = searchRec(subRoot.getRight(), key);
            else
                tro = searchRec(subRoot.getLeft(), key);
        }
        return tro;
    }
}
