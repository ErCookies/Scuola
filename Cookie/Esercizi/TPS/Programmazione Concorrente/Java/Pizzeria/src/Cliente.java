public class Cliente implements Runnable{
    private Pizza p;

    public Cliente(Pizza p){
        this.p = p;
    }

    @Override
    public void run() {
        synchronized (p){
            try {
                p.wait();
                p.setStato("Mangiata");
                notify();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}