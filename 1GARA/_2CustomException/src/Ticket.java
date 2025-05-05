public class Ticket {
    private int num;

    public Ticket(int num) throws CustomExcTest {
        setNum(num);
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        if(num <= 0) {
            throw new CustomExcTest("Numero ticket deve essere positivo");
        }
        else
            this.num = num;
    }
}
