import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class JO_1828_냉장고 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] temper = new int[n][2];
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            temper[i][0] = Integer.parseInt(str[0]);
            temper[i][1] = Integer.parseInt(str[1]);
        }

        Arrays.sort(temper, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(temper[i][0] + " " + temper[i][1]);
        }

        int max = temper[0][1];
        for (int i = 1; i < n; i++) {
            if (temper[i][0] > max) {
                max = temper[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
