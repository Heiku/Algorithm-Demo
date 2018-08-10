package interview;

import java.util.Scanner;

/**
 * Created by Heiku on 2018/8/11
 */
public class NiuNiuNumberCouple {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        long count = 0;

        if (k == 0)
            count = n * n;
        else {

            for (int i = k + 1; i < n; i++) {

                count += (n / i) * (i - k);

                if (n % i >= k)
                    count += n % i - k + 1;

            }
        }
        System.out.println(count);
    }
}
