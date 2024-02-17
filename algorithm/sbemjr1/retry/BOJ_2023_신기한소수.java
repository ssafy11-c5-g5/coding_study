package sbemjr1.retry;

import java.util.Scanner;

public class BOJ_2023_신기한소수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 1*(int)Math.pow(10, N-1); i < 10*(int)Math.pow(10, N-1); i++) {
			if(check(i)) {
				if(recursive(i)) {
					System.out.println(i);
				}
			}
		}
	}

	private static boolean recursive(int num) {
		if (num == 0) {
			return true;
		}
		
		if(check(num)) {
			if(recursive(num/10)) return true;
		}
		
		return false;
	}

	private static boolean check(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i <= (int) Math.sqrt(num); i++) {
			if (num%i == 0) {
				return false;
			}
		}
		return true;
	}

}
