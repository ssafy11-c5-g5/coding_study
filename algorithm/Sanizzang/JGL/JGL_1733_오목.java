package Sanizzang;
import java.util.Scanner;

// 좌표 클래스
class Pos {
    int x;
    int y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class JGL_1733_오목 {


    public static void main(String[] args) throws Exception {
        //여기에 코드를 작성하세요.
        // 검은색 - 1, 흰색 -2, 알이 놓이지 않은 자리 0

        Scanner sc = new Scanner(System.in);

        // 오목판 저장 배열
        int[][] arr = new int[20][20];

        // 오목판 입력
        for(int i = 1;i < 20;i++) {
            for(int j = 1;j < 20;j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 0 - 오른쪽, 1 - 오른쪽 아래 대각선 , 2 - 아래, 3 - 오른쪽 위 대각선
        Pos[][] pos = {{new Pos(0, 1), new Pos(0, 2), new Pos(0, 3), new Pos(0, 4), new Pos(0, 5)},
                {new Pos(1, 1), new Pos(2, 2), new Pos(3, 3), new Pos(4, 4) , new Pos(5, 5)},
                {new Pos(1, 0), new Pos(2, 0), new Pos(3, 0), new Pos(4, 0), new Pos(5, 0)},
                {new Pos(-1, 1), new Pos(-2, 2), new Pos(-3, 3), new Pos(-4, 4) , new Pos(-5, 5)}};

        winner(arr, pos);

    }

    private static void winner(int[][] arr, Pos[][] pos) {
        for(int i = 1;i < 20;i++) {
            for(int j = 1;j < 20;j++) {
                /*
                 * 현재 좌표 기준 오른쪽, 오른쪽 대각선, 아래가 같은 바둑알이 있는지 확인
                 */
                for(int k = 0;k < 4;k++) {
                    int x = i;
                    int y = j;
                    if(arr[x][y] == 0) {
                        break;
                    }
                    int newX1 = x + pos[k][0].x;
                    int newY1 = y + pos[k][0].y;
                    int newX2 = x + pos[k][1].x;
                    int newY2 = y + pos[k][1].y;
                    int newX3 = x + pos[k][2].x;
                    int newY3 = y + pos[k][2].y;
                    int newX4 = x + pos[k][3].x;
                    int newY4 = y + pos[k][3].y;

                    /*
                     * 새로운 좌표가 오목판을 넘어서지 않는지 확인 후 승리자 확인
                     * 만약 5목이 아닌 6목 이상인지 예외처리
                     */
                    if(newY1 >= 0 && newX1 < 20 && newY1 < 20 &&  newY2 >= 0 && newX2 < 20 && newY2 < 20 && newY3 >= 0 && newX3 < 20 && newY3 < 20 && newY4 >= 0 && newX4 < 20 && newY4 < 20) {
                        if(arr[x][y] == 1 && arr[newX1][newY1] == 1 && arr[newX2][newY2] == 1 && arr[newX3][newY3] == 1 && arr[newX4][newY4] == 1) {
                            int newX5 = x + pos[k][4].x;
                            int newY5 = y + pos[k][4].y;
                            if(newY5 >= 0 && newX5 < 20 && newY5 < 20 && arr[newX5][newY5] == 1) {
                                continue;
                            }
                            int newX6 = x - pos[k][0].x;
                            int newY6 = y - pos[k][0].y;
                            if(newY6 >= 0 && newX6 < 20 && newY6 < 20 && arr[newX6][newY6] == 1) {
                                continue;
                            }

                            System.out.println(1);
                            System.out.println(x + " " + y);
                            return;

                        }
                        else if(arr[x][y] == 2 && arr[newX1][newY1] == 2 && arr[newX2][newY2] == 2 && arr[newX3][newY3] == 2 && arr[newX4][newY4] == 2) {
                            int newX5 = x + pos[k][4].x;
                            int newY5 = y + pos[k][4].y;
                            if(newY5 >= 0 && newX5 < 20 && newY5 < 20 && arr[newX5][newY5] == 2) {
                                continue;
                            }
                            int newX6 = x - pos[k][0].x;
                            int newY6 = y - pos[k][0].y;
                            if(newY6 >= 0 && newX6 < 20 && newY6 < 20 && arr[newX6][newY6] == 2) {
                                continue;
                            }
                            System.out.println(2);
                            System.out.println(x + " " + y);
                            return;

                        }
                    }
                }
            }
        }

        // 아무도 승리자가 없을시 0 출력
        System.out.println(0);
    }
}