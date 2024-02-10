package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10799_쇠막대기 {

    // ()는 레이저 (  )는 막대
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] array = br.readLine().toCharArray();

        int cnt = 0;
        int stack = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(' && array[i + 1] == ')') {
                cnt+=stack;
            } else if (array[i] == '(') {
                stack++;
            } else if (array[i] == ')' && array[i - 1] == '('){
                continue;
            } else {
                stack--;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
// (())
// 3 4 4 2 3 1 2 2 1 1 1
// 3 7 11 13 16 17 19 21 22 23 24
// (()())