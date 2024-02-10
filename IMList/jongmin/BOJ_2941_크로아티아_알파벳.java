package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941_크로아티아_알파벳 {

    static char[] word;
    static int N;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine().toCharArray();
        N = word.length;
        result = N;

        for (int i = 0; i < N; i++) {
            check(i);
        }

        System.out.println(result);
    }

    private static void check(int i) {
        if (i < N-1 && word[i] == 'c' && word[i + 1] == '=') {
            result--;
        } else if (i < N-1 && word[i] == 'c' && word[i + 1] == '-') {
            result--;
        } else if (i < N-2 && word[i] == 'd' && word[i + 1] == 'z' && word[i + 2] == '=') {
            result-=2;
        } else if (i < N-1 && word[i] == 'd' && word[i + 1] == '-') {
            result--;
        } else if (i < N-1 && word[i] == 'l' && word[i + 1] == 'j') {
            result--;
        } else if (i < N-1 && word[i] == 'n' && word[i + 1] == 'j') {
            result--;
        } else if (i < N-1 && word[i] == 's' && word[i + 1] == '=') {
            result--;
        } else if (i < N-1 &&  i > 0 && word[i-1] == 'd' && word[i] == 'z' && word[i + 1] == '=') {

        } else if (i < N-1 && word[i] == 'z' && word[i + 1] == '=') {
            result--;
        }
    }
}
