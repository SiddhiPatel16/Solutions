import java.util.Stack;

class MyQueue {
    Stack<Integer> main;
    Stack<Integer> temp;

    public MyQueue() {
        main = new Stack<Integer>();
        temp = new Stack<Integer>();
    }
    
    public void push(int x) {
        while(!main.isEmpty()){
            temp.push(main.pop());
        }

        main.push(x);

        while(!temp.isEmpty()){
            main.push(temp.pop());
        }
    }
    
    public int pop() {
        return main.pop();
    }
    
    public int peek() {
        return main.peek();
    }
    
    public boolean empty() {
        return main.isEmpty();
    }
}