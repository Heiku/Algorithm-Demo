import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(2);

        list.stream().sorted().forEach(i -> System.out.println(i));
    }
}
