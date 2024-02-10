package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_1493_수의새로운연산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[] p1 = getPoint(p);
            int[] p2 = getPoint(q);

            int[] newPoint = new int[]{p1[0] + p2[0], p1[1] + p2[1]};
            System.out.println("#" + tc + " " + getResult(newPoint));
        }
    }

    static int dr = -1;
    static int dc = 1;

    private static int[] getPoint(int point) {
        int r = 1;
        int c = 1;
        int cnt = 1;
        for (int i = 0; i < point-1; i++) {
            r += dr;
            c += dc;
            if (r == 0) {
                cnt++;
                r = cnt;
                c = 1;
            }
        }
        return new int[] {r, c};
    }

    private static int getResult(int[] targetPoint) {
        int targetR = targetPoint[0];
        int targetC = targetPoint[1];
        int r = 1;
        int c = 1;
        int cnt = 1;
        int result = 1;
        while (true) {
            result++;
            r += dr;
            c += dc;
            if (r == 0) {
                cnt++;
                r = cnt;
                c = 1;
            }
            if (r == targetR && c == targetC) {
                return result;
            }
        }
    }
}
