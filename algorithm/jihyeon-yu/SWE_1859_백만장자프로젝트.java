package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1859_백만장자프로젝트_오답 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for (int t = 1; t <= test_case; t++) {
			long income = 0L;
			int num = sc.nextInt();
			int[] prices = new int[num+1];
			for (int i = 0; i < num; i++) {
				int price = sc.nextInt();
				prices[i] = price;
			}
			prices[num] = Integer.MIN_VALUE;
			for (int i = 0; i < num; i++) {
				int[] arr = Arrays.copyOfRange(prices, i+1, prices.length);
				int max = Arrays.stream(arr).max().getAsInt();
				if (prices[i] < max) {
					income += max - prices[i];
				}
			}
			System.out.println("#" + t + " " + income);
		}
	}
}
