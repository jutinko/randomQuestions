/**
 * Created by jutinko on 15/01/15.
 */
public class Fib {
    public static long fib(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            long prev = 0;
            long curr = 1;
            long result = 0;
            for(int i = 2; i <= n; ++i) {
                result = curr+prev;
                prev = curr;
                curr = result;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(100));
    }
}
