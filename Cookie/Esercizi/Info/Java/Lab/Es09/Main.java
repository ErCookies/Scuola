import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sc;
        Sim sim;
        sim = insDati();
        do {
            menu();
            sc = lgInt(0, 6, "Inserire funzione interessata: ");
            switch (sc) {
                case 1: {
                    sim.attivazione(true);
                    break;
                }
                case 2: {
                    System.out.println(sim.toStrin());
                    break;
                }
                case 3: {
                    ricarica(sim);
                    break;
                }
                case 4: {
                    telefonata(sim);
                    break;
                }
                case 5: {
                    System.out.println(sim.convertMinToHhMm());
                    break;
                }
                case 6: {
                    sim.attivazione(false);
                    break;
                }
                case 0:
                    break;
            }
        } while (sc != 0);
    }

    public static Sim insDati(){
        String nome, iccid, numtel;
        nome = lgStr("Inserire nome intestatario: ");
        iccid = lgStr("Inserire ICCID: ");
        numtel = lgStr("Inserire numero tel: ");
        return new Sim(nome, iccid, numtel);
    }

    public static void ricarica(Sim sim){
        int x = lgInt(0, 20, "Inserire quantitativo (5-10-20): ");
        while(x != 5 && x != 10 && x != 20){
            System.out.println("errore");
            x = lgInt(0, 20, "Inserire quantitativo (5-10-20): ");
        }
        sim.ricarica(x);
    }

    public static void telefonata(Sim sim){
        double x = lgDbl(0, Integer.MAX_VALUE, "Inserire durata: ");
        sim.chiamata(x);
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
    public static double lgDbl(double vmin, double vmax, String mex){
        Scanner in = new Scanner(System.in);
        double x;
        System.out.print(mex);
        x = in.nextInt();
        while(x < vmin || x > vmax){
            System.out.println("Errore");
            System.out.print(mex);
            x = in.nextInt();
        }
        return x;
    }
    public static String lgStr(String mex){
        Scanner in = new Scanner(System.in);
        String s = new String();
        System.out.print(mex);
        s = in.next();
        while(s.isEmpty()){
            System.out.println("Errore");
            System.out.print(mex);
            s = in.next();
        }
        return s;
    }

    public static void menu(){
        System.out.println("1) Attiva SIM");
        System.out.println("2) Stampa dati SIM");
        System.out.println("3) Ricarica SIM");
        System.out.println("4) Effettua telefonata");
        System.out.println("5) Visualizza hh:mm chiamate");
        System.out.println("6) Disattiva SIM");
        System.out.println("0) Termina il programma;");
    }
}