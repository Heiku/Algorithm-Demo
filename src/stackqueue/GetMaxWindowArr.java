package stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：数组[4,3,5,4,3,3,6,7]，根据滑动窗口的大小ws，得到每个滑动窗口的max，要求时间复杂度 O(n)
 *
 * 思路：建议辅助双向队列queue，只存储数组下标，遍历数组，如果 now value <= arr[queue last] ，那么enqueue
 *                                                              >                  ，while，将queue的下标清空，enqueue now
 *                                               注意 每 ws 个窗口，一个max，将多余的元素 head queue 出队
 *                                               同时，从 下标 w-1，开始赋值到res
 */
public class GetMaxWindowArr {

    public int[] getMaxWindow(int []arr, int ws){

        if (arr == null || ws < 1 || arr.length < 0)
            return null;

        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[arr.length - 1];

        int index = 0;
        for (int i = 0; i < arr.length; i++){
            while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            // 控制每三个一个最大
            if (queue.peekFirst() == i - ws)
                queue.pollFirst();
            // 从2开始数组赋值
            if (i >= ws - 1)
                res[index++] = arr[queue.peekFirst()];
        }

        return res;
    }

    /*public int[] getMaxWindow(int []arr, int ws){
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= arr.length - ws; i++){
            int max = arr[i];
            if (arr[i + 1] > max)
                max = arr[i + 1];
            if (arr[i+2] > max)
                max = arr[i + 2];

            queue.add(max);
        }

        int []res = new int[queue.size()];
        for (int i = 0; i < queue.size(); i++){
            res[i] = queue.get(i);
        }

        return res;
    }*/

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,5,4,3,3,6,7};
        int ws = 3;

        int []res = new GetMaxWindowArr().getMaxWindow(arr, ws);
        for (int a: res
             ) {
            System.out.println(a);
        }
    }
}
