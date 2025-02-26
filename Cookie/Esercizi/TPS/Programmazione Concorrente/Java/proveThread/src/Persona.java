public class Persona implements Runnable{
    private String nome;
    private int eta;

    public Persona(){
        this.nome = "pippoDefault";
        this.eta = 1;
    }
    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getEta() {
        return eta;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }

    public String saluta(){
        return ("Ciao, sono il thread " + Thread.currentThread().getName() + "e ho " + getEta() + " anni");
    }

    public void run(){
//        for(int k = 0; k < 5; k++){
            System.out.println(saluta());
//            try{
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}
