import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by jutinko on 02/01/15.
 */
public class P4dot2 {
    public static boolean hasRoute(MyNode x, MyNode y) {
        Set<MyNode> seen = new HashSet<MyNode>();

        // Depth first search, from x to y
        Queue<MyNode> nodeQueue = new LinkedList<MyNode>();
        for(MyNode n : x.getNeighbours()) {
            nodeQueue.add(n);
        }

        MyNode neighbour;
        while(!nodeQueue.isEmpty()) {
            neighbour = nodeQueue.poll();
            if(!seen.contains(neighbour)) {
                if(neighbour != y) {
                    for(MyNode nn : neighbour.getNeighbours()) {
                        nodeQueue.add(nn);
                    }
                    seen.add(neighbour);
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        MyNode x = new MyNode(4);
        MyNode z = new MyNode(5);
        MyNode y = new MyNode(5);
        x.addToNeighbour(z);
        z.addToNeighbour(x);
        z.addToNeighbour(y);
        System.out.println(hasRoute(x, y));
    }
}
