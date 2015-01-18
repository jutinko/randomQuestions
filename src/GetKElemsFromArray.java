import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by jutinko on 15/01/15.
 * This method gets k random elements from an array in k time
 */
public class GetKElemsFromArray {
    public static List<Integer> getKElems(int A[], int k) {
        Random random = new Random();
        List<Integer> result = new LinkedList<Integer>();
        int size = A.length;
        for(int i = 0; i < k; ++i) {
            int curr = random.nextInt(size);
            int currInt = A[curr];
            A[curr] = A[size-1];
            A[size-1] = currInt;
            result.add(currInt);
            --size;
        }
        return result;
    }

    public static void main(String[] args) {
        int A[] = {2, 3, 1, 0, 9, 7, 5, 6};
        List<Integer> l = getKElems(A, 3);
        for(int i : l) {
            System.out.println(i);
        }
    }
}
