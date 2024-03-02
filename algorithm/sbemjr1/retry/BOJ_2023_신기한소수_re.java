package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2023_신기한소수_re {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		
		recursive(0,N);
	}

	private static void recursive(int val, int n) {
		if(n == 0) {
			System.out.println(val);
			return;
		}
		for (int i = 1; i < 10; i++) {
			int num = val*10 + i;
			if(isPrime(num)) {
				recursive(num, n - 1);
			}
		}
	}

	private static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i <= (int) Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
