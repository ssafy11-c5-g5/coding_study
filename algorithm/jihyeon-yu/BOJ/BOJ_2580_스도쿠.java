package complete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class BOJ_2580_스도쿠_backtracking {
	static int[][] sdoku;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		sdoku = new int[9][9];
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				sdoku[r][c] = sc.nextInt();
			}
		}

		fillSdoku(0, 0);
		print(sdoku);
	}
	
	private static void fillSdoku(int row, int col) {
		if(col == 9) {
			fillSdoku(row+1, 0);
			return;
		}
		
		if(row == 9) {
			print(sdoku);
			System.exit(0);
		}
		
		if(sdoku[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if(isPossible(row, col, i)) {
					sdoku[row][col] = i;
					fillSdoku(row, col+1);
				}
			}
			sdoku[row][col] = 0;
			return;
		}
		fillSdoku(row, col+1);
	}

	private static boolean isPossible(int r, int c, int i) {
		// row check
		for (int j = 0; j < 9; j++) {
			if(sdoku[r][j] == i) return false;
		}
		
		// col check
		for (int j = 0; j < 9; j++) {
			if(sdoku[j][c] == i) return false;
		}
		
		// block check
		int rBlock = (r / 3) * 3;
		int cBlock = (c / 3) * 3;
		for (int j = rBlock; j < rBlock+3; j++) {
			for (int k = cBlock; k < cBlock+3; k++) {
				if(sdoku[j][k] == i) return false;
			}
		}
		return true;
	}

	
	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
