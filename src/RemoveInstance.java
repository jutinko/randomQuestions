/**
 * Created by jutinko on 05/01/15.
 * Given an array and a value, remove all the instances of the value
 * in the array in place and return the new array length
 */
public class RemoveInstance {
    public static int remove(int A[], int n) {
        int begin = 0;
        int end = A.length-1;
        while(begin < end) {
            while(begin < end && A[begin] != n) {
                ++begin;
            }
            while(begin < end && A[end] == n) {
                --end;
            }

            if(begin >= end) {
                return end;
            }

            int temp = A[begin];
            A[begin] = A[end];
            A[end] = temp;
        }
        return end;
    }

    public static void main(String[] args) {
        int A[] = {2, 2, 2, 2, 5, 6};
        System.out.println(remove(A, 2));
        for(int n : A) {
            System.out.println("Number: " + n);
        }
    }
}
