import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16935_배열돌리기3 {

    static int n;
    static int m;
    static int r;
    static int[][] map;
    static int[][] temp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmr = br.readLine().split(" ");
        n = Integer.parseInt(nmr[0]);
        m = Integer.parseInt(nmr[1]);
        r = Integer.parseInt(nmr[2]);
        map = new int[n][m];
        temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");        // 입력 배열 초기화
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                temp[i][j] = map[i][j];
            }
        }

        String[] p = br.readLine().split(" ");

        for (int i = 0; i < r; i++) {                   // 각 입력에 맞는 연산
            int q = Integer.parseInt(p[i]);
            if (q == 1) {
                number1();
            } else if (q == 2) {
                number2();
            } else if (q == 3) {
                number3();
            } else if (q == 4) {
                number4();
            } else if (q == 5) {
                number5();
            } else if (q == 6) {
                number6();
            }
        }

        insertArray(temp);
        System.out.println(sb);

    }

    private static void number6() {         // 연산 6번
        temp = leftGroup(temp);
    }

    private static int[][] leftGroup(int[][] arr) {
        int nl = arr.length / 2;
        int ml = arr[0].length / 2;
        int[][] one = new int[arr.length][arr[0].length];

        for (int i = 0; i <= nl; i += nl) {
            for (int j = 0; j <= ml; j += ml) {
                if (i == 0 && j == 0) {                     // 2구역의 값을 1구역으로
                    for (int k = 0; k < nl; k++) {
                        for (int t = 0; t < ml; t++) {
                            one[i + k][j + t] = arr[k][t + ml];
                        }
                    }
                } else if (i == 0 && j == ml) {             // 3구역의 값을 2구역으로
                    for (int k = 0; k < nl; k++) {
                        for (int t = 0; t < ml; t++) {
                            one[i + k][j + t] = arr[k + nl][t + ml];
                        }
                    }

                } else if (i == nl && j == 0) {             // 1구역의 값을 4구역으로
                    for (int k = 0; k < nl; k++) {
                        for (int t = 0; t < ml; t++) {
                            one[i + k][j + t] = arr[k][t];
                        }
                    }

                } else if (i == nl && j == ml) {            // 4구역의 값을 3구역으로
                    for (int k = 0; k < nl; k++) {
                        for (int t = 0; t < ml; t++) {
                            one[i + k][j + t] = arr[i + k][t];
                        }
                    }
                }
            }
        }
        return one;
    }

    private static void number5() {         // 연산 5번
        temp = rightGroup(temp);
    }

    private static int[][] rightGroup(int[][] arr) {
        int nl = arr.length / 2;
        int ml = arr[0].length / 2;
        int[][] one = new int[arr.length][arr[0].length];

        for (int i = 0; i <= nl; i += nl) {
            for (int j = 0; j <= ml; j += ml) {
                if (i == 0 && j == 0) {
                    for (int k = 0; k < nl; k++) {                      // 4구역의 값을 1구역으로
                        for (int t = 0; t < ml; t++) {
                            one[i + k][j + t] = arr[nl + k][j + t];
                        }
                    }
                } else if (i == 0 && j == ml) {                         // 1구역의 값을 2구역으로
                    for (int k = 0; k < nl; k++) {
                        for (int t = 0; t < ml; t++) {
                            one[i + k][j + t] = arr[k][t];
                        }
                    }

                } else if (i == nl && j == 0) {                         // 3구역의 값을 4구역으로
                    for (int k = 0; k < nl; k++) {
                        for (int t = 0; t < ml; t++) {
                            one[i + k][j + t] = arr[nl + k][ml + t];
                        }
                    }

                } else if (i == nl && j == ml) {                        // 2구역의 값을 3구역으로
                    for (int k = 0; k < nl; k++) {
                        for (int t = 0; t < ml; t++) {
                            one[i + k][j + t] = arr[k][j + t];
                        }
                    }
                }
            }
        }
        return one;
    }

    private static void number4() {                 // 연산 4번
        temp = left90(temp);
    }

    private static int[][] left90(int[][] arr) {
        int[][] one = new int[arr[0].length][arr.length];
        for (int i = 0; i < one.length; i++) {
            for (int j = 0; j < one[0].length; j++) {
                one[i][j] = arr[j][one.length - i - 1];             // 원래의 배열이 회전을 하면서 가로 세로 길이가 바뀔 수 있기 때문에 그 값을 인지하면서 계산
            }
        }
        return one;
    }

    private static void number3() {             // 연산 3번
        temp = right90(temp);
    }

    private static int[][] right90(int[][] arr) {
        int[][] one = new int[arr[0].length][arr.length];
        for (int i = 0; i < one.length; i++) {
            for (int j = 0; j < one[0].length; j++) {
                one[i][j] = arr[one[0].length - j - 1][i];         // 원래의 배열이 회전을 하면서 가로 세로 길이가 바뀔 수 있기 때문에 그 값을 인지하면서 계산
            }
        }
        return one;
    }

    private static void number2() {             // 연산 2번
        temp = leftRightMirror(temp);
    }

    private static int[][] leftRightMirror(int[][] arr) {
        int[][] one = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                one[i][j] = arr[i][arr[0].length - j - 1];          // 좌우 반전
            }
        }
        return one;
    }

    private static void number1() {             // 연산 1번
        temp = upDownMirror(temp);
    }

    private static int[][] upDownMirror(int[][] arr) {
        int[][] one = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                one[i][j] = arr[arr.length - i - 1][j];             // 상하 반전
            }
        }
        return one;
    }

    private static void insertArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
    }

}
