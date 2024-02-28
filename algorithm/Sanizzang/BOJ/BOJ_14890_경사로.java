import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        for(int i = 0;i < N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j < N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        for(int i = 0;i < N;i++) {
            boolean[] v = new boolean[N];
            boolean flag = true;
            L:for(int j = 1;j < N;j++) {
                if(map[i][j - 1] + 1 == map[i][j]) {
                    for(int k = 1;k <= L;k++) {
                        int newC = j - k;
                        if(newC < 0 || map[i][newC] != map[i][j - 1] || v[newC]) {
                            flag = false;
                            break L;
                        }
                        else {
                            v[newC] = true;
                        }
                    }
                }
                else if(map[i][j - 1] - 1 == map[i][j]) {
                    for(int k = 0;k < L;k++) {
                        int newC = j + k;
                        if(newC >= N || map[i][newC] != map[i][j] || v[newC]) {
                            flag = false;
                            break L;
                        }
                        else {
                            v[newC] = true;
                        }
                    }
                }
                else if(map[i][j - 1] == map[i][j]) {
                }
                else{
                    flag = false;
                    break L;
                }
            }
            if(flag) cnt++;
        }

        for(int i = 0;i < N;i++) {
            boolean[] v = new boolean[N];
            boolean flag = true;
            L:for(int j = 1;j < N;j++) {
                if(map[j - 1][i] + 1 == map[j][i]) {
                    for(int k = 1;k <= L;k++) {
                        int newR = j - k;
                        if(newR < 0 || map[newR][i] != map[j - 1][i] || v[newR]) {
                            flag = false;
                            break L;
                        }
                        else {
                            v[newR] = true;
                        }
                    }
                }
                else if(map[j - 1][i] - 1 == map[j][i]) {
                    for(int k = 0;k < L;k++) {
                        int newR = j + k;
                        if(newR >= N || map[newR][i] != map[newR][i] || v[newR]) {
                            flag = false;
                            break L;
                        }
                        else {
                            v[newR] = true;
                        }
                    }
                }
                else if(map[j - 1][i] == map[j][i]) {
                }
                else{
                    flag = false;
                    break L;
                }
            }
            if(flag) cnt++;
        }


        System.out.println(cnt);
    }
}
