import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int T, R, C;
    static char[][] arr;
    static boolean[][] v;
    static int[] alpha;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int test = 1;test <= T;test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            arr = new char[R][C];
            v = new boolean[R][C];
            alpha = new int[26];

            for(int i  = 0;i < R;i++) {
                String str = br.readLine();
                for(int j = 0;j < C;j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            result = Integer.MIN_VALUE;
            v[0][0] = true;
            alpha[arr[0][0] - 'A']++;
            dfs(0, 0, 1);

            System.out.println("#" + test + " " + result);
        }
    }

    public static void dfs(int x, int y, int cnt) {
        if(alpha[arr[x][y] - 'A'] > 1) {
            result = Math.max(result, cnt - 1);
            return;
        }

        for(int i = 0;i < 4;i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newX < R && newY >= 0  && newY < C && !v[newX][newY]) {
                v[newX][newY] = true;
                ++alpha[arr[newX][newY] - 'A'];
                dfs(newX, newY, cnt + 1);
                --alpha[arr[newX][newY] - 'A'];
                v[newX][newY] = false;
            }
        }
        result = Math.max(result, cnt);
    }

}