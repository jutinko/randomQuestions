import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jutinko on 14/01/15.
 */

public class MergeSort {

    // Sorts the array from from to to inclusively
    public static void mergeSort(int A[], int from, int to) {
        if(from < to) {
            int middle = (from+to)/2;
            mergeSort(A, from, middle);
            mergeSort(A, middle+1, to);
            merge(A, from, middle, to);
        }
    }

    private static void merge(int[] A, int from, int middle, int to) {
        Deque<Integer> first = new LinkedList<Integer>();
        Deque<Integer> second = new LinkedList<Integer>();

        for(int i = from; i <= middle; ++i) {
            first.add(A[i]);
        }
        for(int i = middle+1; i <= to; ++i) {
            second.add(A[i]);
        }

        int position = from;
        while(!first.isEmpty() && !second.isEmpty()) {
            if(first.getFirst() < second.getFirst()) {
                A[position] = first.pollFirst();
            } else {
                A[position] = second.pollFirst();
            }
            ++position;
        }

        while(!first.isEmpty()) {
            A[position] = first.pollFirst();
            ++position;
        }

        while(!second.isEmpty()) {
            A[position] = second.pollFirst();
            ++position;
        }
    }

    public static void main(String[] args) {
        int A[] = {2, 3, 1, 6, 8, 9, 0, 5, 3};
        mergeSort(A, 0, A.length-1);
        System.out.println("Sorted: ");
        for(int i : A) {
            System.out.print(i + " ");
        }
    }
}
