import java.util.*;

/**
 * Created by jutinko on 07/01/15.
 * Recursive, iterative deep copy's implementation on a toy example
 */
public class DeepCopy {

    private List<DeepCopy> nodes = new LinkedList<DeepCopy>();

    public static DeepCopy copy(DeepCopy from) {
        if(from == null) {
            return null;
        }
        Map<DeepCopy, DeepCopy> table = new HashMap<DeepCopy, DeepCopy>();
        return copyHelperIter(from, table);
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

    private static DeepCopy copyHelperIter(DeepCopy from, Map<DeepCopy, DeepCopy> table) {
        DeepCopy result = new DeepCopy();
        table.put(from, result);
        Deque<DeepCopy> myQ = new LinkedList<DeepCopy>();
        myQ.add(from);
        DeepCopy curr, copy;
        while(!myQ.isEmpty()) {
            curr = myQ.pollFirst();
            copy = table.get(curr);
            DeepCopy child;
            for(DeepCopy n : curr.getNodes()) {
                if(!table.containsKey(n)) {
                    child = new DeepCopy();
                    table.put(n, child);
                    myQ.add(n);
                } else {
                    child = table.get(n);
                }
                copy.addNode(child);
            }
        }
        return result;
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

        copy(a);
    }
}