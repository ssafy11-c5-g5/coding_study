package imlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_27984_조커_다시보기 {
/*
 	S: 0은 클로버, 1은 다이아몬드, 2는 하트, 3은 스페이드를 의미한다.
 	R: 1은 에이스, 2~10은 숫자, 11은 잭, 12는 퀸, 13은 킹을 의미한다.
 	
	straight flush: 무늬가 같고 숫자가 연속적인 5장의 카드
	quadruple: 숫자가 같은 4장의 카드
	full house: 숫자가 같은 3장의 카드와, 숫자가 같은 나머지 2장의 카드
	flush: 무늬가 같은 5장의 카드
	straight: 숫자가 연속적인 5장의 카드
	triple: 숫자가 같은 3장의 카드
	two pair: 2개의 pair
	pair: 숫자가 같은 2장의 카드
*/
	static int differentCardNum;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int[][] pocker = new int[4][2];
		for (int i = 0; i < 4; i++) {
			pocker[i][0] = sc.nextInt(); // s, 카드 무늬
			pocker[i][1] = sc.nextInt(); // r, 카드 숫자
		}
		
		
		System.out.println(isFullHouse(pocker));
	}
	
	public static boolean isStraightFlush(int[][] pocker) {
		boolean answer = true;
		for (int i = 1; i < 4; i++) {
			if(pocker[0][0] != pocker[i][0]) {
				answer =  false;
				break;
			}
		}
		return answer;
	}
	
	public static boolean isQuadruple(int[][] pocker) {
		boolean answer = true;
		for (int i = 0; i < 4; i++) {
			if(pocker[0][1] != pocker[i][1]) {
				answer = false;
				break;
			}
		}
		return answer;
	}
			
	public static boolean isFullHouse(int[][] pocker) {
		Arrays.sort(pocker, (o1, o2) -> {
			return o1[1] - o2[1];
		});
		for (int i = 0; i < pocker.length; i++) {
			System.out.println(Arrays.toString(pocker[i]));
		}
		int sameCnt = 0;
		differentCardNum = 0;
		for (int i = 0; i < 4; i++) {
			if(pocker[1][1] == pocker[i][1]) sameCnt++;
			else differentCardNum = pocker[i][1];
		}
		if(sameCnt == 3) return true;
		else return false;
	}
	
	public static boolean isFlush(int[][] pocker) {
		boolean answer = true;
		for (int i = 1; i < 4; i++) {
			if(pocker[0][0] != pocker[i][0]) {
				answer =  false;
				break;
			}
		}
		return answer;
	} 
	

}
