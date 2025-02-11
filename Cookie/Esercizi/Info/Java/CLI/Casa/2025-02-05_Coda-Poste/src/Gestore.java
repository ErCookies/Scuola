public class Gestore {
    MyList<MyList<Ticket>> code;

    public Gestore(){
        code = new MyList<>("Code");
        code.addLast(new MyList<>("A"));
        code.addLast(new MyList<>("B"));
        code.addLast(new MyList<>("C"));
    }



    public Gestore(int num){
        if(num > 0 && num < 26){
            code = new MyList<>("Code");
            for(int k = 0; k < num; k++)
                code.addFirst(new MyList<>(String.valueOf(k+65)));
        }
        else
            throw new IllegalArgumentException("Numero code non valido");
    }
}
