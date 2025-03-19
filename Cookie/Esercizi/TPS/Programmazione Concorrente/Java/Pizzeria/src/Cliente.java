public class Cliente implements Runnable{
    private Pizza p;

    public Cliente(Pizza p){
        this.p = p;
    }

    @Override
    public void run() {
        synchronized (p){
            try {
                while(!p.getStato().equals("Pronta"))
                    p.wait();

                Thread.sleep(1000);
                p.setStato("Mangiata");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}