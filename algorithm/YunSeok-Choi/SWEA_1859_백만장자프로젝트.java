import java.util.Scanner;

public class Million {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cnt = 0;
        Long sum = 0L;
        Long max = 0L;
        Long benefit = 0L;
        Long[] arr = new Long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        max = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                benefit += (max * cnt) - sum;

                max = arr[i];
                cnt = 0;
                sum = 0L;
            } else if (i == 0) {
                sum += arr[i];
                cnt++;

                benefit += (max * cnt) - sum;
            } else {
                sum += arr[i];
                cnt++;
            }
        }

        System.out.println(benefit);

    }

}