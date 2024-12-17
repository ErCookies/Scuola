public class Main {
    public static void main(String[] args) {
        int sc;
        Sim sim;
        sim = insDati();
        do {
            menu();
            sc = Input.lgInt(0, 6, "Inserire funzione interessata: ");
            switch (sc) {
                case 1: {
                    cambioState(true, sim);
                    break;
                }
                case 2: {
                    System.out.println(sim.toString());
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
                    cambioState(false, sim);
                    break;
                }
                case 0:
                    break;
            }
        } while (sc != 0);
    }

    public static Sim insDati(){
        Sim s;
        String nome, iccid, numtel, opt;
        nome = Input.lgStr("Inserire nome intestatario: ");
        iccid = Input.lgStr("Inserire ICCID: ");
        numtel = Input.lgStr("Inserire numero tel: ");
        opt = Input.lgStr("Inserire operatore: ");
        try{
            s = new Sim(nome, iccid, numtel, opt);
        }
        catch(IllegalArgumentException exc){
            System.out.println(exc.getMessage());
            System.out.println("Creazione SIM default");
            s = new Sim();
        }

        return s;
    }

    public static void cambioState(boolean state, Sim sim){
        try{
            sim.attivazione(state);
        }
        catch(IllegalArgumentException exc){
            System.out.println(exc.getMessage());
        }
    }

    public static void ricarica(Sim sim){
        try{
            int x = Input.lgInt(5, 20, "Inserire quantitativo (5-10-20): ");
            while(x != 5 && x != 10 && x != 20){
                System.out.println("errore");
                x = Input.lgInt(5, 20, "Inserire quantitativo (5-10-20): ");
            }
            sim.ricarica(x);
        }
        catch(IllegalStateException exc){
            System.out.println(exc.getMessage());
        }
    }

    public static void telefonata(Sim sim){
        try{
            double x = Input.lgDbl(0, Integer.MAX_VALUE, "Inserire durata: ");
            sim.chiamata(x);
        }
        catch(IllegalStateException exc){
            System.out.println(exc.getMessage());
        }
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