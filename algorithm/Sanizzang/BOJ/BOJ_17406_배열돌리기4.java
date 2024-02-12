import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Turn {
    int r;
    int c;
    int s;

    Turn(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
    }
}

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static int M;
    static int K;
    static Turn[] turnArr;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        turnArr = new Turn[K];
        visited = new boolean[K];

        for(int i = 1;i <= N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j <= M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0;i < K;i++) {
            st = new StringTokenizer(br.readLine());
            turnArr[i] = new Turn(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        recursive(map, 0);
        System.out.println(result);

    }

    public static void recursive(int[][] map, int cnt) {
        if(cnt == K) {
            result = Math.min(result, minSum(map));
            return;
        }

        for(int i = 0;i < K;i++) {
            if(!visited[i]) {
                visited[i] = true;
                recursive(turnFunc(map, turnArr[i]), cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static int[][] turnFunc(int[][] map, Turn turn) {
        int[][] temp = new int[N + 1][M + 1];
        for(int i = 1;i <= N;i++) {
            for(int j = 1;j <= M;j++) {
                temp[i][j] = map[i][j];
            }
        }

        for(int i = 1;i <= turn.s;i++) {
            int x = turn.r - i;
            int y = turn.c - i;

            for(int j = 0;j < 4;j++) {
                for(int k = 0;k < i * 2;k++) {
                    x += dx[j];
                    y += dy[j];
                    temp[x][y] = map[x - dx[j]][y - dy[j]];
                }
            }
        }

        return temp;
    }

    private static int minSum(int[][] map) {
        int returnVal = Integer.MAX_VALUE;
        for(int i = 1;i <= N;i++) {
            int sum = 0;
            for(int j = 1;j <= M;j++) {
                sum += map[i][j];
            }
            returnVal = Math.min(returnVal, sum);
        }
        return returnVal;
    }
}