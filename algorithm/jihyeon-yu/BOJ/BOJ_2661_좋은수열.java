package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 초과나 메모리 초과가 나면 탈출 조건을 확실하게 확인하자!
// 리턴으로만 recursive를 바로 탈출할 수 없다.
public class BOJ_2661_좋은수열 {
	static int N;
	static boolean flag;
	static String num, Ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Ans = null;
		flag = false;
		recursive("");
		System.out.println(Ans);
	}

	private static void recursive(String num) {
		if(flag) return;
		if(checkBadProgression(num)) return;
		
		// 수열의 길이가 N이 되면 최소값으로 초기화
		if(num.length() == N) {
			Ans = num;
			flag = true;
			return;
		}
		
		for (int i = 1; i <= 3; i++) {
			// 나쁜 수열인지 확인
			recursive(num + i);
		}
		
	}

	private static boolean checkBadProgression(String num) {
		for (int i = 1; i <= num.length() / 2; i++) {
			String a = num.substring(num.length()-2*i, num.length()-i);
			String b = num.substring(num.length()-i, num.length());
			if(a.equals(b)) return true;
		}
		return false;
	}

}
