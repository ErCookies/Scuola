/*
Creare una classe che vada a gestire un set di numeri interi appartenenti ad un range prefissato.
Ogni gestore di numeri interi istanziato conoscerà il valore minimo, il valore massimo (in riferimento al range
da gestire) e se deve accettare numeri pari o numeri dispari.
La classe dovrà presentare i seguenti metodi:
1 - Costruttori:
    Default: istanzia un oggetto che accetta numeri pari compresi tra 0 e 200
    Con parametri
    Di copia
2 - Getters e Setters
3 - Un metodo per aggiungere un numero al set
4 - Un metodo che restituisce una stringa csv di tutti i numeri del set
5 - Un metodo che restituisce la media dei numeri del set
6 - Un metodo che restituisce, in base ad un valore passato come parametro,
    il numero massimo o il numero minimo, tra i numeri del set

Crea un programma di prova che verifichi il funzionamento della classe.
*/

public class Numbers {
    private int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE, n;
    private int[] nums = null;
    private boolean even;
    private int nmax;

    public Numbers(){
        this.setEven(true);
        this.setMin(0);
        this.setMax(200);
        this.n = 0;
        this.nums = new int[this.nmax];
    }
    public Numbers(boolean even, int min, int max, int nmax){
        this.n = 0;
        this.setEven(even);
        if(this.setMin(min))
            if(this.setMax(max))
                if(this.setNmax(nmax))
                    this.nums = new int[this.nmax];

    }
    public Numbers(Numbers n){
        this.n = n.n;
        this.setEven(n.even);
        this.setMax(n.max);
        this.setMin(n.min);
        this.nums = new int[this.nmax];
    }
    public boolean setMin(int min) {
        boolean val = true;
        if(min < this.getMax())
            this.min = min;
        else
            val = false;
        return val;
    }
    public boolean setMax(int max) {
        boolean val = true;
        if(max > this.getMin())
            this.max = max;
        else
            val = false;
        return val;
    }
    public void setEven(boolean even) {
        this.even = even;
    }
    public boolean setNmax(int nmax) {
        boolean val = true;
        if(nmax > 0)
            this.nmax = nmax;
        else
            val = false;
        return val;
    }
    public int getMin() {
        return this.min;
    }
    public int getMax() {
        return this.max;
    }
    public boolean getEven() {
        return this.even;
    }
    public int getNum(int pos){
        int x = 0;
        if(pos < this.n && pos > 0)
            x = this.nums[pos];
        return x;
    }
    public int getN(){
        return this.n;
    }
    public int getNmax(){
        return this.nmax;
    }

    public void add(int n) {
        if(n >= this.getMin() && n <= this.getMax()){
            if(this.getEven()){
                if(n % 2 == 0){
                    this.nums[this.n] = n;
                    (this.n)++;
                }
            }
            else {
                if (n % 2 != 0) {
                    this.nums[this.n] = n;
                    (this.n)++;
                }
            }
        }
    }

    public String to_csv(){
        String s = null;
        if(this.n != 0){
            s = new String();
            for(int k = 0; k < n; k++){
                s = s.concat(Integer.toString(this.nums[k]) + ";");
                System.out.println(k);
            }
            s = s.concat("\n");
        }
        return s;
    }

    public double average(){
        double tot = 0;
        for(int k = 0; k < this.n; k++)
            tot += this.nums[k];
        return tot/this.n;
    }

    public int minMax(boolean ch){
        int val = this.nums[0];
        if(ch){
            for(int k = 1; k < n; k++){
                if(this.nums[k] > val)
                    val = this.nums[k];
            }
        }
        else{
            for(int k = 1; k < n; k++){
                if(this.nums[k] < val)
                    val = this.nums[k];
            }
        }
        return val;
    }
}