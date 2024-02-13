import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int T, N;
    static int[][] map;
    static boolean[][] visited;
    static int result;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int test = 1;test <= T;test++) {
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            result = 0;

            int days = 0;
            for(int i = 0;i < N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0;j < N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    days = Math.max(days, map[i][j]);
                }
            }

            for(int i = 0;i <= days;i++) {
                visited = new boolean[N][N];
                for(int j = 0;j < N;j++) {
                    for(int k = 0;k < N;k++) {
                        if(map[j][k] == i) {
                            map[j][k] = 0;
                        }
                    }
                }
                int cnt = 0; // 덩어리 개수
                for(int j = 0;j < N;j++) {
                    for(int k = 0;k < N;k++) {
                        if(map[j][k] != 0 && !visited[j][k]) {
                            Queue<int[]> q = new ArrayDeque<>();
                            q.offer(new int[]{j, k});
                            visited[j][k] = true;
                            cnt++;
                            while(!q.isEmpty()) {
                                int[] pos = q.poll();
                                for(int l = 0;l < 4;l++) {
                                    int newX = pos[0] + dx[l];
                                    int newY = pos[1] + dy[l];
                                    if(newX >= 0 && newX < N && newY >= 0 && newY < N && map[newX][newY] != 0 && !visited[newX][newY]) {
                                        q.offer(new int[]{newX, newY});
                                        visited[newX][newY] = true;
                                    }
                                }
                            }
                        }
                    }
                }
                result = Math.max(result, cnt);
            }

            System.out.println("#" + test + " " + result);

        }
    }

}