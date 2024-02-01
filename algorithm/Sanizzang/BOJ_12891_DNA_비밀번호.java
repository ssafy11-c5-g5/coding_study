import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891_DNA_비밀번호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 문자열의 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이

        int[] comp = new int[4];
        char[] charArr = new char[S];
        String str = br.readLine();
        for(int i = 0;i < S;i++) {
            char ch = str.charAt(i);
            charArr[i] = ch;
            if(i < P) {
                switch (ch) {
                    case 'A':
                        ++comp[0];
                        break;
                    case 'C':
                        ++comp[1];
                        break;
                    case 'G':
                        ++comp[2];
                        break;
                    case 'T':
                        ++comp[3];
                        break;
                }
            }
        }

        int[] security = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < 4;i++) {
            security[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        if(comp[0] >= security[0] && comp[1] >= security[1] && comp[2] >= security[2] && comp[3] >= security[3]) {
            cnt++;
        }

        for(int i = P;i < S;i++) {
            char ch1 = charArr[i - P];
            switch (ch1) {
                case 'A':
                    --comp[0];
                    break;
                case 'C':
                    --comp[1];
                    break;
                case 'G':
                    --comp[2];
                    break;
                case 'T':
                    --comp[3];
                    break;
            }
            char ch2 = charArr[i];
            switch (ch2) {
                case 'A':
                    ++comp[0];
                    break;
                case 'C':
                    ++comp[1];
                    break;
                case 'G':
                    ++comp[2];
                    break;
                case 'T':
                    ++comp[3];
                    break;
            }
            if(comp[0] >= security[0] && comp[1] >= security[1] && comp[2] >= security[2] && comp[3] >= security[3]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

