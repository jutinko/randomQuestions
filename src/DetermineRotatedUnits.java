/**
 * Created by jutinko on 07/01/15.
 * The ascending array was shifted by unknown units to the right,
 * this algorithm tries to get this unit k in log time
 */

public class DetermineRotatedUnits {
    public static int getK(int A[]) {
        if(A.length == 0)
            return 0;
        int bigger = A[0];
        int begin = 0;
        int end = A.length-1;
        return getKHelper(A, bigger, begin, end);
    }

    private static int getKHelper(int A[], int bigger, int begin, int end) {
        // Base case
        if(begin > end) {
            return begin;
        }
        int middle = (begin+end)/2;
        int side = getSide(bigger, middle, A);
        if(side == 0) {
            return middle;
        } else if(side == -1) {
            return getKHelper(A, bigger, begin, middle);
        } else {
            return getKHelper(A, bigger, middle+1, end);
        }
    }

    public static int getSide(int bigger, int index, int A[]) {
        if(index == 0)
            return 0;
        if(A[index] < bigger) {
            if(A[index-1] > A[index]) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return 1;
        }

    }

    public static void main(String[] args) {
        int A[] = {2};
        System.out.println(getK(A));
    }
}
