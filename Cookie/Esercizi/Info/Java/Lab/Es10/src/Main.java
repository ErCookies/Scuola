public class Main {
    public static void main(String[] args) {
        String s = "";
        for(int k = 0; k < 5; k++)
            s += (char)((Math.random() * 26) + 97);
        int x = (int)(Math.random() * 10);
        System.out.println("Stringa random: " + s);
        System.out.println("Numero random: " + x);
    }
}