import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        List<Character> chars = s.chars().mapToObj(e -> (char) e).collect(Collectors.toList());

        Map<Character, Long> groupedChars = chars.stream().collect(groupingBy(Function.identity(), counting()));

        Long min = Collections.min(groupedChars.values());
        Long max = Collections.max(groupedChars.values());

        long countMin = groupedChars.values().stream().filter(val -> val.equals(min)).count();
        long countMax = groupedChars.values().stream().filter(val -> val.equals(max)).count();

        // FIXME
        if (countMax == groupedChars.size() || countMin == groupedChars.size()) {
            return "YES";
        } else if (countMax == groupedChars.size()-1 || countMin == groupedChars.size()-1) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = scanner.nextLine();

        String result = isValid("aaaabbcc");
        System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
