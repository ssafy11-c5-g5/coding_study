package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477_참외밭 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int[][] data = new int[6][2];
        for (int i = 0; i < 6; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int dir = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            data[i][0] = dir;
            data[i][1] = length;
        }

        int bigSquare = 0, smallSquare = 0;
        for (int i = 0; i < 6-3; i++) {
            if (data[i][0] == data[i + 2][0] && data[i + 1][0] == data[i + 3][0]) {
                bigSquare = (data[i][1] + data[i+2][1]) * (data[i+1][1] + data[i+3][1]);
                smallSquare = data[i+1][1] * data[i+2][1];
            }
        }
        if (data[0][0] == data[4][0] && data[3][0] == data[5][0]) {
            bigSquare = (data[0][1] + data[4][1]) * (data[3][1] + data[5][1]);
            smallSquare = data[4][1] * data[5][1];
        }
        if (data[0][0] == data[4][0] && data[1][0] == data[5][0]) {
            bigSquare = (data[0][1] + data[4][1]) * (data[1][1] + data[5][1]);
            smallSquare = data[0][1] * data[5][1];
        }
        if (data[0][0] == data[2][0] && data[1][0] == data[5][0]) {
            bigSquare = (data[0][1] + data[2][1]) * (data[1][1] + data[5][1]);
            smallSquare = data[0][1] * data[1][1];
        }

        System.out.println((bigSquare-smallSquare) * K);
    }
}
