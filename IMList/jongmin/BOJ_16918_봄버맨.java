package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_16918_봄버맨 {

    /**
     * 폭탄은 3초 후에 폭발
     * 폭발 후 -> 빈 칸
     * 폭발 시에 인접칸에 폭탄이 있는 경우 파괴 = 연쇄 반응 x
     *
     * 봄버맨의 행동
     * 1. 첫 폭탄의 설치 시간은 같음 (0초)
     * 2. 다음 1초 동안 정지 (1초)
     * 3. 다음 1초 동안 폭탄 없는 곳에 폭탄 설치 (2초)
     * 4. 1초 후에 3초전 폭탄이 폭발? (3초 펑!)
     * 5. 3, 4 반복
     *
     * (폭발 시에 인접 칸에 폭탄이 있는 경우 파괴)
     */

    static int R, C, N;
    static char[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = line[0];
        C = line[1];
        N = line[2];

        graph = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                graph[i][j] = row[j];
            }
        }

        bomberman();

        printGraphReal();
    }

    // 총 시간 N 계산하는 변수
    static int cnt = 1;
    private static void bomberman() {
        while (true) {
            if (cnt == N) break;
            makeTempBomb();
            //printGraph();
            if (cnt == N) break;
            bomb();
            makeBomb();
            //printGraph();
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};


    // 폭탄이 터짐 (1초)
    private static void bomb() {
        cnt++;
        // 폭탄 위치(포인트)를 기억하는 리스트
        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == 'O') {
                    points.add(new int[] {i, j});
                }
            }
        }

        for (int[] point : points) {
            bombMakeField(point[0], point[1]);
        }

    }

    //폭탄으로 인한 평탄화(bomb method 에 의존)
    private static void bombMakeField(int r, int c) {
        graph[r][c] = '.';

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            } else {
                graph[nr][nc] = '.';
            }
        }
    }

    //새로 설치된 폭탄을 터질 준비가 되도록 만듬 (0초)
    private static void makeBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == 'T') {
                    graph[i][j] = 'O';
                }
            }
        }
    }

    //폭탄과 새로 설치된 폭탄을 구분하기 위한 메서드
    //평탄한 땅에 새로운 폭탄을 설치한다. (1초 소요)
    private static void makeTempBomb() {
        cnt++;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == '.') {
                    graph[i][j] = 'T';
                }
            }
        }
    }

    // 그래프 출력용
    private static void printGraph() {
        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
        System.out.println();
    }

    // 정답 출력용
    private static void printGraphReal() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == 'T') {
                    sb.append('O');
                } else{
                    sb.append(graph[i][j]);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}

