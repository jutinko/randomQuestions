import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by jutinko on 07/01/15.
 * Recursive deep copy implementation on a toy example
 */
public class DeepCopy {

    private List<DeepCopy> nodes = new LinkedList<DeepCopy>();

    public static DeepCopy copy(DeepCopy from) {
        if(from == null) {
            return null;
        }
        Map<DeepCopy, DeepCopy> table = new HashMap<DeepCopy, DeepCopy>();
        return copyHelper(from, table);
    }

    private static DeepCopy copyHelper(DeepCopy from, Map<DeepCopy, DeepCopy> table) {
        // Base case
        DeepCopy newNode;
        if (!table.containsKey(from)) {
            newNode = new DeepCopy();
            if (from.getNodes().isEmpty()) {
                table.put(from, newNode);
                return newNode;
            } else {
                table.put(from, newNode);

                for (DeepCopy n : from.getNodes()) {
                    newNode.addNode(copyHelper(n, table));
                }
                return newNode;
            }
        } else {
            return table.get(from);
        }
    }

    public List<DeepCopy> getNodes() {
        return nodes;
    }

    public void addNode(DeepCopy node) {
        this.nodes.add(node);
    }

    public static void main(String[] args) {
        DeepCopy a = new DeepCopy();
        DeepCopy b = new DeepCopy();
        DeepCopy c = new DeepCopy();
        DeepCopy d = new DeepCopy();

        a.addNode(b);
        b.addNode(a);
        b.addNode(c);
        b.addNode(d);
        c.addNode(b);
        c.addNode(d);
        d.addNode(c);
        d.addNode(b);

        copy(a);

    }
}
