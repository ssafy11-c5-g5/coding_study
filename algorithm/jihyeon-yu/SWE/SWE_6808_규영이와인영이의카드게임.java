package practice;

import java.util.Scanner;

public class SWE_6808_규영이와인영이의카드게임 {
	static int[] iCard, kCard, sel;
	static boolean[] visit;
	static int win, lose;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		for (int t = 1; t <= T; t++) {
			iCard = new int[9]; // 인영
			kCard = new int[9]; // 규영
			sel = new int[9];
			visit = new boolean[9];
			for (int i = 0; i < 9; i++) {
				kCard[i] = sc.nextInt();
			}
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				boolean isContain = true;
				for (int k : kCard) {
					if(k == i) {
						isContain = false;
						break;
					}
				}
				if(isContain) {
					iCard[idx++] = i;
				}
			}
			win = 0;
			lose = 0;
			permutation(0);
			System.out.println("#" + t + " " + win + " " + lose);
		}
	}
	
	static void permutation(int k) {
		if(k == 9) {
			if(kWin(kCard, sel)) win++;
			else lose++;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if(visit[i] == false) {
				sel[k] = iCard[i];
				visit[i] = true;
				permutation(k+1);
				visit[i] = false;
			}
		}
	}
	
	static boolean kWin(int[] kCard, int[] iCard) {
		int kScore = 0;
		int iScore = 0;
		for (int i = 0; i < 9; i++) {
			if(kCard[i] > iCard[i]) {
				kScore += kCard[i] + iCard[i];
			} else {
				iScore += kCard[i] + iCard[i];
			}
		}
		return kScore > iScore ? true : false;
	}

}
