import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16435_스네이크버드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {       // 정렬을 통해 작은 과일을 먹기 시작
            if (arr[i] <= l) {
                l++;                        // 먹을 수 있다면 길이 증가
            } else {
                break;
            }
        }

        System.out.println(l);
    }
}
