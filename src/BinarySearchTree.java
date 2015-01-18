/**
 * Created by jutinko on 12/01/15.
 */
public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int n) {
            this.data = n;
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    Node head;

    public BinarySearchTree(int n) {
        head = new Node(n);
    }

    public static BinarySearchTree treeFromArray(int A[]) {
        if(A.length > 0) {
            BinarySearchTree head = new BinarySearchTree(A[0]);
            for(int i = 1; i < A.length; ++i) {
                addNodeIter(A[i], head.getHead());
            }
            return head;
        } else {
            return null;
        }
    }

    // addNode recursively
    private static Node addNode(int n, Node root) {
        if(root == null) {
            return new Node(n);
        }
        if(root.getData() == n) {
            return root;
        }
        if(root.getData() > n) {
            root.setLeft(addNode(n, root.getLeft()));
        } else {
            root.setRight(addNode(n, root.getRight()));
        }
        return root;
    }

    // addNode iteratively, root cannot be null
    private static void addNodeIter(int n, Node root) {
        Node curr = root;
        Node parent = root;
        int currData;
        while(curr != null) {
            parent = curr;
            currData = curr.getData();
            if(currData == n) {
                return;
            } else if(currData > n) {
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
        }
        Node newNode = new Node(n);
        if(parent.getData() > n) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
    }

    public boolean findWithinRange(int n) {
        return findWithinRangeHelper(n, this.getHead());
    }

    private static boolean findWithinRangeHelper(int n, Node node) {
        if(node == null) {
            return false;
        } else {
            if(node.getData() <= n+5 && node.getData() >= n-5) {
                return true;
            } else if(node.getData() < n-5) {
                return findWithinRangeHelper(n, node.getRight());
            } else {
                return findWithinRangeHelper(n, node.getLeft());
            }
        }
    }

    public Node getHead() {
        return head;
    }

    public static void main(String[] args) {
        int A[] = {5, 8, 3, 1, 6, 4, 7};
        BinarySearchTree t = treeFromArray(A);
        System.out.println(t.findWithinRange(14));
    }
}
