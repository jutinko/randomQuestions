import java.util.Stack;

/**
 * Created by jutinko on 30/12/14.
 * From CrackCode p52, 3.5
 */
public class MyQueue {
    Stack<Object> forPush = new Stack<Object>();
    Stack<Object> forPop = new Stack<Object>();

    public void push(Object o) {
        forPush.push(o);
    }

    public Object pop() {
        if(!forPop.isEmpty()) {
            return forPop.pop();
        }
        while(!forPush.isEmpty()) {
            forPop.push(forPush.pop());
        }
        return forPop.pop();
    }

    public static void main(String[] args) {
        MyQueue myMyQueue = new MyQueue();
        myMyQueue.push(2);
        myMyQueue.push(2);
        myMyQueue.push(2);
        myMyQueue.push(2);
        System.out.println(myMyQueue.pop());
        System.out.println(myMyQueue.pop());
        System.out.println(myMyQueue.pop());
        System.out.println(myMyQueue.pop());
        System.out.println(myMyQueue.pop());
    }
}
