import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by jutinko on 03/01/15.
 */
public class AnagramComparator implements Comparator<String> {

    public String sortChars(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    @Override
    public int compare(String s1, String s2) {
        return sortChars(s1).compareTo(sortChars(s2));
    }

    public static void main(String[] args) {
        String A[] = {"Hey", "eyH", "nihao", "yHe", "haoni", "inhao"};
        Arrays.sort(A, new AnagramComparator());
        for(String s : A) {
            System.out.println(s);
        }
    }
}
