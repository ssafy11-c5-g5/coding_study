package Sanizzang;

import java.util.Scanner;

public class BOJ_15649_N과M1 {

	static int N;
    static int M;
    static int[] sel;
    static boolean[] visited;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N + 1];
        sel = new int[M];

        recursive(0);
    }

    public static void recursive(int n) {
        if(n == M) {
            for (int i = 0;i < sel.length;i++) {
                System.out.print(sel[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1;i <= N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                sel[n] = i;
                recursive(n + 1);
                visited[i] = false;
            }
        }
    }

}
