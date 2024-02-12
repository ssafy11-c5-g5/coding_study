import java.util.Scanner;
import java.io.FileInputStream;
import java.util.stream.Stream;

class SWE_2805_농작물수확 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            arr[i] = Stream.of(s.split("")).mapToInt(Integer::parseInt).toArray();
        }

        int k = n / 2;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = k; j < n - k; j++) {
                sum += arr[i][j];
            }
            if (i < n / 2) {
                k--;
            } else if (i >= n / 2) {
                k++;
            }
        }

        System.out.println(sum);

    }
}