import java.util.Scanner;

public class SWE_1954_달팽이 숫자 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test = 1;test <= T;test++) {
            int N = sc.nextInt();
            int[][] result = new int[N][N];

            int x = 0;
            int y = 0;
            int idx = 0;

            for(int i = 1;i <= N * N;i++) {
                result[x][y] = i;
                int newX = x + dx[idx];
                int newY = y + dy[idx];
                if(newX < 0 || newX >= N || newY < 0 || newY >= N || result[newX][newY] != 0) {
                    idx++;
                    if(idx == 4) {
                        idx = 0;
                    }
                }
                x += dx[idx];
                y += dy[idx];
            }

            System.out.println("#" + test);
            for(int i = 0;i < N;i++) {
                for(int j = 0;j < N;j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
