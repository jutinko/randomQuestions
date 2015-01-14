/**
 * Created by jutinko on 04/01/15.
 */
public class PrintNumberToDigit {
    public static void print1ToMaxNDigits(int n) {
        char number[] = new char[n];
        for (int i = 0; i < n; ++i) {
            number[i] = '0';
        }

        while (!incrementNumber(number, n)) {
            printNumber(number, n);
        }

    }

    private static boolean incrementNumber(char[] number, int n) {
        boolean overFlow = false;
        number[n - 1] += 1;
        for (int i = n - 1; i >= 0; --i) {
            if (i == 0 && number[i] - '0' == 10) {
                overFlow = true;
            } else if (number[i] - '0' == 10) {
                number[i] = '0';
                // We know that i must be greater than 0
                number[i-1] += 1;
            } else {
                break;
            }
        }
        return overFlow;
    }

    private static void printNumber(char[] number, int n) {
        String result = "";
        boolean start = false;
        for(int i = 0; i < n; ++i) {
            if(number[i] == '0' && !start) {
                continue;
            } else {
                start = true;
                result += number[i];
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        char test[] = {'0', '0', '1', '0'};
        printNumber(test, 4);
        print1ToMaxNDigits(6);
    }
}
