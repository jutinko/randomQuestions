import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jutinko on 17/01/15.
 * Returns the set of all subsets of a set.
 */
public class SuperSet {
    public static List<List<Integer>> superSet(Deque<Integer> set) {
        if(set.size() == 0) {
            List<List<Integer>> result = new LinkedList<List<Integer>>();
            result.add(new LinkedList<Integer>());
            return result;
        }
        int head = set.pollFirst();
        List<List<Integer>> result = superSet(set);
        List<Integer> newL;
        List<List<Integer>> newLs = new LinkedList<List<Integer>>();
        for(List l : result) {
            newL = new LinkedList<Integer>();
            newL.addAll(l);
            newL.add(head);
            newLs.add(newL);
        }
        result.addAll(newLs);
        return result;
    }

    public static void main(String[] args) {
        Deque<Integer> set = new LinkedList<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        List<List<Integer>> test = superSet(set);
        for(List<Integer> l : test) {
            for(int i : l) {
                System.out.print(i+", ");
            }
            System.out.println();
        }
    }
}
