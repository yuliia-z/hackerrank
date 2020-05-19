import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxHourglassSum = -63; //min possible value = -9, min possible hourglass sum = -9*7

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr.length - 2; j++) {
                int topSum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                int midSum = arr[i + 1][j + 1];
                int bottomSum = arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                int sum = topSum + midSum + bottomSum;
                if (sum > maxHourglassSum) maxHourglassSum = sum;
            }
        }

        return maxHourglassSum;
    }
}
