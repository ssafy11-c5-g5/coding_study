package homework;

import java.util.Arrays;
import java.util.Scanner;

public class N과M1 {
	// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
	static Scanner sc = new Scanner(System.in);
	static int n = sc.nextInt(), m = sc.nextInt();
	static int[] arr = new int[n];
	static int[] sel = new int[m];
	static boolean[] v = new boolean[n];
	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		
		recursive(0);
	}
	
	public static void recursive(int k) {
		if(k==sel.length) {
			// basis part
			// 선택 완료
			System.out.println(Arrays.toString(sel).replace("[", "").replace("]", "").replace(",", ""));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[k] = arr[i];
				recursive(k+1);
				v[i] = false;
				
			}
		}
	}
}