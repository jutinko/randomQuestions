/**
 * Created by jutinko on 09/01/15.
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindCycle {

    private static void getCycleHelper(int numbers[]) {
        Map<Integer, Set<Integer>> numberPositionMap = new HashMap<Integer, Set<Integer>>();
        for(int i = 0; i < numbers.length; ++i) {
            int curr = numbers[i];
            Set<Integer> positions;
            if(numberPositionMap.containsKey(curr)) {
                positions = numberPositionMap.get(curr);
            } else {
                positions = new HashSet<Integer>();
                numberPositionMap.put(curr, positions);
            }
            positions.add(i);
            if(positions.size() > 1) {
                for(Integer pos : positions) {
                    if(pos != i) {
                        if(checkCycleFromIndex(numbers, i, pos)) {
                            System.out.println("There is cycle from: " + pos + " to: " + i);
                        }
                    }
                }
            }
        }

    }

    private static boolean checkCycleFromIndex(int numbers[], int i, Integer pos) {
        if(i+i-pos > numbers.length) {
            return false;
        }
        // We are sure that pos is less than i
        for(int j = 0; j < i-pos; ++j) {
            if(numbers[i+j] != numbers[pos+j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int A[] = {6, 3 ,2 ,6, 3 ,3, 6, 3, 2, 6, 3, 3, 6, 3, 3};
        getCycleHelper(A);
    }
}
