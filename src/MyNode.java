import java.util.LinkedList;
import java.util.List;

/**
 * Created by jutinko on 02/01/15.
 */
public class MyNode {
    int data;

    List<MyNode> neighbours = new LinkedList<MyNode>();

    public MyNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void addToNeighbour(MyNode n) {
        this.neighbours.add(n);
    }

    public List<MyNode> getNeighbours() {
        return neighbours;
    }

}

