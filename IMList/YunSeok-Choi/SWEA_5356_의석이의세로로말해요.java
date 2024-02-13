import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5356_의석이의세로로말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder ans = new StringBuilder();

            String[] fir;
            String[] sec;
            String[] thi;
            String[] fou;
            String[] fif;

            String[] str = br.readLine().split("");
            fir = str;
            String[] str1 = br.readLine().split("");
            sec = str1;
            String[] str2 = br.readLine().split("");
            thi = str2;
            String[] str3 = br.readLine().split("");
            fou = str3;
            String[] str4 = br.readLine().split("");
            fif = str4;

            for (int i = 0; i < 15; i++) {
                if (fir.length > i && fir[i] != null) {
                    ans.append(fir[i]);
                }
                if (sec.length > i && sec[i] != null) {
                    ans.append(sec[i]);
                }
                if (thi.length > i && thi[i] != null) {
                    ans.append(thi[i]);
                }
                if (fou.length > i && fou[i] != null) {
                    ans.append(fou[i]);
                }
                if (fif.length > i && fif[i] != null) {
                    ans.append(fif[i]);
                }
            }
            System.out.println("#" + test_case + " " + ans);

        }


    }
}
