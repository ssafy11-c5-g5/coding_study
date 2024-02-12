package algorithm;

import java.util.Scanner;

public class SWEA_7964_부먹왕국의차원관문 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for (int t = 1; t <= test_case; t++) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			int[] arr = new int[n];
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				int door = sc.nextInt();
				arr[i] = door;
			}
			int dChecker = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 0 && i == 0) {
					cnt++;
					continue;
				}
				if (arr[i] == 0) {
					dChecker++;
				} else {
					dChecker = 0;
				}
				if (dChecker == d) {
					cnt++;
					dChecker = 0;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

}
