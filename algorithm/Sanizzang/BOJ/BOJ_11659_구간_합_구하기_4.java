import java.util.Scanner;

public class BOJ_11659_구간_합_구하기_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] sumArr = new int[N + 1];

        sumArr[1] = sc.nextInt();

        for(int i = 2;i <= N;i++) {
            sumArr[i] = sumArr[i - 1] + sc.nextInt();
        }

        for(int i = 0;i < M;i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            System.out.println(sumArr[num2] - sumArr[num1 - 1]);
        }

    }
}