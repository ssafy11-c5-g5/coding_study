import java.util.Scanner;

public class BOJ_13300_방배정 {

    public static void print(int i, int cnt, int[] se, int s, int y) {
        System.out.println(i + ": i  " + cnt + " : cnt  " + se[y] + ": s[" + y + "]  " + s + ": s  " + y + ": y");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] man = new int[7];
        int[] girl = new int[7];

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int y = sc.nextInt();

            if (s == 0) {
                if (girl[y] == 0) {
                    cnt++;
                    girl[y]++;
                } else if (girl[y] >= k) {
                    cnt++;
                    girl[y] = 1;
                } else {
                    girl[y]++;
                }
            } else {
                if (man[y] == 0) {
                    cnt++;
                    man[y]++;
                } else if (man[y] >= k) {
                    cnt++;
                    man[y] = 1;
                } else {
                    man[y]++;
                }
            }

        }
        System.out.println(cnt);

    }

}
