import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int test = 1;test <= T;test++) {
           int N = Integer.parseInt(br.readLine());
           int[] weight = new int[N];

           StringTokenizer st = new StringTokenizer(br.readLine());

           for (int i = 0;i < N;i++) {
               weight[i] = Integer.parseInt(st.nextToken());
           }

           result = 0;
           recursive(0, 0, 0, 0, weight, N);
           sb.append("#" + test + " " + result + '\n');
        }
        System.out.println(sb);
    }

    static void recursive(int v,int selLeft, int selRight, int cnt, int[] weight, int N) {
        if(cnt == N) {
            result++;
            return;
        }

        for(int i = 0;i < N;i++) {
            if((v & (1 << i)) == 0) {
                recursive(v | (1 << i),selLeft + weight[i], selRight, cnt + 1, weight, N);
                if(selLeft >= selRight + weight[i]) {
                    recursive(v | (1 << i), selLeft, selRight + weight[i], cnt + 1, weight, N);
                }
            }
        }
    }

}