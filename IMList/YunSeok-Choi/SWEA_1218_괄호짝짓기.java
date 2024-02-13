import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Character, Character> bs = new HashMap<>();
        bs.put('(', ')');
        bs.put('[', ']');
        bs.put('{', '}');
        bs.put('<', '>');

        int n = Integer.parseInt(br.readLine());
        char[] s = new char[n];
        Stack<Character> stack = new Stack<>();
        s = br.readLine().toCharArray();

        for (int i = 0; i < n; i++) {
            if (s[i] == '(' || s[i] == '{' || s[i] == '[' || s[i] == '<') {        // 시작 괄호는 pop할 필요 없이 스택에 삽입
                stack.push(s[i]);
            } else if (stack.isEmpty() ||bs.get(stack.pop()) != s[i]) {            // 닫힘 괄호인데 스택이 비어있거나 같은 문자의 괄호가 아니라면 스택에 값이 있는 상태에서 멈춤
                break;
            }
        }

        if (stack.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
