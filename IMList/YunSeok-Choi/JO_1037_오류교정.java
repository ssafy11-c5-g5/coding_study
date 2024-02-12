import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO_1037_오류교정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int check = 0;
        int r = 0;

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int k = 0;
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                k += map[i][j];
            }
            if (k % 2 != 0) {
                check++;
                r = i;
            }
        }

        if (check > 1) {
            System.out.println("Corrupt");
            return;
        } else {
            check = 0;
            int c = 0;

            for (int i = 0; i < n; i++) {
                int k = 0;
                for (int j = 0; j < n; j++) {
                    k += map[j][i];
                }
                if (k % 2 != 0) {
                    check++;
                    c = i;
                }
            }
            if (check > 1) {
                System.out.println("Corrupt");
                return;
            } else if (check == 1) {
                System.out.printf("Change bit (%d,%d)", r + 1, c + 1);
            } else {
                System.out.println("OK");

            }

        }

    }
}
