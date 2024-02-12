package imlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ_1859_백만장자프로젝트 {

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			long income = 0;
			int max = arr[N-1];
			for (int i = N - 2; i >= 0; i--) {
				if(max > arr[i]) income += max - arr[i];
				else max = arr[i];
			}
			System.out.println("#" + t + " " + income);
		}
	}

}
