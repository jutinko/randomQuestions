import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jutinko on 02/01/15.
 * In this problem we assume that the tree does not have any cycles
 */
public class P4dot4 {
    public static List<List<MyTreeNode>> depthList(MyTreeNode t) {
        List<List<MyTreeNode>> result = new LinkedList<List<MyTreeNode>>();
        List<MyTreeNode> list = new LinkedList<MyTreeNode>();
        list.add(t);
        result.add(list);
        Stack<MyTreeNode> stack = new Stack<MyTreeNode>();
        stack.push(t);

        while (!list.isEmpty()) {
            list = new LinkedList<MyTreeNode>();
            MyTreeNode n;
            while (!stack.isEmpty()) {
                n = stack.pop();
                if (n.getLeft() != null) {
                    list.add(n.getLeft());
                }
                if (n.getRight() != null) {
                    list.add(n.getRight());
                }
            }
            stack.addAll(list);
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        MyTreeNode n1 = new MyTreeNode(1);
        MyTreeNode n2 = new MyTreeNode(2);
        MyTreeNode n3 = new MyTreeNode(3);
        MyTreeNode n4 = new MyTreeNode(4);
        MyTreeNode n5 = new MyTreeNode(5);
        MyTreeNode n6 = new MyTreeNode(6);
        MyTreeNode n7 = new MyTreeNode(7);
        n4.setLeft(n2);
        n4.setRight(n6);
        n2.setLeft(n1);
        n2.setRight(n3);
        n6.setLeft(n5);
        n6.setRight(n7);

        int count = 0;

        for (List<MyTreeNode> l : depthList(n4)) {
            System.out.println("Layer: " + count);
            for (MyTreeNode n : l) {
                System.out.println(n.data);
            }
            ++count;
        }
    }
}
