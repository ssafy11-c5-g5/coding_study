import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class SWEA_1974_스쿠쿠검증 {

    static int[][] map;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static boolean check = true;;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            map = new int[9][9];
            check = true;

            for (int i = 0; i < 9; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }

            for (int i = 0; i < 9; i++) {
                checkRow(i);
            }

            if (!check) {
                System.out.println("#" + test_case + " " + 0);
                continue;
            }

            for (int i = 0; i < 9; i++) {
                checkColumn(i);
            }

            if (!check) {
                System.out.println("#" + test_case + " " + 0);
                continue;
            }

            for (int i = 1; i < 9; i += 3) {
                for (int j = 1; j < 9; j += 3) {
                    checkSquare(i, j);
                }
            }

            if (!check) {
                System.out.println("#" + test_case + " " + 0);
            } else {
                System.out.println("#" + test_case + " " + 1);
            }

        }

    }

    private static void checkSquare(int i, int j) {
        int sum = 0;
        sum += map[i][j];
        for (int k = 0; k < 8; k++) {
            int ny = dy[k] + i;
            int nx = dx[k] + j;
            sum += map[ny][nx];
        }
        if (sum != 45) {
            check = false;
        }
    }

    private static void checkColumn(int idx) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += map[i][idx];
        }
        if (sum != 45) {
            check = false;
        }
    }

    private static void checkRow(int idx) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += map[idx][i];
        }
        if (sum != 45) {
            check = false;
        }
    }

}
