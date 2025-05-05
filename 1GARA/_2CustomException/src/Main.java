public class Main {
    public static void main(String[] args) {
        try {
            Ticket ticket = new Ticket(-1);
        } catch (CustomExcTest e) {
            System.out.println("Eccezione: " + e.getMessage());
        }
    }
}