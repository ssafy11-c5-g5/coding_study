package complete;

import java.util.Scanner;

public class BOJ_10162_전자레인지_greedy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 1의 자리가 0이 아니면 -1 출력
		if(N % 10 != 0) System.out.println(-1);
		else {
			// A 300초 B 60초 C 10초
			int[] button = {300, 60, 10};
			int[] click = new int[3]; // A, B, C
			for(int i = 0; i < 3; i++) {
				click[i] = N / button[i];
				N %= button[i];
			} 
			
			for (int i = 0; i < 3; i++) {
				System.out.print(click[i] + " ");
			}
		}
	}
}
