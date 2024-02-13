import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_8382_방향전환 {

    static int cnt = 1;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int x1, y1, x2, y2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            int min = Integer.MAX_VALUE;

            String[] str = br.readLine().split(" ");
            x1 = Integer.parseInt(str[0]);
            y1 = Integer.parseInt(str[1]);
            x2 = Integer.parseInt(str[2]);
            y2 = Integer.parseInt(str[3]);

            if (x1 < x2 && y1 < y2) {
                int m = move(3, cnt);
                cnt = 0;
                int n = move(1, cnt);
                min = Math.min(m, n);
            } else if (x1 > x2 && y1 > y2) {
                int m = move(2, cnt);
                cnt = 0;
                int n = move(0, cnt);
                min = Math.min(m, n);
            } else if (x1 < x2 && y1 > y2) {
                int m = move(3, cnt);
                cnt = 0;
                int n = move(0, cnt);
                min = Math.min(m, n);
            } else if (x1 > x2 && y1 < y2) {
                int m = move(2, cnt);
                cnt = 0;
                int n = move(1, cnt);
                min = Math.min(m, n);
            } else if (x1 == x2) {
                int m = 0;
                if (y1 > y2) {
                    m = move(0, cnt);
                } else {
                    m = move(1, cnt);
                }
                min = m;
            } else if (y1 == y2) {
                int m = 0;
                if (x1 > x2) {
                    m = move(2, cnt);
                } else {
                    m = move(3, cnt);
                }
                min = m;
            }

            System.out.println("#" + test_case + " " + min);

        }

    }

    private static int move(int direct, int cnt) {

        x1 += dx[direct];
        y1 += dy[direct];

        if (x1 == x2 && y1 == y2) {
            return cnt;
        }

        if (direct == 0 || direct == 1) {
            if (x1 < x2) {
                move(3, cnt + 1);
            } else {
                move(2, cnt + 1);
            }
        } else if (direct == 2 || direct == 3) {
            if (y1 < y2) {
                move(1, cnt + 1);
            } else {
                move(0, cnt + 1);
            }
        }

        return cnt;
    }


}
