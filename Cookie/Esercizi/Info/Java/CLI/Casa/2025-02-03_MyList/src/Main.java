public class Main {
    public static void main(String[] args) {
        MyList<Integer> lista = new MyList<>();
        lista.add(5);
        System.out.println(lista.removeLast());
    }
}