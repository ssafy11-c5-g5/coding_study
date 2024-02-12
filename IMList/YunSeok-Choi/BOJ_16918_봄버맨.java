import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16918_봄버맨 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rcn = br.readLine().split(" ");

        int r = Integer.parseInt(rcn[0]);
        int c = Integer.parseInt(rcn[1]);
        int n = Integer.parseInt(rcn[2]);

        String[][] full = new String[r][c];
        String[][] arr = new String[r][c];
        String[][] odd = new String[r][c];
        String[][] after = new String[r][c];
        String[][] temp = full;
        String[][] before;

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        for (int i = 0; i < r; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                arr[i][j] = input[j];       // 입력 맵,
                odd[i][j] = "O";         // 3초후 터지는 맵,
                full[i][j] = "O";          // 짝수에 폭탄이 다 터지는 맵
                after[i][j] = "O";      // 5초후 터지는 맵
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j].equals("O")) {
                    odd[i][j] = ".";
                    for (int k = 0; k < dy.length; k++) {
                        int ny = dy[k] + i;
                        int nx = dx[k] + j;
                        if (ny < r && ny >= 0 && nx < c && nx >= 0) {
                            odd[ny][nx] = ".";
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (odd[i][j].equals("O")) {
                    after[i][j] = ".";
                    for (int k = 0; k < dy.length; k++) {
                        int ny = dy[k] + i;
                        int nx = dx[k] + j;
                        if (ny < r && ny >= 0 && nx < c && nx >= 0) {
                            after[ny][nx] = ".";
                        }
                    }
                }
            }
        }

        before = odd;
        int k = 4;
        if (n % 2 == 0) {           // 짝수는 항상 폭탄이 다 차있음
            temp = full;
        } else if (n > 4) {         // 5초 이상이라면 : 숫자를 카운팅하며, 만들어둔 맵을 돌아가며 참조
            while (k < n) {
                k++;
                if (temp == full) {
                    if (before == odd) {
                        before = after;
                        temp = after;
                    } else if (before == after) {
                        before = odd;
                        temp = odd;
                    }
                } else {
                    temp = full;
                }
            }
        } else {
            if (n == 1) {
                temp = arr;
            } else if (n == 3) {
                temp = odd;
            } else {
                temp = full;
            }
        }
        printArray(temp);
        System.out.println(sb);

    }

    static void printArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
    }
}
