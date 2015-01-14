/**
 * Created by jutinko on 05/01/15.
 * Swap the number that satisfy swap to the beginning of the array,
 * and the numbers that do not satisfy to the end
 */
public class SwapArray {

    public static boolean swap(int a) {
        return(a % 2 == 0);
    }

    public static void partition(int A[]) {
        int begin = 0;
        int end = A.length-1;

        while(begin < end) {
            while(begin < end && swap(A[begin])) {
                ++begin;
            }

            while(begin < end && !swap(A[end])) {
                --end;
            }

            if(begin >= end) {
                break;
            }

            System.out.println("Should not comeo hre begin: " + begin + " end: " + end);
            int temp = A[begin];
            A[begin] = A[end];
            A[end] = temp;
        }
    }
    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 5, 6};
        partition(A);
        for(int n : A) {
            System.out.println(n);
        }

        int B[] = {1, 3, 5, 7};
        partition(B);
        for(int n : B) {
            System.out.println(n);
        }
    }
}
