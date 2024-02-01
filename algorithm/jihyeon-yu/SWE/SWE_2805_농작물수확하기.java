package jihyeon;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class 농작물수확하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for (int t = 1; t <= test_case; t++) {
			int n = sc.nextInt();
			int[][] grid = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = sc.next();
				for (int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(str.charAt(j)+"");
				}
			}
			
			int sum = 0;
			int start = n/2;
			int end = n/2;
			
			for (int i = 0; i < n; i++) {
				for (int j = start; j <= end; j++) {
					sum += grid[i][j];
				}
				if (i < n/2) {
					start--;
					end++;
				} else {
					start++;
					end--;
				}
			}
			System.out.printf("#%d %d", t, sum);
		}
	}
}
