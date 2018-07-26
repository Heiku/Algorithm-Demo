package classic;

/**
 * 题目：汉诺塔
 * 思路：递归，分为三部：A -> C
 *              n-1 A(C) -> B
 *                  A -> C
 *                  B(A) -> C
 */
public class HanoiTower {

    public static void hannoi(int n, int a, int b, int c){
        if (n ==1)
            System.out.println("" + a + " -> " + c);
        else {
            hannoi(n-1, a, c, b);

            System.out.println("" + a +  " -> " + c);

            hannoi(n-1, b, a, c);
        }
    }

    public static void main(String[] args) {
        hannoi(3, 1, 2, 3);
    }
}
