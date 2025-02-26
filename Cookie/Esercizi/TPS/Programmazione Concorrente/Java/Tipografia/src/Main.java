public class Main {
    public static void main(String[] args) {
        Foglio f = new Foglio();
        Printer p1 = new Printer(f);
        Printer p2 = new Printer(f);
        Thread tP1 = new Thread(p1, "Zola");
        Thread tP2 = new Thread(p2, "Sicc");
        tP1.start();
        tP2.start();

        try {
            tP1.join();
            tP2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(f.getContenuto());
        System.out.println("STAMPA EFFETTUATA");
    }
}