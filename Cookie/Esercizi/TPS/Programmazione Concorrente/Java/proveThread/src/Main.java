public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Pippo");
        Persona p2 = new Persona("Topolino");
        System.out.println(p1.saluta());
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        t1.start();
        t2.start();
        System.out.println(Thread.activeCount());
        System.out.println(Thread.getAllStackTraces());
    }
}