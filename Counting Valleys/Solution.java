import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int seaLevel = 0;
        int prevSeaLevel;
        int countOfValleys = 0;

        for (int i = 0; i < n; i++) {
            prevSeaLevel = seaLevel;
            seaLevel = s.charAt(i) == 'U' ? ++seaLevel : --seaLevel;

            if (seaLevel == 0 && prevSeaLevel < 1) {
                countOfValleys += 1;
            }
        }

        return countOfValleys;
    }
}
