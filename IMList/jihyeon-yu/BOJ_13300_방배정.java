package imlist;

import java.util.Scanner;

public class BOJ_13300_방배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K  = sc.nextInt();
		int[][] arr = new int[6][2];
		
		for (int n = 1; n <= N; n++) {
			int S = sc.nextInt(); // 0 여 1 남
			int Y = sc.nextInt(); // 1~6 학년
			arr[Y-1][S]++;
		}
		
		int room = 0;
		
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 2; c++) {
				if(arr[r][c] == 0) {
					continue;
				}
				else if(arr[r][c] > K) {
					room += arr[r][c] / K + 1;
				} else {
					room++;
				}
			}
		}
		System.out.println(room);
	}

}
