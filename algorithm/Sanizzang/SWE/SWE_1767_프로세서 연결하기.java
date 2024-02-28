import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static class Core {
        int r;
        int c;

        Core(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int maxCore;
    static int length;
    static int N;
    static int[][] map;
    static ArrayList<Core> coreList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            coreList = new ArrayList<>();

            for(int i = 0;i < N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0;j < N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1) {
                        coreList.add(new Core(i, j));
                    }
                }
            }

            maxCore = Integer.MIN_VALUE;
            length = Integer.MAX_VALUE;
            recursive(0, 0, 0);
            System.out.println("#" + test + " " + length);
        }
    }

    private static void recursive(int idx, int coreCnt, int l) {
        if(idx == coreList.size()) {
            if(maxCore < coreCnt) {
                maxCore = coreCnt;
                length = l;
            }
            else if(maxCore == coreCnt) {
                length = Math.min(length, l);
            }
            return;
        }

        Core core = coreList.get(idx);
        if(core.r == 0 || core.c == 0 || core.r == N - 1 || core.c == N - 1) {
            recursive(idx + 1, coreCnt + 1, l);
        }
        else {
            for(int i = 0;i < 4;i++) {
                int currentR = core.r;
                int currentC = core.c;
                boolean flag = false;
                while(true) {
                    currentR += dr[i];
                    currentC += dc[i];
                    if(currentR >= 0 && currentR < N && currentC >= 0 && currentC < N && map[currentR][currentC] != 1) {
                        if(currentR == 0 || currentR == N - 1  || currentC == 0 || currentC == N - 1) {
                            flag = true;
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }

                if(flag) {
                    currentR = core.r;
                    currentC = core.c;
                    int cnt = 0;
                    while(true) {
                        currentR += dr[i];
                        currentC += dc[i];
                        if(currentR >= 0 && currentR < N && currentC >= 0 && currentC < N) {
                            map[currentR][currentC] = 1;
                            cnt++;
                        }
                        else {
                            break;
                        }
                    }
                    recursive(idx + 1, coreCnt + 1, l + cnt);

                    currentR = core.r;
                    currentC = core.c;
                    while(true) {
                        currentR += dr[i];
                        currentC += dc[i];
                        if(currentR >= 0 && currentR < N && currentC >= 0 && currentC < N) {
                            map[currentR][currentC] = 0;
                        }
                        else {
                            break;
                        }
                    }
                }
            }
            recursive(idx + 1, coreCnt, l);
        }
    }

    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

}