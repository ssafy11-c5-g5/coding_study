package imlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SWE_1860_진기의최고급붕어빵 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[] person = new int[N];
			for (int i = 0; i < N; i++) {
				person[i] = sc.nextInt();
			}
			
			Arrays.sort(person);
			
			boolean isPossible = true;
			int bread = 0;
			int idx = 0;
			int time = 0;
			
			L: while(true) {
				while(time + M > person[idx]) {
					if(bread-- == 0) {
						isPossible = false;
						break L;
					}
					if(idx++ >= N -1) {
						break L;
					}
				}
				time += M;
				bread += K;
			}
			
			System.out.println("#" + t + " " + (isPossible ? "Possible" : "Impossible"));
		}
	}
}
