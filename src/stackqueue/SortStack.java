package stackqueue;

import java.util.Stack;

/**
 * 题目：用一个栈实现另一个栈的排序
 *
 * 思路：利用一个辅助排序栈，遍历stack，根据每个元素的大小，如果 < sort.peek()，将sort的前几个放回stack，插入指定位置。
 */
public class SortStack {

    public void sortStack(Stack<Integer> stack) {
        Stack<Integer> sort = new Stack<>();

        while (!stack.isEmpty()) {
            int a = stack.pop();

            while (!sort.isEmpty() && sort.peek() > a) {
                stack.push(sort.pop());
            }
            sort.push(a);
        }

        while (!sort.empty()){
            stack.push(sort.pop());
        }

    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(1);
        stack.push(8);
        stack.push(7);

        new SortStack().sortStack(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
