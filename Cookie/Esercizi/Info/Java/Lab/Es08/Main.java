import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Numbers nums;
        int sc;
        nums = insDati();
        do{
            menu();
            sc = lgInt(0,4,"Inserire funzione interessata: ");
            switch(sc){
                case 1:{
                    nums.add(lgInt(Integer.MIN_VALUE, Integer.MAX_VALUE, "Inserire numero da aggiungere al set: "));
                    break;
                }
                case 2:{
                    System.out.println(nums.to_csv());
                    break;
                }
                case 3:{
                    System.out.println("Media: " + nums.average());
                    break;
                }
                case 4:{
                    System.out.println(nums.minMax(lgInt(0,1,"Valore min o max? (0-1): ") == 1));
                    break;
                }
                case 0: break;
            }
        }while(sc != 0);
    }

    public static Numbers insDati(){
        int aus, min, max, nmax;
        boolean even;
        Numbers nums;
        aus = lgInt(0,1,"Pari o dispari (0/1): ");
        even = (aus == 0);
        min = lgInt(Integer.MIN_VALUE, Integer.MAX_VALUE, "Valore minimo del range: ");
        max = lgInt(min, Integer.MAX_VALUE, "Valore massimo del range: ");
        nmax = lgInt(1, Integer.MAX_VALUE, "Numero valori massimo del range: ");
        nums = new Numbers(even, min, max, nmax);
        return nums;
    }

    public static int lgInt(int vmin, int vmax, String mex){
        Scanner in = new Scanner(System.in);
        int x;
        System.out.print(mex);
        x = in.nextInt();
        while(x < vmin || x > vmax){
            System.out.println("Errore");
            System.out.print(mex);
            x = in.nextInt();
        }
        return x;
    }
    public static void menu(){
        System.out.println("1) Aggiungi un numero al set;");
        System.out.println("2) Trasforma in csv il set;");
        System.out.println("3) Media dei valori del set;");
        System.out.println("4) Ritorna val minimo o massimo fra quelli del set;");
        System.out.println("0) Termina il programma;");
    }
}