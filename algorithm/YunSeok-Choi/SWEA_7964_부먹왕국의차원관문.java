import java.util.Scanner;

public class Bumuk {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] arr = new int[n];
        int gate = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                k++;
                if (k >= d) {
                    gate++;
                    k = 0;
                }
            } else {
                k = 0;
            }
        }

        System.out.println(gate);

    }

}
