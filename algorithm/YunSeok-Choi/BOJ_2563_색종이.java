import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2563_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[100][100];

        int n = Integer.parseInt(br.readLine());

        for (int k = 0; k < n; k++) {
            String[] str = br.readLine().split(" ");
            int p = Integer.parseInt(str[0]);
            int q = Integer.parseInt(str[1]);
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {      // 종이 위치에 크기만큼 색칠
                    map[q + i][p + j] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {         // 색칠된 종이 카운트
                if (map[i][j] == 1) {
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }
}
