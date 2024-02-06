import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int cnt = 0;
        int result = 0;
        for(int i = 1;i < str.length();i++) {
            if(str.charAt(i - 1) == '(' && str.charAt(i) == '(') {
                result += 1;
                cnt += 1;
            }
            else if(str.charAt(i - 1) == '(' && str.charAt(i) == ')') {
                result += cnt;
            }
            else if(str.charAt(i - 1) == ')' && str.charAt(i) == ')') {
                cnt -= 1;
            }
        }

        System.out.println(result);


    }
}