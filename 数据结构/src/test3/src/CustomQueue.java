import java.util.Stack;

public class CustomQueue {

    private Stack<Object> stack1;
    private Stack<Object> stack2;

    public CustomQueue() {
        stack1 = new Stack<Object>();
        stack2 = new Stack<Object>();
    }

    public void enqueue(Object data) {
        stack1.push(data);
    }

    public Object dequeue() {
        while (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.peek());
            }
        }
        Object value = stack2.peek();
        stack2.pop();

        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }

        return value;
    }

    public boolean empty() {
        return stack1.empty();
    }
}
