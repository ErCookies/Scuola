public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Pippo", 18);
        Persona p2 = new Persona("Plutus", 20);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();

        try {
            t1.join();
            //t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.activeCount());
        System.out.println(Thread.getAllStackTraces());
    }
}