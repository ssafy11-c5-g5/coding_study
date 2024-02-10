package algorithm.im;

import java.util.Scanner;

public class SWE_1873_상호의_배틀필드 {

    //0=L, 1=R, 2=U, 3=D
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static char[][] graph;
    static int H;
    static int W;
    static char[] commands;
    static int curR;
    static int curC;
    static int dir;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int idx = 1; idx < T + 1; idx++) {
            H = sc.nextInt();
            W = sc.nextInt();
            graph = new char[H][W];
            for (int i = 0; i < H; i++) {
                graph[i] = sc.next().toCharArray();
            }

            init();

//            for (int i = 0; i < H; i++) {
//                System.out.println(Arrays.toString(graph[i]));
//            }

            int N = sc.nextInt();
            commands = sc.next().toCharArray();

            for (char command : commands) {
                if (command == 'S') {
                    shoot();
                } else {
                    changeDirAndMove(command);
                }
            }

            setTank();
            System.out.print("#" + idx + " ");
            for (int i = 0; i < H; i++) {
                String line = new String(graph[i]);
                System.out.println(line);
            }
        }

    }

    public static void init() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (graph[i][j] == '<') {
                    dir = 0;
                    curR = i;
                    curC = j;
                    graph[i][j] = '.';
                    break;
                } else if (graph[i][j] == '>') {
                    dir = 1;
                    curR = i;
                    curC = j;
                    graph[i][j] = '.';
                    break;
                } else if (graph[i][j] == '^') {
                    dir = 2;
                    curR = i;
                    curC = j;
                    graph[i][j] = '.';
                    break;
                } else if (graph[i][j] == 'v') {
                    dir = 3;
                    curR = i;
                    curC = j;
                    graph[i][j] = '.';
                    break;
                }
            }
        }
    }


    public static void shoot() {
        int r = curR;
        int c = curC;
        while (true) {
            if (r < 0 || r >= H || c < 0 || c >= W || graph[r][c] == '#') {
                break;
            }

            if (graph[r][c] == '*') {
                graph[r][c] = '.';
                break;
            }
            r += dr[dir];
            c += dc[dir];
        }
    }

    public static void changeDirAndMove(char command) {
        if (command == 'L') {
            dir = 0;
        } else if (command == 'R') {
            dir = 1;
        } else if (command == 'U') {
            dir = 2;
        } else if (command == 'D') {
            dir = 3;
        }
        move();
    }

    public static void move() {
        int r = curR + dr[dir];
        int c = curC + dc[dir];
        if (r < 0 || r >= H || c < 0 || c >= W || graph[r][c] == '#') {
            return;
        }
        if (graph[curR + dr[dir]][curC + dc[dir]] == '.') {
            curR += dr[dir];
            curC += dc[dir];
        }
    }

    public static void setTank() {
        if (dir == 0) {
            graph[curR][curC] = '<';
        } else if (dir == 1) {
            graph[curR][curC] = '>';
        } else if (dir == 2) {
            graph[curR][curC] = '^';
        } else if (dir == 3) {
            graph[curR][curC] = 'v';
        }
    }
}
