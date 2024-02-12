import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int T;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int test = 1;test <= T;test++) {
            map = new int[9][9];
            for(int i = 0;i < 9;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0;j < 9;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 1;

            for(int i = 0;i < 9;i++) {
                int columnSum = 0;
                int rowSum = 0;
                for(int j = 0;j < 9;j++) {
                    columnSum += map[i][j];
                    rowSum += map[j][i];
                }
                if(columnSum != 45 || rowSum != 45) {
                    result = 0;
                    break;
                }
            }

            if(result != 0) {
                for(int i = 0;i < 9;i += 3) {
                    for(int j = 0;j < 9;j += 3) {
                        int squareSum = 0;
                        for(int k = i;k < i + 3;k++) {
                            for(int l = j;l < j + 3;l++) {
                                squareSum += map[k][l];
                            }
                        }
                        if(squareSum != 45) {
                            result = 0;
                            break;
                        }
                    }
                }
            }

            System.out.println("#" + test + " " + result);
        }
    }

}