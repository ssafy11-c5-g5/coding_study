package imlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ_2985_롤케이크 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] piece = new int[L];
		int[] expect = new int[N];
		int[] actual = new int[N];
		for (int i = 0; i < N; i++) {
			int p = sc.nextInt();
			int k = sc.nextInt();
			int actualNum = 0;
			for (int n = p-1; n <= k-1; n++) {
				if(piece[n] == 0) {
					piece[n]++;
					actualNum++;
				}
			}
			expect[i] = k - p + 1;
			actual[i] = actualNum;
		}
		
		System.out.println(getMaxIndex(expect)+1);
		System.out.println(getMaxIndex(actual)+1);

		
	}
	
	public static int getMaxIndex(int[] arr) {
		int max = arr[0];
		int maxIndex = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}

}
