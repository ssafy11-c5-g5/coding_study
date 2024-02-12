import java.util.Arrays;
import java.util.Scanner;

class SWEA_1860_진기의최고급붕어빵 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];

            int breadCount = 0;
            boolean sucess = true;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            int cnt = 0;
            for (int i = 1; i <= arr[arr.length - 1]; i++) {
                if (i % m == 0) {
                    breadCount += k;
                }

                if (arr[cnt] > i) {
                    continue;
                }

                if (breadCount == 0) {
                    sucess = false;
                    break;
                }

                breadCount -= 1;
                cnt++;
            }

            if (arr[0] == 0) {
                System.out.println("#" + test_case + " Impossible");
            } else if (sucess) {
                System.out.println("#" + test_case + " Possible");
            } else {
                System.out.println("#" + test_case + " Impossible");
            }

        }
    }
}