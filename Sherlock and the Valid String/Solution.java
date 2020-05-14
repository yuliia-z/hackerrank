import java.io.*;
import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Solution {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    // Complete the isValid function below.
    static String isValid(String s) {
        if (s.length() == 1) return "YES";

        Map<Character, Long> groupedChars = s.chars()
                .mapToObj(e -> (char) e)
                .collect(groupingBy(Function.identity(), counting()));

        Long min = Collections.min(groupedChars.values());
        Long max = Collections.max(groupedChars.values());

        long countMin = groupedChars.values().stream().filter(val -> val.equals(min)).count();
        long countMax = groupedChars.values().stream().filter(val -> val.equals(max)).count();

        if (countMax == groupedChars.size() || countMin == groupedChars.size()) {
            return "YES";
        } else if (countMax == groupedChars.size() - 1) {
            return min == 1 || max - min == 1 ? "YES" : "NO";
        } else if (countMin == groupedChars.size() - 1) {
            return max - min == 1 ? "YES" : "NO";
        } else {
            return "NO";
        }
    }
}
