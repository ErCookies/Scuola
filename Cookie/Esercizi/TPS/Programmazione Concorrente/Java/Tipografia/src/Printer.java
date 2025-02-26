public class Printer implements Runnable{
    private Foglio f;

    public Printer(Foglio f){
        this.f = f;
    }
    public Foglio getF() {
        return this.f;
    }
    public void setF(Foglio f) {
        this.f = f;
    }

    @Override
    public void run() {
        String nomeT = Thread.currentThread().getName();
        synchronized (f){
            for(int k = 0; k < 3; k++){
                f.addContenuto(nomeT + " - " + k + '\n');
            }
        }
    }
}
