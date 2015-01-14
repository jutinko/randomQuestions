import java.util.HashMap;
import java.util.Map;

/**
 * Created by jutinko on 12/01/15.
 * The question was, given an array of integers, duplicates are defined if
 * there are two elements from the array, that are at most k positions apart,
 * and their difference at most d. Write a method that will return true if and
 * only if there is at least one pair of such elements
 */

public class PalantirInterview1 {
    /** This is the solution proposed by Felix, using buckets to store the seen elems,
     *  and using the nearby buckets to check if there is a duplicate
     */
    public static boolean findDuplicate(int A[], int k, int d) {
        Map<Integer, Integer> buckets = new HashMap<Integer, Integer>();

        int curr;
        int leftNeighbour;
        int rightNeighbour;
        for(int i = 0; i < A.length; ++i) {
            curr = A[i];
            int bucketIndex = getBucketIndex(curr, d);
            if(buckets.containsKey(bucketIndex)) {
                return true;
            } else {
                leftNeighbour = bucketIndex-1;
                rightNeighbour = bucketIndex+1;
                int neighbour;
                if(buckets.containsKey(leftNeighbour)) {
                    neighbour = buckets.get(leftNeighbour);
                    if(curr - neighbour <= d) {
                        return true;
                    }
                }
                if(buckets.containsKey(rightNeighbour)) {
                    neighbour = buckets.get(rightNeighbour);
                    if(neighbour - curr <= d) {
                        return true;
                    }
                }
            }
            buckets.put(bucketIndex, curr);
            if(i >= k) {
                buckets.remove(getBucketIndex(A[i-k], d));
            }
        }
        return false;
    }

    private static int getBucketIndex(int n, int d) {
        return n/(d+1);
    }

    public static void main(String[] args) {
        int A[] = {2, 6, -2, 3};
        System.out.println(findDuplicate(A, 3, 2));
    }
}
