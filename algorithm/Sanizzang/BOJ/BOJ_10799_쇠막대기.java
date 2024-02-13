import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int cnt = 0; // 쇠막대기 갯수
        int result = 0; // 최종 결과 값

        /**
         * 쇠막대기가 처음 나오면 1개를 추가하고
         * 그 뒤로 레이저를 통해 중첩된 쇠막대기를 자르면 현재 쇠막대기 수(cnt) 만큼 추가
         */
        for(int i = 1;i < str.length();i++) {
            // 현재 쇠막대기 수 +1, 결과 값 추가 +1
            if(str.charAt(i - 1) == '(' && str.charAt(i) == '(') {
                result += 1;
                cnt += 1;
            }
            // 레이저로 자를시 현재 쇠막대기 만큼 결과 값 추가
            else if(str.charAt(i - 1) == '(' && str.charAt(i) == ')') {
                result += cnt;
            }
            // 쇠막대기가 끝나면 쇠막대기 수 -1
            else if(str.charAt(i - 1) == ')' && str.charAt(i) == ')') {
                cnt -= 1;
            }
        }

        System.out.println(result);


    }
}