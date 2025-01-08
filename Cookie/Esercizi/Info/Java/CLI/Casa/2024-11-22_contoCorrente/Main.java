/*
    Francesco Cucchi    4BI

    TESTO:
    Esercizio in preparazione alla verifica:
    1) realizzare una classe ContoCorrente che permette la gestione di un conto corrente bancario.
      Attributi da definire che permettono di identificare un cc.
      Metodi che permettono di impostare un conto corrente alla sua apertura,
      realizzare prelievo e versamento su di esso (con controlli), conoscere il saldo.
    2) realizzare il programma presente allo sportello che prevede,
      dopo la creazione di un conto corrente, di effettuare più operazioni
      di versamento e di prelievo (con feedback) a scelta dell'utente
    3) disegnare lo schema delle classi (UML) e documentazione della classe CC
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sc;
        ContoCor cc;
        cc = insDati();
        do{
            menu();
            sc = lgInt(0,3,"Inserire funzione interessata: ");
            switch(sc){
                case 1:{
                    prelievo(cc);
                    break;
                }
                case 2:{
                    versamento(cc);
                    break;
                }
                case 3:{
                    System.out.println("Saldo: " + cc.getSaldo());
                }
                case 0: break;
            }
        }while(sc != 0);
    }

    public static ContoCor insDati(){
        ContoCor cc;
        String cod;
        double saldo;
        cod = lgStr("Inserire codice: ");
        saldo = lgDbl(0, Double.MAX_VALUE, "Inserire saldo: ");
        try{
            cc = new ContoCor(cod, saldo);
        }
        catch(IllegalArgumentException exc){
            System.out.println(exc.getMessage());
            System.out.println("Creazione conto corrente con valori default");
            cc = new ContoCor();
        }
        return cc;
    }

    public static void prelievo(ContoCor cc){
        double amount;
        amount = lgDbl(0, Double.MAX_VALUE, "Inserire quantitativo da ritirare: ");
        try{
            cc.prelievo(amount);
        }
        catch(IllegalArgumentException exc){
            System.out.println(exc.getMessage());
        }
    }

    public static void versamento(ContoCor cc){
        double amount;
        amount = lgDbl(0, Double.MAX_VALUE, "Inserire quantitativo da versare: ");
        try{
            cc.versamento(amount);
        }
        catch(IllegalArgumentException exc){
            System.out.println(exc.getMessage());
        }
    }

    public static int lgInt(int vmin, int vmax, String mex){
        Scanner in = new Scanner(System.in);
        int x;
        System.out.print(mex);
        x = in.nextInt();
        while(x < vmin || x > vmax){
            System.out.print("Errore\n" + mex);
            x = in.nextInt();
        }
        return x;
    }
    public static double lgDbl(double vmin, double vmax, String mex){
        Scanner in = new Scanner(System.in);
        double x;
        System.out.print(mex);
        x = in.nextDouble();
        while(x < vmin || x > vmax){
            System.out.print("Errore\n" + mex);
            x = in.nextDouble();
        }
        return x;
    }
    public static String lgStr(String mex){
        String s;
        Scanner in = new Scanner(System.in);
        System.out.print(mex);
        //in.next();
        s = in.next();
        while(s.isEmpty()){
            System.out.print("Errore\n" + mex);
            in.next();
            s = in.next();
        }
        return s;
    }
    public static void menu(){
        System.out.println("1) Prelievo dal conto;");
        System.out.println("2) Versamento sul conto;");
        System.out.println("3) Conoscere il saldo attuale;");
        System.out.println("0) Termina il programma;");
    }
}