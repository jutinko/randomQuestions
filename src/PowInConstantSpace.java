/**
 * Created by jutinko on 14/01/15.
 */
public class PowInConstantSpace {
    public static long pow(int n, long e) {
        return powHelper(n, e, 1);
    }

    public static long powHelper(long n, long e, long acc) {
        if(e == 0) {
            return acc;
        } else {
            if(e%2 == 1) {
                return powHelper(n*n, e/2, acc);
            } else {
                return powHelper(n*n, e/2, acc);
            }
        }
    }

    public static int tailRecurseTest(long n, int acc) {
        if(n == 0) {
            return acc;
        } else {
            return tailRecurseTest(n-1, acc);
        }
    }

    public static void main(String[] args) {
//        System.out.println(pow(2, 100000000000L));
        tailRecurseTest(100000L, 1);
    }
}
