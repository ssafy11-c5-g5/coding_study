import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_9229_한빈이의SportMart {

    static int max;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] nm = br.readLine().split(" ");

            int n = Integer.parseInt(nm[0]);
            m = Integer.parseInt(nm[1]);
            max = -1;

            int[] arr = new int[n];
            int[] sel = new int[2];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            recursive(0, arr, sel, 0);

            System.out.println("#" + test_case + " " + max);

        }

    }

    private static void recursive(int idx, int[] arr, int[] sel, int v) {

        if (sel.length == idx) {
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                sum += sel[i];
            }
            if (sum <= m) {
                max = Math.max(sum, max);
            }
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if ((v & 1 << i) == 0) {
                sel[idx] = arr[i];
                recursive(idx + 1, arr, sel, v | 1 << i);
            }
        }

    }
}
