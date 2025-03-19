public class Foglio {
    private String contenuto;

    public Foglio() {
        setContenuto("");
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public void addContenuto(String contenutoAdd){
        contenuto += contenutoAdd;
        this.notify();
    }
}
