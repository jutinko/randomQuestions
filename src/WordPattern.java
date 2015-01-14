import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jutinko on 30/12/14.
 */
public class WordPattern {

    static int wordpattern(String pattern, String input) {
        Map<Character, String> myMap = new HashMap<Character, String>();
        // To check if the pattern already in the map
        Map<String, Character> myRevMap = new HashMap<String, Character>();
        return wordpatternHelp(pattern, input, myMap, myRevMap);
    }

    static int wordpatternHelp(String pattern, String input, Map<Character, String> table,
                               Map<String, Character> revMap) {
        // Base case
        if(pattern.length() == 0) {
            return 1;
        }

        char patternChar = pattern.charAt(0);
        if(table.containsKey(patternChar)) {
            String takeOff = table.get(patternChar);
            if(takeOff.length() > input.length()) {
                return 0;
            }
            if(input.substring(0, takeOff.length()).equals(takeOff)) {
                return wordpatternHelp(pattern.substring(1, pattern.length()),
                        input.substring(takeOff.length(), input.length()), table, revMap);
            } else {
                return 0;
            }
        }

        int patternLength = 1;
        String patternString;
        while(patternLength <= input.length()) {
            patternString = input.substring(0, patternLength);
            if(revMap.containsKey(patternString)) {
                patternLength += 1;
                continue;
            }
            table.put(patternChar, patternString);
            revMap.put(patternString, patternChar);
            if(wordpatternHelp(pattern.substring(1, pattern.length()),
                    input.substring(patternLength, input.length()),
                    table, revMap) != 1) {
                patternLength += 1;
                table.remove(patternChar);
                revMap.remove(patternString);
            } else {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(wordpattern("aa", "rrRR"));
    }
}
