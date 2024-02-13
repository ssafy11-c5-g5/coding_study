import java.util.Scanner;

class SWEA_7236_저수지의물의총깊이구하기 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            String[][] map = new String[n][n];

            int[] dy = {1, -1, 0, 0, -1, -1, 1, 1};
            int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
            int max = 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.next();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j].equals("G")) {
                        continue;
                    }
                    int sum = 0;
                    for (int k = 0; k < 8; k++) {
                        int ny = dy[k] + i;
                        int nx = dx[k] + j;
                        if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                            if (map[ny][nx].equals("W")) {
                                sum++;
                            }
                        }
                    }
                    max = Math.max(sum, max);
                }
            }

            System.out.println("#" + test_case + " " + max);

        }
    }
}