public class Main {
    public static void main(String[] args) {
        Foglio f = new Foglio();
        Printer p1 = new Printer(f);
        Printer p2 = new Printer(f);
        Thread tp1 = new Thread(p1, "zola");
        Thread tp2 = new Thread(p2, "sic");
        tp1.start();
        tp2.start();

        try {
            tp1.join();
            tp2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(f.getContenuto());
        System.out.print("STAMPA EFFETTUATA");
    }
}