import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if(r == 0 && c == 0) {
                break;
            }

            map = new int[r][c];
            visited = new boolean[r][c];

            for(int i = 0;i < r;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0;j < c;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for(int i = 0;i < r;i++) {
                for(int j = 0;j < c;j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        result += 1;
                        Queue<int[]> q = new ArrayDeque<>();
                        q.offer(new int[]{i, j});
                        while(!q.isEmpty()) {
                            int[] pos = q.poll();

                            for(int k = 0;k < 8;k++) {
                                int newX = pos[0] + dx[k];
                                int newY = pos[1] + dy[k];

                                if(newX >= 0 && newX < r && newY >= 0 && newY < c && map[newX][newY] == 1 &&!visited[newX][newY]) {
                                    visited[newX][newY] = true;
                                    q.offer(new int[]{newX, newY});
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(result);
        }


    }
}