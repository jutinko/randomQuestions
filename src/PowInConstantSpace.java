/**
 * Created by jutinko on 14/01/15.
 */
public class PowInConstantSpace {
    public static int pow(int n, int e) {
        return powHelper(n, e, 1);
    }

    public static int powHelper(int n, int e, int acc) {
        if(e == 0) {
            return acc;
        } else {
            if(e%2 == 1) {
                return powHelper(n*n, e/2, n*acc);
            } else {
                return powHelper(n*n, e/2, acc);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 11));
    }
}
