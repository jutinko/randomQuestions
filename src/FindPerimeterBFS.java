import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jutinko on 16/01/15.
 * Given a matrix of 1's and 0's, return the perimeter of the outermost connected
 * area with 1's.
 */
public class FindPerimeterBFS {
    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof Node)) {
                return false;
            } else {
                Node other = (Node) o;
                return ((other.getX() == this.getX() && other.getY() == this.getY()));
            }
        }
    }

    public static int getPerimeter(int A[][]) {
        Node firstNode = getFirst(A);
        if(firstNode != null) {
            boolean seen[][] = new boolean[A.length][A[0].length];
            Deque<Node> myQ = new LinkedList<Node>();
            myQ.add(firstNode);
            Node curr;
            int newX, newY;
            while(!myQ.isEmpty()) {
                curr = myQ.pollFirst();
                System.out.println(curr.getX() + " and " + curr.getY());
                if(!seen[curr.getX()][curr.getY()]) {
                    seen[curr.getX()][curr.getY()] = true;
                    if(curr.getX()-1 >= 0) {
                        newX = curr.getX()-1;
                        newY = curr.getY();
                        checkAndMark(A, myQ, newX, newY);
                    }
                    if(curr.getX()+1 < A.length) {
                        newX = curr.getX()+1;
                        newY = curr.getY();
                        checkAndMark(A, myQ, newX, newY);
                    }
                    if(curr.getY()-1 >= 0) {
                        newX = curr.getX();
                        newY = curr.getY()-1;
                        checkAndMark(A, myQ, newX, newY);
                    }
                    if(curr.getY()+1 < A[0].length) {
                        newX = curr.getX();
                        newY = curr.getY()+1;
                        checkAndMark(A, myQ, newX, newY);
                    }
                }
            }
            int result = 0;
            for(int i = 0; i < seen.length; ++i) {
                for(int j = 0; j < seen[0].length; ++j) {
                    if(seen[i][j]) {
                        result += getNumberNeighbours(seen, i, j);
                    }
                }
            }
            return result;
        } else {
            return 0;
        }
    }

    private static int getNumberNeighbours(boolean seen[][], int x, int y) {
        int result = 4;
        if(x-1 >= 0) {
            if(seen[x-1][y]) {
                --result;
            }
        }
        if(x+1 < seen.length) {
            if(seen[x+1][y]) {
                --result;
            }
        }
        if(y-1 >= 0) {
            if(seen[x][y-1]) {
                --result;
            }
        }
        if(y+1 < seen[0].length) {
            if(seen[x][y+1]) {
                --result;
            }
        }
        return result;
    }

    private static void checkAndMark(int A[][], Deque<Node> myQ, int newX, int newY) {
        if(A[newX][newY] == 1) {
            myQ.add(new Node(newX, newY));
        }
    }

    private static Node getFirst(int A[][]) {
        for(int i = 0; i < A.length; ++i) {
            for(int j = 0; j < A[0].length; ++j) {
                if(A[i][j] == 1) {
                    return new Node(i, j);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int A[][] = {
                {0, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 0, 0}};
        System.out.println(getPerimeter(A));
    }
}
