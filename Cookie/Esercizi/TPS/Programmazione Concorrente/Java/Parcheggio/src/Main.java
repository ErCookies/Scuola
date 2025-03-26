public class Main {
    public static void main(String[] args) {
        Parcheggio par = new Parcheggio(2);
        Auto a1 = new Auto("AA111AA", par);
        Auto a2 = new Auto("ZZ999ZZ", par);

        a1.setUncaughtExceptionHandler((t, e) ->
                System.out.println(t.getName() + " | " + e.getMessage()));

        a2.setUncaughtExceptionHandler((t, e) ->
                System.out.println(t.getName() + " | " +e.getMessage()));

        System.out.println("APERTURA PARCHEGGIO: " + par.getPostiLib());
        a1.start();
        a2.start();

        try {
            a1.join();
            a2.join();
        } catch (InterruptedException e) {
            System.out.println("porcodd");
        }

    }
}