import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split("");
        int sum = 0;

        Deque<String> deque = new ArrayDeque<>();

        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("(")) {                       // 현재 배열의 값이 여는 괄호라면 덱에 푸쉬
                deque.push("(");
            } else {
                if (str[i - 1].equals(")")) {               // 현재 배열의 값이 닫는 괄호이고, 이전 배열의 값이 닫는 괄호라면 팝 해준 후 1추가
                    deque.pop();
                    sum += 1;
                } else {                                    // 현재 배열의 값이 닫는 괄호이고, 이전 배열의 값이 여는 괄호라면 현재 덱의 사이즈 만큼 값 더해줌
                    deque.pop();
                    sum += deque.size();
                }
            }
        }

        sb.append(sum);
        System.out.println(sb);
    }
}
