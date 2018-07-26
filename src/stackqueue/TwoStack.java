package stackqueue;


import java.util.Stack;

/**
 * 题目：两个stack实现queue
 *
 * 思路：stack1，stack2，每次push到stack1之前，将stack2之前的数据push到stack1，
 *                      每次pop之前，将stack1的数据push到stack2
 */
public class TwoStack {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {

        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }
}
