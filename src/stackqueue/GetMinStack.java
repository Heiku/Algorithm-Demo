package stackqueue;

import java.util.Stack;


/**
 * 题目：getMin功能的Stack
 *
 * 思路：利用两个栈，（data,min），在push的过程中判断是否要入min栈中
 */
public class GetMinStack {

    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        if (minStack.empty()){
            minStack.push(node);
        }else if (node <= minStack.peek()){
            minStack.push(node);
        }

        dataStack.push(node);
    }

    public void pop() {
        if (dataStack.empty()){
            throw new RuntimeException();
        }else if (dataStack.peek() == minStack.peek()){
            dataStack.pop();
            minStack.pop();
        }else {
            dataStack.pop();
        }
    }

    public int top() {
        return 0;
    }

    public int min() {
        if (minStack.empty()){
            return -1;
        }
        else
            return minStack.peek();
    }

    public static void main(String[] args) {

        GetMinStack g = new GetMinStack();

        g.push(3);
        System.out.println(g.min());
        g.push(4);
        System.out.println(g.min());
        g.push(2);
        System.out.println(g.min());
        g.push(3);
        System.out.println(g.min());

        g.pop();
        System.out.println(g.min());
        g.pop();
        System.out.println(g.min());
        g.pop();
        System.out.println(g.min());

        g.push(0);
        g.min();
    }
}
