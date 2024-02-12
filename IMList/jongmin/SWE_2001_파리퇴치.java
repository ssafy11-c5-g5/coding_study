package algorithm.im;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_2001_파리퇴치 {

    static int[][] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc < T+1; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            graph = new int[N][N];
            for(int i = 0; i < N; i++) {
                graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int ans = 0;

            for (int i = 0; i < N-M+1; i++) {
                for (int j = 0; j < N-M+1; j++) {
                    int count = 0;
                    for (int k = i; k < i+M; k++) {
                        for (int l = j; l < j+M; l++) {
                            System.out.println(k + " " + l);
                            count += graph[k][l];
                        }
                    }

                    ans = Math.max(count, ans);
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}

