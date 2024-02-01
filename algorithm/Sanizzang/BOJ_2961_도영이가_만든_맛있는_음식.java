import java.util.Scanner;

public class BOJ_2961_도영이가_만든_맛있는_음식 {

    static int N;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N][2];

        for(int i = 0;i < N;i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        recursive(0, 1, 0);
        System.out.println(min);
    }

    public static void recursive(int idx, int sour, int bitter) {
        if(idx == N) {
            if(sour != 1 && bitter != 0) {
                min = Math.min(min, Math.abs(sour - bitter));
            }
            return;
        }

        recursive(idx + 1, sour * arr[idx][0], bitter + arr[idx][1]);
        recursive(idx + 1, sour, bitter);
    }

}