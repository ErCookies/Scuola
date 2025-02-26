public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        Cliente cliente = new Cliente(pizza);
        Pizzaiolo pizzaiolo = new Pizzaiolo(pizza, cliente);

        Thread tPiz = new Thread(pizzaiolo, "Pizzaiolo");
        Thread tCli = new Thread(cliente, "Cliente");

        System.out.println(pizza.getStato());

        synchronized (pizza) {
            try {
                tPiz.start();
                tCli.start();
                while (!pizza.getStato().equals("Mangiata")) {
                    pizza.wait();
                    System.out.println(pizza.getStato());
                    pizza.notify();
                }
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Cliente soddisfatto");

    }
}