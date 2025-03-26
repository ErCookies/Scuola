public class Auto extends Thread{
    private String targa;
    private Parcheggio par;

    public String getTarga() {
        return targa;
    }
    public void setTarga(String targa) {
        if(!targa.isEmpty()){
            setName(targa);
            this.targa = targa;
        }
        else
            throw new IllegalArgumentException("Inserire una targa");
    }

    public Parcheggio getPar() {
        return par;
    }
    public void setPar(Parcheggio par) {
        this.par = par;
    }

    public Auto(String targa, Parcheggio par) throws IllegalArgumentException{
        setTarga(targa);
        this.par = par;
    }

    public void entra()
            throws IllegalStateException, InterruptedException {
        par.entrataAuto();
    }

    public void esci()
            throws IllegalStateException, InterruptedException {
        par.uscitaAuto();
    }

    @Override
    public void run()
            throws IllegalStateException
    {
        synchronized (this.par){
            try {
                entra();
                System.out.println("ENTRATA: " + par.getPostiLib());
                par.notify();
                par.wait();
                Thread.sleep(2000);
                par.notify();
                esci();
                System.out.println("USCITA: " + par.getPostiLib());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
