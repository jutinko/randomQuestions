import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jutinko on 15/01/15.
 */
public class SumToX {

    public static void solution(String line) {
        String[] parsed = line.split("[,;]");
        int numbers[] = new int[parsed.length-1];

        // The last number is the sum we want, so we don't add it
        // into the set
        for(int i = 0; i < parsed.length-1; ++i) {
            numbers[i] = Integer.valueOf(parsed[i]);
        }
        int sum = Integer.valueOf(parsed[parsed.length-1]);
        solutionHelper(numbers, sum);
    }

    private static void solutionHelper(int A[], int sum) {
        Set<Integer> mySet = new HashSet<Integer>();
        for(int a : A) {
            mySet.add(a);
        }

        boolean hasAny = false;
        for(int i = 0; i < A.length; ++i) {
            int curr = A[i];
            if(mySet.contains(sum-curr)) {
                if(i != A.length-1 && hasAny) {
                    System.out.print(";");
                }
                hasAny = true;
                System.out.print(curr + "," + (sum-curr));
                mySet.remove(curr);
                mySet.remove(sum-curr);
            }
        }
        if(!hasAny) {
            System.out.println("NULL");
        } else {
            System.out.println();
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null && !s.equals("")) {
            solution(s);
        }
    }
}
