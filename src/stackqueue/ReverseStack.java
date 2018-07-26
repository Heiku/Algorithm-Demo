package stackqueue;

import java.util.Stack;

/**
 * 题目：只是用递归倒序栈
 *
 * 思路：将递归想象成上下两半部分，上部分负责出栈赋值a，下部分负责入栈将a传入
 */
public class ReverseStack {

    int i = 0;
    public int[] reverseStackRecursively(int[] stack, int top) {

        if (top > 0){
            int a = stack[top - 1];
            i++;

            stack = reverseStackRecursively(stack, top -1);

            i--;
            stack[i] = a;
        }
        return stack;
    }

    public Stack<Integer> reverseStackRecursively(Stack<Integer> stack) {
        if (stack.empty()){
            return stack;
        }else {
            int a = stack.pop();
            stack = reverseStackRecursively(stack);
            stack.push(a);

            return stack;
        }


    }

    public static void main(String[] args) {
        int[] stack = {1,2,3,4,5};
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        new ReverseStack().reverseStackRecursively(s);

    }
}
