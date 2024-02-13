package imlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1974_스도쿠검증 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] map = new int[9][9];
		int[] blockIndex = {0, 3, 6};
		for (int t = 1; t <= T; t++) {
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			int[] sortedNum = {1, 2, 3, 4, 5, 6, 7, 8, 9};
			
			
			boolean isValid = true;
			
			L : while(true) {
				// row check
				for (int r = 0; r < 9; r++) {
					int[] row = Arrays.copyOf(map[r], map[r].length);
					Arrays.sort(row);
					if(!Arrays.toString(row).equals(Arrays.toString(sortedNum))) {
						isValid = false;
						break L;
					}
				}
				 // column check
				for (int c = 0; c < 9; c++) {
					int[] cols = new int[9];
					for (int r = 0; r < 9; r++) {
						cols[r] = map[r][c];
					}
					Arrays.sort(cols);
					if(!Arrays.toString(cols).equals(Arrays.toString(sortedNum))) {
						isValid = false;
						break L;
					}
				}
				
				// block check
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						int idx = 0;
						int[] block = new int[9];
						for (int r = blockIndex[i]; r < blockIndex[i]+3; r++) {
							for (int c = blockIndex[j]; c < blockIndex[j]+3; c++) {
								block[idx++] = map[r][c];
							}
						}
						Arrays.sort(block);
						if(!Arrays.toString(block).equals(Arrays.toString(sortedNum))) {
							isValid = false;
							break L;
						}
					}
				}
				break;
			}
			if(isValid) System.out.println("#" + t + " " + 1);
			else System.out.println("#" + t + " " + 0);
		}
	}

}
