import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());
        int result = 0;

        int[][] arr = new int[100][100];

        /**
         * 단순하게 2중 for문을 통해 색종이의 면적을 구했다.
         */
        for(int i = 0;i < loop;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int k = y - 1;k < y + 9;k++) {
                for(int j = x - 1;j < x + 9;j++) {
                    // 색종이 면적에 포함되어있지 않다면 실행
                    if(arr[k][j] != 1) {
                        arr[k][j] = 1;
                        result += 1;
                    }
                }
            }
        }

        System.out.println(result);
    }
}