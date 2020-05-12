import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        long result = repeatedString("aba", 10);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        if (!s.contains("a")) return 0;

        long countOfAInS = countA(s);

        if (countA(s) == s.length()) {
            return n;
        }

        if (n % s.length() == 0) {
            return countOfAInS * (n / s.length());
        } else {
            long rem = n % s.length();
            long rep = n / s.length();
            String substr = s.substring(0, (int) rem);
            long countOfAInSubstr = countA(substr);

            return countOfAInS * rep + countOfAInSubstr;
        }
    }

    static long countA(String s) {
        return s.length() - s.replace("a", "").length();
    }
}
