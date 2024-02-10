package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SWE_1218_괄호_짝짓기 {
    static int N;

    public static void main(String[] args) throws IOException {
        Map<Character, Character> dic = new HashMap<>();
        dic.put(')', '(');
        dic.put('}', '{');
        dic.put(']', '[');
        dic.put('>', '<');

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            Stack<Character> stack = new Stack<>();
            N = Integer.parseInt(br.readLine());
            String line = br.readLine();

            int ans = 1;
            for (int i = 0; i < N; i++) {
                char tmp = line.charAt(i);
                if (dic.get(tmp) == null) {
                    stack.push(tmp);
                } else {
                    if (stack.peek() == dic.get(tmp)) {
                        stack.pop();
                    } else {
                        ans = 0;
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
