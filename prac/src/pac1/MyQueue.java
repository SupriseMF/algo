package pac1;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();

    }

    public void push(int x) {
        inStack.push(x);

    }

    /**
     * 只有当out为空时，才从in中取数
     * @return
     */
    public int pop() {
        if (outStack.isEmpty()) {
            fillOutStack();
        }
        return outStack.pop();

    }

    public int peek() {
        if (outStack.isEmpty()) {
            fillOutStack();
        }
        return outStack.peek();
    }

    /**
     * in和out组成一个queue
     * @return
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void fillOutStack() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(3);
        queue.push(9);
        queue.push(1);

        System.out.println(queue.pop());
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }


}
