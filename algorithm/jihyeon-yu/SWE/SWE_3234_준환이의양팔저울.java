package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//모든 무게 추를 양팔저울 위에 올리는 순서 N!가지 : 순열
// 각 추를 양팔저울의 왼쪽에 올릴 것인지 오른쪽에 올릴 것인지 결정 2^N가지
// 무게의 총합 왼 >= 오

public class SWE_3234_준환이의양팔저울 {
	static int T, N, Ans;
	static int[] weight, sel;
	static boolean[] visit;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			weight = new int[N];
			sel = new int[N];
			visit = new boolean[N];
			for (int i = 0; i < N; i++) {
				weight[i] = sc.nextInt();
			}
			Ans = 0;
			balanceCount(0);
			System.out.println("#" + t + " " + Ans);
		}
	}
	private static void balanceCount(int k) {
		if(k == N) {
			combination(0, 0, 0, 0, 0, sel);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				sel[k] = weight[i];
				balanceCount(k+1);
				visit[i] = false;
			}
		}
	}
	
	private static void combination(int selIdx, int leftIdx, int rightIdx, int leftSum, int rightSum, int[] sel) {
		if(leftSum < rightSum) return;
		if(leftIdx + rightIdx == N) {
			Ans++;
			return;
		}
		
		if(selIdx == N) return;
		
		combination(selIdx+1, leftIdx+1, rightIdx, leftSum + sel[selIdx], rightSum, sel); // 왼팔 저울에 올리는 경우
		combination(selIdx+1, leftIdx, rightIdx+1, leftSum, rightSum + sel[selIdx], sel); // 오른팔 저울에 올리는 경우
	}
}
