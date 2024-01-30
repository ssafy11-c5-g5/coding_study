import java.util.Scanner;

public class BOJ_11729_하노이탑이동순서 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(Math.pow(2, n) - 1);

        hanoi(n,1,2, 3);

    }

    static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            System.out.println(start + " " + end);
            return;
        }
        hanoi(n - 1, start, end, mid);
        System.out.println(start + " " + end);
        hanoi(n - 1, mid, start, end);
    }

}
