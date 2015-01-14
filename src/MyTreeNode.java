/**
 * Created by jutinko on 02/01/15.
 */
public class MyTreeNode {
    MyTreeNode left;
    MyTreeNode right;
    int data;

    public MyTreeNode(int data) {
        this.data = data;
    }

    public void setRight(MyTreeNode right) {
        this.right = right;
    }

    public void setLeft(MyTreeNode left) {
        this.left = left;
    }

    public MyTreeNode getLeft() {
        return left;
    }

    public MyTreeNode getRight() {
        return right;
    }
}
