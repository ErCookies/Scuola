public class Persona implements Runnable{
    private String nome;

    public Persona(){
        this.nome = "pippoDefault";
    }
    public Persona(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String saluta(){
        return ("Ciao, sono il thread " + getNome());
    }

    public void run(){
        for(int k = 0; k < 5; k++){
            System.out.println((k+1) + ") " + saluta());
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
