import java.util.Scanner;

public class BOJ_2615_오목 {

    static int[][] map = new int[19][19];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dy = {1, 2, 3, 4, 5};
        int[] dx = {0, 0, 0, 0, 0};
        int[] ry = {0, 0, 0, 0, 0};
        int[] rx = {1, 2, 3, 4, 5};
        int[] ryx = {1, 2, 3, 4, 5};
        int[] lsy = {1, 2, 3, 4, 5};
        int[] lsx = {-1, -2, -3, -4, -5};

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        L:
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] == 1 || map[i][j] == 2) {
                    int ny = i - 1;
                    int nx = j - 1;

                    if (ny >= 0 && nx >= 0 && (map[i][j] != map[ny][nx])) {
                        boolean down = check(dy, dx, i, j);
                        boolean right = check(ry, rx, i, j);
                        boolean rightSide = check(ryx, ryx, i, j);

                        if (down || right || rightSide) {
                            System.out.println(map[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            break L;
                        }
                    }

                    ny = i - 1;
                    nx = j + 1;
                    if (ny >= 0 && nx < 19 && (map[i][j] != map[ny][nx])) {
                        boolean leftSide = check(lsy, lsx, i, j);
                        if (leftSide) {
                            System.out.println(map[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            break L;
                        }
                    }
                }
            }
            if (i == 18) {
                System.out.println(0);
            }
        }


    }

    static boolean check(int[] dy, int[] dx, int i, int j) {
        for (int k = 0; k < dy.length; k++) {
                int ny = i + dy[k];
                int nx = j + dx[k];
                if (ny >= 0 && nx >= 0 && ny < 19 && nx < 19) {
                    if (k == dy.length - 1) {
                        if (map[ny][nx] != map[i][j]) {
                            return true;
                        }
                        return false;
                    } else if (map[ny][nx] != map[i][j]) {
                        return false;
                    }
                } else if (nx >= 19) {

                }
//                else if (ny < 19 && nx < 19 && (k == dy.length - 1)) {
//                    return true;
//                }
//                else {
//                    return false;
//                }

        }
        return false;
    }

}
