public class Pizzaiolo implements Runnable{
    private Pizza p;
    private Cliente c;

    public Pizzaiolo(Pizza p, Cliente c) {
        this.p = p;
        this.c = c;
    }

    public Pizza getP() {
        return p;
    }
    public void setP(Pizza p) {
        this.p = p;
    }

    public Cliente getC() {
        return c;
    }
    public void setC(Cliente c) {
        this.c = c;
    }

    @Override
    public void run() {
        synchronized (p){
            try {
                Thread.sleep(500);
                p.setStato("In Cottura");
                p.notify();
                p.wait();
                Thread.sleep(p.gettCott() * 1000L);
                p.settCott(0);
                p.setStato("Pronta");
                p.notify();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
