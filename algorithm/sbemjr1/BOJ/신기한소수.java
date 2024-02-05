package sbemjr1.BOJ;

import java.util.Iterator;
import java.util.Scanner;

public class 신기한소수 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		recursive(0,N);
	}
		
	private static void recursive(int val, int n) {
		// basis part
		if (n == 0) {
			System.out.println(val);
			return;
		}
		//inductive part
		for (int i = 1; i < 10; i++) {
			int num = val*10 + i;
			// 만약에 num이 소수라면 num의 값을 확정하고 다음 재귀로 넘긴다.
			if (isPrime(num)) {
				recursive(num, n-1);
			}
		}
	}

	private static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i*i <= num; i++) {
			if (num%i == 0) {
				return false;
			}
		}
		return true;
	}
}
