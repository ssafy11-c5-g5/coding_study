package coding_study.algorithm.Sanizzang;

import java.util.Scanner;

class Pos {
    int x;
    int y;
    int head; // 전차가 바라보는 방향 1 - 위 2 - 오른쪽 3 - 아래 4 - 왼쪽

    Pos(int x, int y, int head) {
        this.x = x;
        this.y = y;
        this.head = head;
    }
}

public class SWE_1873_상호의배틀필드 {

    static int H;
    static int W;
    static char[][] arr;
    static int N;
    static char[] input;
    static int[][] shot = {{,},{-1,0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test = 1;test <= T;test++) {
            H = sc.nextInt();
            W = sc.nextInt();

            Pos pos = new Pos(0,0,0);

            arr = new char[H][W];

            for(int i = 0;i < H;i++) {
                String str = sc.next();
                for(int j = 0;j < W;j++) {
                    arr[i][j] = str.charAt(j);
                    if(arr[i][j] == '^') {
                        pos = new Pos(i, j, 1);
                    }
                    else if(arr[i][j] == '>') {
                        pos = new Pos(i, j, 2);
                    }
                    else if(arr[i][j] == 'v') {
                        pos = new Pos(i, j, 3);
                    }
                    else if(arr[i][j] == '<') {
                        pos = new Pos(i, j, 4);
                    }
                }
            }

            N = sc.nextInt();
            input = new char[N];

            String str = sc.next();
            for(int i = 0;i < N;i++) {
                input[i] = str.charAt(i);
            }

            for(int i = 0;i < N;i++) {
                char ch = input[i];

                switch(ch) {
                    case 'U':
                        pos.head = 1;
                        arr[pos.x][pos.y] = '^';
                        int newX1 = pos.x - 1;
                        if(newX1 >= 0 && arr[newX1][pos.y] == '.') {
                            arr[pos.x][pos.y] = '.';
                            arr[newX1][pos.y] = '^';
                            pos.x = newX1;
                        }
                        break;
                    case 'D':
                        pos.head = 3;
                        arr[pos.x][pos.y] = 'v';
                        int newX2 = pos.x + 1;
                        if(newX2 < H && arr[newX2][pos.y] == '.') {
                            arr[pos.x][pos.y] = '.';
                            arr[newX2][pos.y] = 'v';
                            pos.x = newX2;
                        }
                        break;
                    case 'L':
                        pos.head = 4;
                        arr[pos.x][pos.y] = '<';
                        int newY1 = pos.y - 1;
                        if(newY1 >= 0 && arr[pos.x][newY1] == '.') {
                            arr[pos.x][pos.y] = '.';
                            arr[pos.x][newY1] = '<';
                            pos.y = newY1;
                        }
                        break;
                    case 'R':
                        pos.head = 2;
                        arr[pos.x][pos.y] = '>';
                        int newY2 = pos.y + 1;
                        if(newY2 < W && arr[pos.x][newY2] == '.') {
                            arr[pos.x][pos.y] = '.';
                            arr[pos.x][newY2] = '>';
                            pos.y = newY2;
                        }
                        break;
                    case 'S':
                        int x = shot[pos.head][0];
                        int y = shot[pos.head][1];
                        int newX = pos.x + x;
                        int newY = pos.y + y;
                        while(newX >= 0 && newX < H && newY >=0 && newY < W) {
                            if(arr[newX][newY] == '#') {
                                break;
                            }
                            if(arr[newX][newY] == '*') {
                                arr[newX][newY] = '.';
                                break;
                            }
                            newX += x;
                            newY += y;
                        }
                        break;
                }
            }

            System.out.print("#" + test + " ");
            for(int i = 0;i < H;i++) {
                for(int j = 0;j < W;j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }

        }
    }
}
