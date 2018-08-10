import java.util.ArrayList;

public class Main {
    int count = 21;
    public static void main(String[] args) {
        new Main().count();
        new Main().count();

    }

    public void count(){
        System.out.println(++count);
    }
}
