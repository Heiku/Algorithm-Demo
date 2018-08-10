package interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Heiku on 2018/8/10
 */
public class NiuNiuFindJob {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 工作数量
        int work = sc.nextInt();
        // 总人数
        int people = sc.nextInt();

        // 工作(难度，报酬)
        int [][]arr = new int[work][2];

        // 能力值
        int[] power = new int[people];

        for (int i = 0; i < work; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int i = 0; i < people; i++){
            power[i] = sc.nextInt();
        }

        // 难度排序
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 获取最大报仇
        for (int i = 1; i < work; i++){
            arr[i][1] = Math.max(arr[i - 1][1], arr[i][1]);
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < work; i++){
            // key 难度，value 薪酬
            treeMap.put(arr[i][0], arr[i][1]);
        }

        for (int i = 0;  i< people; i++){
            if (treeMap.floorKey(power[1]) != null){
                System.out.println(treeMap.get(treeMap.floorKey(power[i])));
            }else {
                System.out.println(0);
            }
        }
    }
}
