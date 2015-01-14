/**
 * Created by Juto Yu on 29/12/14.
 */
public class DuplicatedNumber {
    public static int getDuplicate(int A[]) {
        int n = A.length;
        int supposedSum = (n-2)*(n-1)/2;
        int actualSum = 0;
        for(int i : A) {
            actualSum += i;
        }
        return actualSum-supposedSum;
    }

    public static void main(String args[]) {
        int A[] = {0, 1, 2, 2, 3, 4};
        System.out.println(getDuplicate(A));
    }
}
