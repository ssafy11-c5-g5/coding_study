package algorithm.hw.hw0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3 {

    static int[][] graph, group1, group2, group3, group4;
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] commandLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < R; i++) {
            if (commandLine[i] == 1) {
                command1();
            } else if (commandLine[i] == 2) {
                command2();
            } else if (commandLine[i] == 3) {
                command3();
            } else if (commandLine[i] == 4) {
                command4();
            } else if (commandLine[i] == 5) {
                command5();
            } else if (commandLine[i] == 6) {
                command6();
            }
        }

        printGraph();
    }

    private static void command1() {
        for (int j = 0; j < M; j++) {
            int[] col = new int[N];
            for (int i = 0; i < N; i++) {
                col[i] = graph[N-i-1][j];
            }
            for (int i = 0; i < N; i++) {
                graph[i][j] = col[i];
            }
        }
    }

    private static void command2() {
        for (int i = 0; i < N; i++) {
            int[] row = new int[M];
            for (int j = 0; j < M; j++) {
                row[j] = graph[i][M - j - 1];
            }
            for (int j = 0; j < M; j++) {
                graph[i][j] = row[j];
            }
        }
    }

    private static void command3() {
        int[][] temp = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[j][N - i - 1] = graph[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;

        graph = temp;
    }

    private static void command4() {
        int[][] temp = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[M - 1 - j][i] = graph[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;

        graph = temp;
    }

    private static void makeGroup() {
        group1 = new int[N/2][M/2];
        group2 = new int[N/2][M/2];
        group3 = new int[N/2][M/2];
        group4 = new int[N/2][M/2];

        // group1
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                group1[i][j] = graph[i][j];
            }
        }
        // group2
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                group2[i][j] = graph[i][j + M / 2];
            }
        }
        // group3
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                group3[i][j] = graph[i + N / 2][j + M / 2];
            }
        }
        // group4
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                group4[i][j] = graph[i + N / 2][j];
            }
        }
    }

    private static void command5() {
        makeGroup();
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                graph[i][j] = group4[i][j];
            }
        }

        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                graph[i][j + M / 2] = group1[i][j];
            }
        }

        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                graph[i + N / 2][j + M / 2] = group2[i][j];
            }
        }

        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                graph[i + N / 2][j] = group3[i][j];
            }
        }
    }

    private static void command6() {
        makeGroup();
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                graph[i][j] = group2[i][j];
            }
        }

        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                graph[i][j + M / 2] = group3[i][j];
            }
        }

        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                graph[i + N / 2][j + M / 2] = group4[i][j];
            }
        }

        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                graph[i + N / 2][j] = group1[i][j];
            }
        }
    }

    private static void printGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void printGroup(int[][] group) {
        for (int i = 0; i < N/2; i++) {
            System.out.println(Arrays.toString(group[i]));
        }
        System.out.println();
    }
}
