/**
 * Created by jutinko on 29/12/14.
 */
public class MyStack {
    class Node {
        Object data;
        Node next;
        Node(Object o) {
            this.data = o;
        }
    }

    Node top;

    public void initStack(Object o) {
        this.top = new Node(o);
    }

    Object pop() {
        if(top != null) {
            Node result = top;
            top = top.next;
            return result;
        }
        return null;
    }

    void push(Object o) {
        Node newNode = new Node(o);
        newNode.next = top;
        this.top = newNode;
    }

    public static void main(String args[]) {
        MyStack myMyStack = new MyStack();
        myMyStack.initStack(2);
        System.out.println(myMyStack.top);
    }
}
