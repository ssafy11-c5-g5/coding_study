package imlist;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SWEA_2805_농작물수확하기 {
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			for (int r = 0; r < N; r++) {
				String str = sc.next();
				for (int c = 0; c < N; c++) {
					farm[r][c] = Integer.parseInt(str.charAt(c) + "");
				}
			}
			
			int income = 0;
			int start = N/2;
			int end = N/2;
			
			for (int r = 0; r < N; r++) {
				for (int c = start; c <= end; c++) {
					income += farm[r][c];
				}
				if (r < N/2) {
					start--;
					end++;
				} else {
					start++;
					end--;
				}
			}
			System.out.println("#" + t + " " + income);
		}
		
	}

}
