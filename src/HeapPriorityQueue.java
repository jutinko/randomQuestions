/**
 * Created by jutinko on 14/01/15.
 * Min-heap using arrays
 */
public class HeapPriorityQueue {
    private final int PQ_SIZE = 100;
    private int size = 0;
    private final int[] queue = new int[PQ_SIZE];

    public HeapPriorityQueue(int A[]) {
        for(int i = 0; i < A.length; ++i) {
            insert(A[i]);
        }
    }

    public void insert(int n) {
        if(size == PQ_SIZE) {
            System.out.println("The queue is full!");
        } else {
            ++size;
            // The array starts at index 0
            queue[size-1] = n;
            bubbleUp(size-1);
        }
    }

    private void bubbleUp(int i) {
        if(i == 0) {
            return;
        } else {
            int parent = i/2;
            if(queue[parent] > queue[i]) {
                int temp = queue[i];
                queue[i] = queue[parent];
                queue[parent] = temp;
                bubbleUp(parent);
            }
        }
    }

    // Before pop, please check if the size is greater than 0
    public int pop() {
        int result = queue[0];
        queue[0] = queue[size-1];
        --size;
        bubbleDown(0);
        return result;
    }

    private void bubbleDown(int i) {
        int lChild = 2*i;
        int minElem = i;
        for(int j = 0; j < 2; ++j) {
            if(lChild+j < size) {
                if(queue[i] > queue[lChild+j]) {
                    minElem = lChild+j;
                }
            }
        }

        if(minElem != i) {
            int temp = queue[i];
            queue[i] = queue[minElem];
            queue[minElem] = temp;
            bubbleDown(minElem);
        }

    }

    public static void main(String[] args) {
        int A[] = {2, 4, 8, 1, -5, 7, 7};
        HeapPriorityQueue myQ = new HeapPriorityQueue(A);
        while(true) {
            System.out.println(myQ.pop());
        }
    }
}
