import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Pos {
    int x;
    int y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    // 사분탐색
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static boolean[][] visited; // 방문 체크 배열
    static int[][] arr; // Aij 저장 배열
    static Pos[] position; // 각 번호(Aij)의 위치 저장 배열
    static int N; // 방 크기
    static int resultRoomId; // 최종 방번호
    static int resultMovement; // 최종 최대 이동 횟수

    /**
     * 이 문제의 경우 1~N 개의 숫자가 주어지고 Aij의 값이 서로 다른 수임을 주목하여 풀었다.
     * 각 Aij(1~N) 값의 위치를 입력할 때 저장(Pos[])하고 1부터 시작해 사분탐색을 통해
     * 각 방 이동횟수를 카운팅하여 최대이동횟수를 저장하였다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 입력

        for(int test = 1;test <= T;test++) {
            N = Integer.parseInt(br.readLine()); // 배열 크기
            visited = new boolean[N][N]; // 방문 배열 초기화
            position = new Pos[N * N + 1]; // 각 번호 위치 저장 배열 초기화

            resultRoomId = Integer.MAX_VALUE;
            resultMovement = Integer.MIN_VALUE;

            arr = new int[N][N];

            for(int i = 0;i < N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0;j < N;j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] = num;
                    position[num] = new Pos(i, j);
                }
            }
            // 1 ~ N 까지
            for(int i = 1;i <= N * N;i++) {
                Pos currentPos = position[i];
                int firstX = currentPos.x;
                int firstY = currentPos.y;

                int currentX = currentPos.x;
                int currentY = currentPos.y;

                if(!visited[currentX][currentY]) {
                    int cnt = 1;

                    Deque<int[]> dq = new ArrayDeque<>();

                    visited[currentX][currentY] = true;
                    dq.push(new int[]{currentX, currentY});

                    while(!dq.isEmpty()) {
                        int[] pos = dq.pop();

                        for(int k = 0;k < 4;k++) {
                            int newX = pos[0] + dx[k];
                            int newY = pos[1] + dy[k];
                            // 지도에서 벗어나지 않고, 방문하지 않고, 현재 좌표 값 + 1 == 새로운 좌표 값이면 실행
                            if(newX >= 0 && newX < N && newY >= 0 && newY < N && !visited[newX][newY] && ((arr[currentX][currentY] + 1) == arr[newX][newY])) {
                                cnt++;
                                visited[newX][newY] = true;
                                dq.push(new int[]{newX, newY});
                                currentX = newX;
                                currentY = newY;
                                break;
                            }
                        }
                    }
                    if(resultMovement == cnt) {
                        resultRoomId = Math.min(resultRoomId, arr[firstX][firstY]);
                    }
                    else if(resultMovement < cnt) {
                        resultMovement = cnt;
                        resultRoomId = arr[firstX][firstY];
                    }
                }
            }

            System.out.println("#" + test + " " + resultRoomId + " " + resultMovement);
        }
    }
}
