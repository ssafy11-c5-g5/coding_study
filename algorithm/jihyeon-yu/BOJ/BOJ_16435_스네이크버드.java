package practice;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16435_스네이크버드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int[] height = new int[N];
		for (int i = 0; i < N; i++) {
			height[i] = sc.nextInt();
		}
		Arrays.sort(height);
		
		for (int i = 0; i < height.length; i++) {
			if(L >= height[i]) L++;
		}
		
		System.out.println(L);
	}

}
