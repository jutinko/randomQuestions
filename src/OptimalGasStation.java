import java.util.*;

/**
 * Created by jutinko on 16/01/15.
 */
public class OptimalGasStation {
    static class Node {
        int y;
        int x;
        Map<Node, Integer> seenBy = new HashMap<Node, Integer>();

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

    public static void findOptimalLocation(int A[][], List<Node> spaceShip) {
        Node seen[][] = new Node[A.length][A[0].length];
        Map<Node, Deque<Node>> myQs = new HashMap<Node, Deque<Node>>();
        Deque<Node> myQ;
        for(Node n : spaceShip) {
            myQ = new LinkedList<Node>();
            seen[n.getY()][n.getX()] = n;
            n.seenBy.put(n, 0);
            myQ.add(n);
            myQs.put(n, myQ);
        }

        int dist = 1;
        while(true) {
            Map<Node, Deque<Node>> newQs = new HashMap<Node, Deque<Node>>();
            for(Map.Entry<Node, Deque<Node>> e : myQs.entrySet()) {
                Deque<Node> newQ = new LinkedList<Node>();
                for(Node n : e.getValue()) {
                    if(processNeighboursAndCheckIfDone(A, seen, newQ, e.getKey(), n, dist, spaceShip.size())) {
                        return;
                    }
                }
                newQs.put(e.getKey(), newQ);
            }
            myQs = newQs;
            ++dist;
        }
    }

    private static boolean processNeighboursAndCheckIfDone(int A[][], Node seen[][], Deque<Node> newQ, Node root, Node n, int dist, int total) {
        int x = n.getX();
        int y = n.getY();
        int newX, newY;
        if(x-1 >= 0) {
            newX = x-1;
            if(A[y][newX] != -1) {
                if(seen[y][newX] == null) {
                    seen[y][newX] = new Node(y, newX);
                }
                if(!seen[y][newX].seenBy.containsKey(root)) {
                    newQ.add(seen[y][newX]);
                    seen[y][newX].seenBy.put(root, dist);
                    if(ifDone(seen[y][newX], total)) {
                        return true;
                    }
                }
            }
        }
        if(x+1 < seen[0].length) {
            newX = x+1;
            if(A[y][newX] != -1) {
                if(seen[y][newX] == null) {
                    seen[y][newX] = new Node(y, newX);
                }
                if(!seen[y][newX].seenBy.containsKey(root)) {
                    newQ.add(seen[y][newX]);
                    seen[y][newX].seenBy.put(root, dist);
                    if(ifDone(seen[y][newX], total)) {
                        return true;
                    }
                }
            }
        }
        if(y-1 >= 0) {
            newY = y-1;
            if(A[newY][x] != -1) {
                if(seen[newY][x] == null) {
                    seen[newY][x] = new Node(newY, x);
                }
                if(!seen[newY][x].seenBy.containsKey(root)) {
                    newQ.add(seen[newY][x]);
                    seen[newY][x].seenBy.put(root, dist);
                    if(ifDone(seen[newY][x], total)) {
                        return true;
                    }
                }
            }
        }
        if(y+1 < seen.length) {
            newY = y+1;
            if(A[newY][x] != -1) {
                if(seen[newY][x] == null) {
                    seen[newY][x] = new Node(newY, x);
                }
                if(!seen[newY][x].seenBy.containsKey(root)) {
                    newQ.add(seen[newY][x]);
                    seen[newY][x].seenBy.put(root, dist);
                    if(ifDone(seen[newY][x], total)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    private static boolean ifDone(Node node, int total) {
        if(node.seenBy.size() >= total) {
            int optimal = 0;
            for(Node n : node.seenBy.keySet()) {
                System.out.println(n.getX() + " " + n.getY());
            }
            for(Integer i : node.seenBy.values()) {
                optimal += i;
            }
            System.out.println("One of the best locations will be: "+node.getX()+", "+node.getY()+" with: "+
                    optimal);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int A[][] = {
                {0, -1, -1, 0},
                {0, 0, 0, 0},
                {0, 0, -1, -1},
                {0, 0, 0, -1}};
        List<Node> spaceShips = new LinkedList<Node>();
        spaceShips.add(new Node(1, 3));
        spaceShips.add(new Node(3, 0));
        spaceShips.add(new Node(0, 0));
        findOptimalLocation(A, spaceShips);
    }
}
