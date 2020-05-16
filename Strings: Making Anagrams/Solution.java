import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram("cde", "abc");

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int [] letters = new int[26];
        a.chars().forEach( c -> letters[c-'a']++);
        b.chars().forEach( c -> letters[c-'a']--);
        return IntStream.of(letters).map(Math::abs).sum();
    }
}
