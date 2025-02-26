import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Abr<Ticket> albero = new Abr<>();
        for(int k = 0; k < 6; k++)
            albero.add(new Ticket(Input.lgInt(0, 100, "Inserire numero: ")));

        try{
            albero.esporta("test.csv");
        }
        catch(IOException e){
            System.out.println("Impossibile procedere con l'esportazione");
        }
    }
}